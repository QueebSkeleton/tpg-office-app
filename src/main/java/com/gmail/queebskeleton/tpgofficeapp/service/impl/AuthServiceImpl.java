package com.gmail.queebskeleton.tpgofficeapp.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.gmail.queebskeleton.tpgofficeapp.entity.dto.LoginForm;
import com.gmail.queebskeleton.tpgofficeapp.entity.dto.LoginResponse;
import com.gmail.queebskeleton.tpgofficeapp.service.AuthService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
	
	private final AuthenticationManager authenticationManager;
	
	private final JwtProvider jwtProvider;
	
	@Override
	public LoginResponse login(LoginForm loginForm) {
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginForm.getUsername(),
						loginForm.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String authenticationToken = jwtProvider.generateToken(authentication);
		
		return new LoginResponse(authenticationToken, loginForm.getUsername());
		
	}

}
