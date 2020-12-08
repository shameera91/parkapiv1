package com.dublin.parkapi.controller;

import com.dublin.parkapi.dto.ApiResponse;
import com.dublin.parkapi.dto.DeleteParkDTO;
import com.dublin.parkapi.dto.DublinCityParkUpdateDTO;
import com.dublin.parkapi.dto.DunLaoghaireUpdateDTO;
import com.dublin.parkapi.dto.FingalCountryUpdateDTO;
import com.dublin.parkapi.dto.UserLoginInputDTO;
import com.dublin.parkapi.service.ParkService;
import com.dublin.parkapi.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/parks")
public class ParkController {

	@Autowired
	private ParkService parkService;

	@Autowired
	private UsersService usersService;

	@PostMapping("/get-dublin-city-council")
	public ResponseEntity getDublinCityCouncilData(@RequestBody UserLoginInputDTO userLoginInputDTO){
		if(usersService.getByUserNameAndPassword(userLoginInputDTO)){
			return ResponseEntity.ok(parkService.getDublinCityParkDetails());
		}else{
			return new ResponseEntity(new ApiResponse("User name or password incorrect"), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/get-fingal-country-council")
	public ResponseEntity getFingalCountryCouncilData(@RequestBody UserLoginInputDTO userLoginInputDTO){
		if(usersService.getByUserNameAndPassword(userLoginInputDTO)){
			return ResponseEntity.ok(parkService.getFingalCountryCouncilData());
		}else{
			return new ResponseEntity(new ApiResponse("User name or password incorrect"), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/get-dun-laoghaire")
	public ResponseEntity getDunLaoghaireData(@RequestBody UserLoginInputDTO userLoginInputDTO){
		if(usersService.getByUserNameAndPassword(userLoginInputDTO)) {
			return ResponseEntity.ok(parkService.getDunLaoghaireData());
		}else{
			return new ResponseEntity(new ApiResponse("User name or password incorrect"), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/update/dublin-city-council")
	public ResponseEntity updateDublinCityParkDetails(@RequestBody DublinCityParkUpdateDTO dublinCityParkUpdateDTO){
		if(usersService.getByUserNameAndPasswordAndRole(dublinCityParkUpdateDTO.getUsername(),dublinCityParkUpdateDTO.getPassword())){
			parkService.updateDublinCityPark(dublinCityParkUpdateDTO);
			return ResponseEntity.ok().build();
		}else{
			return new ResponseEntity(new ApiResponse("Only admin user can perform update operations"), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/update/fingal-country-council")
	public ResponseEntity updateFingalCountryCouncilDetails(@RequestBody FingalCountryUpdateDTO fingalCountryUpdateDTO){
		if(usersService.getByUserNameAndPasswordAndRole(fingalCountryUpdateDTO.getUsername(),fingalCountryUpdateDTO.getPassword())){
			parkService.updateFingalCountry(fingalCountryUpdateDTO);
			return ResponseEntity.ok().build();
		}else{
			return new ResponseEntity(new ApiResponse("Only admin user can perform update operations"), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/update/dun-laoghaire")
	public ResponseEntity updateDunLaoghaireDetails(@RequestBody DunLaoghaireUpdateDTO dunLaoghaireUpdateDTO){
		if(usersService.getByUserNameAndPasswordAndRole(dunLaoghaireUpdateDTO.getUsername(),dunLaoghaireUpdateDTO.getPassword())){
			parkService.updateDunLaoghaire(dunLaoghaireUpdateDTO);
			return ResponseEntity.ok().build();
		}else{
			return new ResponseEntity(new ApiResponse("Only admin user can perform update operations"), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/delete/dublin-city-council")
	public ResponseEntity deleteDublinCityParkDetails(@RequestBody DeleteParkDTO deleteParkDTO){
		if(usersService.getByUserNameAndPasswordAndRole(deleteParkDTO.getUsername(),deleteParkDTO.getPassword())){
			parkService.deleteDublinCityParkDetails(deleteParkDTO.getId());
			return ResponseEntity.ok().build();
		}else{
			return new ResponseEntity(new ApiResponse("Only admin user can perform delete operation"), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/delete/fingal-country-council")
	public ResponseEntity deleteFingalCountryCouncilDetails(@RequestBody DeleteParkDTO deleteParkDTO){
		if(usersService.getByUserNameAndPasswordAndRole(deleteParkDTO.getUsername(),deleteParkDTO.getPassword())){
			parkService.deleteFingalCountryCouncilDetails(deleteParkDTO.getId());
			return ResponseEntity.ok().build();
		}else{
			return new ResponseEntity(new ApiResponse("Only admin user can perform delete operation"), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/delete/dun-laoghaire")
	public ResponseEntity deleteDunLaoghaireDetails(@RequestBody DeleteParkDTO deleteParkDTO){
		if(usersService.getByUserNameAndPasswordAndRole(deleteParkDTO.getUsername(),deleteParkDTO.getPassword())){
			parkService.deleteDunLaoghaireDetails(deleteParkDTO.getId());
			return ResponseEntity.ok().build();
		}else{
			return new ResponseEntity(new ApiResponse("Only admin user can perform delete operation"), HttpStatus.BAD_REQUEST);
		}
	}
}
