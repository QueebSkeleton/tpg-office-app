package com.gmail.queebskeleton.tpgofficeapp.repository.eventhandler;

import java.time.LocalDateTime;

import com.gmail.queebskeleton.tpgofficeapp.entity.Log;
import com.gmail.queebskeleton.tpgofficeapp.entity.User;
import com.gmail.queebskeleton.tpgofficeapp.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.core.annotation.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.gmail.queebskeleton.tpgofficeapp.entity.Event;

@RequiredArgsConstructor
@Component
@RepositoryEventHandler(Event.class)
public class EventEventHandler {

	private final LogRepository logRepository;

	@HandleBeforeCreate
	public void beforeCreate(Event event) {
		
		event.setCreatedOn(LocalDateTime.now());
		event.setStatus(Event.Status.PENDING);
		
	}

	@HandleAfterCreate
	public void afterCreate(Event event) {

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
				.append(" has created an Event.")
				.toString());

		logRepository.save(log);

	}

	@HandleAfterSave
	public void afterSave(Event event) {

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
				.append(" has updated an Event.")
				.toString());

		logRepository.save(log);

	}

	@HandleAfterDelete
	public void afterDelete(Event event) {

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
				.append(" has deleted an Event.")
				.toString());

		logRepository.save(log);

	}
	
}
