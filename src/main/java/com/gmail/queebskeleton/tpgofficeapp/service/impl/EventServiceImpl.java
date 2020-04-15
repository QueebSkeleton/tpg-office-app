package com.gmail.queebskeleton.tpgofficeapp.service.impl;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.gmail.queebskeleton.tpgofficeapp.entity.Event;
import com.gmail.queebskeleton.tpgofficeapp.entity.dto.EventForm;
import com.gmail.queebskeleton.tpgofficeapp.repository.EventRepository;
import com.gmail.queebskeleton.tpgofficeapp.repository.UserRepository;
import com.gmail.queebskeleton.tpgofficeapp.service.EventService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EventServiceImpl implements EventService {
	
	private final UserRepository userRepository;
	private final EventRepository eventRepository;
	
	@Override
	@Async
	public void createEvent(EventForm eventForm) {
		
		Event event = new Event();
		event.setName(eventForm.getName());
		event.setVenue(eventForm.getVenue());
		event.setDescription(eventForm.getDescription());
		event.setExpectedStart(eventForm.getExpectedStart());
		event.setExpectedEnd(eventForm.getExpectedEnd());
		
		event.setCreatedOn(LocalDateTime.now());
		event.setStatus(Event.Status.PENDING);
		
		event.setUsersNeededToAttend(
				userRepository.findAllById(
						eventForm.getUsersNeededToAttend()));
		
		eventRepository.save(event);
		
		// TODO: Notify users thru Facebook Graph API, Messenger Platform,
		// then anotate this as transactional
		
	}
	
}
