package com.gmail.queebskeleton.tpgofficeapp.service.impl;

import com.gmail.queebskeleton.tpgofficeapp.entity.User;
import org.springframework.security.access.prepost.PreAuthorize;
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
		String authenticationToken = jwtProvider.generateToken(((User) authentication.getPrincipal()).getUsername());
		
		return new LoginResponse(authenticationToken, loginForm.getUsername());
		
	}

}
