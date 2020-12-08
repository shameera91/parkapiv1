package com.dublin.parkapi.service;

import com.dublin.parkapi.dto.AddNewUserDTO;
import com.dublin.parkapi.dto.UserLoginInputDTO;

public interface UsersService {

	void addNewUser(AddNewUserDTO user);

	boolean getByUserNameAndPassword(UserLoginInputDTO userLoginInputDTO);

	boolean getByUserNameAndPasswordAndRole(String userName,String password);
}
