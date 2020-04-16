package com.gmail.queebskeleton.tpgofficeapp.repository.eventhandler;

import java.time.LocalDateTime;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import com.gmail.queebskeleton.tpgofficeapp.entity.Event;

@Component
@RepositoryEventHandler(Event.class)
public class EventEventHandler {

	@HandleBeforeCreate
	public void beforeCreate(Event event) {
		
		event.setCreatedOn(LocalDateTime.now());
		event.setStatus(Event.Status.PENDING);
		
	}
	
}
