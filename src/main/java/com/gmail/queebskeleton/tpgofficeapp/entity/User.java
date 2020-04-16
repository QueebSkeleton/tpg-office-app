package com.gmail.queebskeleton.tpgofficeapp.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.gmail.queebskeleton.tpgofficeapp.deserializer.BCryptPasswordDeserializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Entity class for a user in the system. Holds all relevant information of
 * an officer or a member in the organization.
 * 
 * Mapped to a row in the database table 'user'.
 * 
 * @author queenskeleton
 * @version 1.0
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
	
	/**
	 * Enumeration that represents the role of the User in the system. Helps
	 * Spring Security determine what resources this User can access in the
	 * system.
	 * 
	 * @author queenskeleton
	 *
	 */
	public static enum Role {
		
		/**
		 * Administrator in the system. Can perform all operations the
		 * system is implemented on.
		 */
		ADMINISTRATOR
	}

	/**
	 * Primary key of the user row in the database.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * First name of the user.
	 */
	private String firstName;
	
	/**
	 * Middle name of the user.
	 */
	private String middleName;
	
	/**
	 * Last name of the user.
	 */
	private String lastName;
	
	/**
	 * Date and Time this user was registered on the system.
	 */
	private LocalDateTime createdOn;
	
	/**
	 * Email Address of the user. Used for mailing and notification capabilities
	 * of the system.
	 */
	private String emailAddress;
	
	/**
	 * Birth date of the user. Used for notification capabilities.
	 */
	private LocalDate birthdate;
	
	/**
	 * Username of the user. Used in system authentication.
	 */
	private String username;
	
	/**
	 * Password of the user. Used in system authentication.
	 * 
	 * This password is encrypted using the default BCryptPasswordEncoder class
	 * in Spring Security.
	 */
	@JsonDeserialize(using = BCryptPasswordDeserializer.class)
	private String password;
	
	/**
	 * Role of the user in the system. Determines what resources this user
	 * can access.
	 */
	@Enumerated
	private Role role;
	
}
