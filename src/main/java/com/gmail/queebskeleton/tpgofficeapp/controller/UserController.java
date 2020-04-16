package com.gmail.queebskeleton.tpgofficeapp.controller;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.gmail.queebskeleton.tpgofficeapp.entity.dto.UserForm;
import com.gmail.queebskeleton.tpgofficeapp.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RepositoryRestController
public class UserController {
	
	private final UserService userService;
	
	@PostMapping("/api/users/create-admin")
	@ResponseStatus(HttpStatus.CREATED)
	public void createAdmin(@RequestBody UserForm userForm) {
		userService.createAdmin(userForm);
	}

}
