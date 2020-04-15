package com.gmail.queebskeleton.tpgofficeapp.entity.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String emailAddress;
	
	private LocalDate birthdate;
	
	private String username;
	
	private String password;

}
