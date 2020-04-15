package com.gmail.queebskeleton.tpgofficeapp.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Entity class for an event in the system. Holds data for an event organized
 * by the organization, including relevant details and required attendees.
 * 
 * Mapped to a row in the database table 'events'.
 * 
 * @author queenskeleton
 * @version 1.0
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "events")
public class Event {
	
	/**
	 * 
	 * Enumeration that represents the status of an event.
	 * 
	 * @author queenskeleton
	 *
	 */
	public static enum Status {
		
		/**
		 * States that the event is still pending or ongoing.
		 */
		PENDING,
		
		/**
		 * States that the event is already finished.
		 */
		FINISHED
	}
	
	/**
	 * Primary key of the event in the database.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * Name of the event.
	 */
	private String name;
	
	/**
	 * Where the event will take place.
	 */
	private String venue;
	
	/**
	 * Brief description of the event.
	 * 
	 * TODO: Include rich-text and markdown for descriptions.
	 */
	private String description;
	
	/**
	 * When this event was registered in the system.
	 */
	private LocalDateTime createdOn;
	
	/**
	 * Expected date and time of start of the event.
	 */
	private LocalDateTime expectedStart;
	
	/**
	 * Expected date and time of end of the event.
	 */
	private LocalDateTime expectedEnd;
	
	/**
	 * List of all the users that needs to attend this event. All necessary
	 * notifications and reminders for the attendees are referenced from this
	 * field.
	 * 
	 * Has a {@code}ManyToMany{@code} reference to the User Entity class.
	 */
	@ManyToMany
	private List<User> usersNeededToAttend;
	
	/**
	 * Current status of the event.
	 * 
	 * @see Status
	 */
	@Enumerated
	private Status status;

}
