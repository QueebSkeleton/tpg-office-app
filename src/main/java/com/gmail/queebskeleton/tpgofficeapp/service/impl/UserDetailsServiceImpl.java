package com.gmail.queebskeleton.tpgofficeapp.service.impl;

import java.util.Arrays;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gmail.queebskeleton.tpgofficeapp.entity.User;
import com.gmail.queebskeleton.tpgofficeapp.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username)
					.orElseThrow(() ->
						new UsernameNotFoundException(
								"Did not find user with that username."));
		
		return new org.springframework.security.core.userdetails.User(
				user.getUsername(),
				user.getPassword(),
				Arrays.asList(
					new SimpleGrantedAuthority("ROLE_" + user.getRole().toString())));
		
	}

}
