package com.gmail.queebskeleton.tpgofficeapp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gmail.queebskeleton.tpgofficeapp.entity.dto.LoginForm;
import com.gmail.queebskeleton.tpgofficeapp.entity.dto.LoginResponse;
import com.gmail.queebskeleton.tpgofficeapp.service.AuthService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private final AuthService authService;
	
	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginForm loginForm) {
		return authService.login(loginForm);
	}
	
}
