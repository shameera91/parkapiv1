package com.dublin.parkapi.controller;

import com.dublin.parkapi.dto.AddNewUserDTO;
import com.dublin.parkapi.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UsersService usersService;

	@PostMapping("/add-user")
	public ResponseEntity addNewUser(@RequestBody AddNewUserDTO newUserDTO) {
		usersService.addNewUser(newUserDTO);
		return ResponseEntity.ok().build();
	}
}
