package com.gmail.queebskeleton.tpgofficeapp.entity.dto;

import java.time.LocalDateTime;

import org.springframework.data.rest.core.config.Projection;

import com.gmail.queebskeleton.tpgofficeapp.entity.User;

@Projection(name = "adminTable", types = User.class)
public interface UserAdminTable {
	
	String getFirstName();

	String getLastName();

	String getEmailAddress();

	LocalDateTime getCreatedOn();

}
