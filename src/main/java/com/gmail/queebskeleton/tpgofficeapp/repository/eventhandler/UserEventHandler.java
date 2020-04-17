package com.gmail.queebskeleton.tpgofficeapp.repository.eventhandler;

import java.time.LocalDateTime;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import com.gmail.queebskeleton.tpgofficeapp.entity.User;

@Component
@RepositoryEventHandler(User.class)
public class UserEventHandler {
	
	@HandleBeforeCreate
	public void beforeCreate(User user) {
		
		// Set 'createdOn' field to current date time
		user.setCreatedOn(LocalDateTime.now());
		
	}

}
