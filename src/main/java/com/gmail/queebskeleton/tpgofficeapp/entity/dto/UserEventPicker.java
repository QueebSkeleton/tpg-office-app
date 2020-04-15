package com.gmail.queebskeleton.tpgofficeapp.entity.dto;

import org.springframework.data.rest.core.config.Projection;

import com.gmail.queebskeleton.tpgofficeapp.entity.User;

@Projection(name = "eventPicker", types = User.class)
public interface UserEventPicker {

	Long getId();
	String getFirstName();
	String getLastName();
	
}
