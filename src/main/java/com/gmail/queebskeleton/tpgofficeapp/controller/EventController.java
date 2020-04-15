package com.gmail.queebskeleton.tpgofficeapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gmail.queebskeleton.tpgofficeapp.entity.dto.EventForm;
import com.gmail.queebskeleton.tpgofficeapp.service.EventService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/events")
public class EventController {
	
	private final EventService eventService;

	@PostMapping("/createEvent")
	@ResponseStatus(HttpStatus.CREATED)
	public void createEvent(@RequestBody EventForm eventForm) {
		eventService.createEvent(eventForm);
	}
	
}
