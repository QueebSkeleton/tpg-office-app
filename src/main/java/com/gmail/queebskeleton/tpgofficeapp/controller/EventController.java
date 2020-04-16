package com.gmail.queebskeleton.tpgofficeapp.controller;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.gmail.queebskeleton.tpgofficeapp.entity.dto.EventForm;
import com.gmail.queebskeleton.tpgofficeapp.service.EventService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RepositoryRestController
public class EventController {
	
	private final EventService eventService;

	@PostMapping("/api/events/create-event")
	@ResponseStatus(HttpStatus.CREATED)
	public void createEvent(@RequestBody EventForm eventForm) {
		eventService.createEvent(eventForm);
	}
	
}
