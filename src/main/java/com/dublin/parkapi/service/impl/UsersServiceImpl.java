package com.dublin.parkapi.service.impl;

import com.dublin.parkapi.dto.AddNewUserDTO;
import com.dublin.parkapi.dto.UserLoginInputDTO;
import com.dublin.parkapi.model.User;
import com.dublin.parkapi.repository.UsersRepository;
import com.dublin.parkapi.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	UsersRepository usersRepository;

	@Override
	public void addNewUser(AddNewUserDTO newUserDTO) {
		User user = new User(newUserDTO.getUsername(),newUserDTO.getPassword(),newUserDTO.getRole());
		usersRepository.save(user);
	}

	@Override
	public boolean getByUserNameAndPassword(UserLoginInputDTO loginInputDTO) {
		Optional<User> user = usersRepository.findByUserNameAndPassword(loginInputDTO.getUsername(),loginInputDTO.getPassword());
		return user.isPresent();
	}

	@Override
	public boolean getByUserNameAndPasswordAndRole(String userName,String password) {
		Optional<User> user = usersRepository.findByUserNameAndPassword(userName, password);
		if(user.isPresent() && user.get().getRole().equals("ADMIN")){
			return true;
		}else {
			return false;
		}
	}
}
