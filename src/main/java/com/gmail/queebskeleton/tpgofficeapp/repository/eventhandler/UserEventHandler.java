package com.gmail.queebskeleton.tpgofficeapp.repository.eventhandler;

import java.time.LocalDateTime;

import com.gmail.queebskeleton.tpgofficeapp.entity.Log;
import com.gmail.queebskeleton.tpgofficeapp.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.core.annotation.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.gmail.queebskeleton.tpgofficeapp.entity.User;

@RequiredArgsConstructor
@Component
@RepositoryEventHandler(User.class)
public class UserEventHandler {

	private final LogRepository logRepository;

	@HandleBeforeCreate
	public void beforeCreate(User user) {
		
		// Set 'createdOn' field to current date time
		user.setCreatedOn(LocalDateTime.now());
		
	}

	@HandleAfterCreate
	public void afterCreate(User user) {

		// Log
		Log log = new Log();

		log.setCreatedOn(LocalDateTime.now());

		User createdBy = (User) SecurityContextHolder
						.getContext()
						.getAuthentication()
						.getPrincipal();

		log.setFrom(createdBy);
		log.setMessage(new StringBuilder()
						.append("User ")
						.append(createdBy.getFirstName())
						.append(" ")
						.append(createdBy.getLastName())
						.append(createdBy.getRole().getStr())
						.append(" has created a User of type ")
						.append(user.getRole().getStr())
						.toString());

		logRepository.save(log);

	}

	@HandleAfterSave
	public void afterSave(User user) {

		// Log
		Log log = new Log();

		log.setCreatedOn(LocalDateTime.now());

		User createdBy = (User) SecurityContextHolder
				.getContext()
				.getAuthentication()
				.getPrincipal();

		log.setFrom(createdBy);
		log.setMessage(new StringBuilder()
				.append("User ")
				.append(createdBy.getFirstName())
				.append(" ")
				.append(createdBy.getLastName())
				.append(createdBy.getRole().getStr())
				.append(" has updated a User.")
				.toString());

		logRepository.save(log);

	}

	@HandleAfterDelete
	public void afterDelete(User user) {

		// Log
		Log log = new Log();

		log.setCreatedOn(LocalDateTime.now());

		User createdBy = (User) SecurityContextHolder
				.getContext()
				.getAuthentication()
				.getPrincipal();

		log.setFrom(createdBy);
		log.setMessage(new StringBuilder()
				.append("User ")
				.append(createdBy.getFirstName())
				.append(" ")
				.append(createdBy.getLastName())
				.append(createdBy.getRole().getStr())
				.append(" has deleted a User.")
				.toString());

		logRepository.save(log);

	}

}
