package com.dublin.parkapi.controller;

import com.dublin.parkapi.dto.ApiResponse;
import com.dublin.parkapi.dto.UserLoginInputDTO;
import com.dublin.parkapi.service.FetchParkDataService;
import com.dublin.parkapi.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fetch")
public class FetchController {

	@Autowired
	private FetchParkDataService fetchParkDataService;

	@Autowired
	private UsersService usersService;

	@PostMapping("/fingal-country-council")
	public ResponseEntity getFingalCountryCouncilData(@RequestBody UserLoginInputDTO userLoginInputDTO){
		if(usersService.getByUserNameAndPasswordAndRole(userLoginInputDTO.getUsername(),userLoginInputDTO.getPassword())){
			fetchParkDataService.getFingalCountryCouncilData();
			return ResponseEntity.ok().build();
		}else{
			return new ResponseEntity(new ApiResponse("Only admin user can perform fetch data operation"), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/dublin-city")
	public ResponseEntity<Void> getDublinCityData(@RequestBody UserLoginInputDTO userLoginInputDTO){
		if(usersService.getByUserNameAndPasswordAndRole(userLoginInputDTO.getUsername(),userLoginInputDTO.getPassword())) {
			fetchParkDataService.getDublinCityData();
			return ResponseEntity.ok().build();
		}else{
			return new ResponseEntity(new ApiResponse("Only admin user can perform fetch data operation"), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/dun-laoghaire")
	public ResponseEntity<Void> getDunLaoghaireData(@RequestBody UserLoginInputDTO userLoginInputDTO){
		if(usersService.getByUserNameAndPasswordAndRole(userLoginInputDTO.getUsername(),userLoginInputDTO.getPassword())) {
			fetchParkDataService.getDunLaoghaireData();
			return ResponseEntity.ok().build();
		}else{
			return new ResponseEntity(new ApiResponse("Only admin user can perform fetch data operation"), HttpStatus.BAD_REQUEST);
		}
	}
}
