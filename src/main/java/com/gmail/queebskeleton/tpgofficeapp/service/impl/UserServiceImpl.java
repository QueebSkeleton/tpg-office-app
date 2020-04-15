package com.gmail.queebskeleton.tpgofficeapp.service.impl;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gmail.queebskeleton.tpgofficeapp.entity.User;
import com.gmail.queebskeleton.tpgofficeapp.entity.dto.UserForm;
import com.gmail.queebskeleton.tpgofficeapp.repository.UserRepository;
import com.gmail.queebskeleton.tpgofficeapp.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void createAdmin(UserForm userForm) {
		
		// Map the UserForm DTO to a User Entity Object
		User user = new User();
		user.setFirstName(userForm.getFirstName());
		user.setMiddleName(userForm.getMiddleName());
		user.setLastName(userForm.getLastName());
		user.setEmailAddress(userForm.getEmailAddress());
		user.setBirthdate(userForm.getBirthdate());
		user.setUsername(userForm.getUsername());
		
		
		// Encode the password, instead of storing the raw one.
		// Uses BCrypt
		user.setPassword(passwordEncoder.encode(userForm.getPassword()));
		
		// Set createdOn to time this user was created
		user.setCreatedOn(LocalDateTime.now());
		
		// Set Role to ADMINISTRATOR
		user.setRole(User.Role.ADMINISTRATOR);
		
		// Save user to database
		userRepository.save(user);
		
		// TODO: Notify user that his account is ready to be used.
		// Create a Mailing Service class to send mails
		
	}
	
}
