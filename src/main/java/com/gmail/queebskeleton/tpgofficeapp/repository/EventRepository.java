package com.gmail.queebskeleton.tpgofficeapp.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.gmail.queebskeleton.tpgofficeapp.entity.Event;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RepositoryRestResource(collectionResourceRel = "events", path = "events")
public interface EventRepository extends JpaRepository<Event, Long> {
	
	@RestResource
	@Query("SELECT e FROM Event e WHERE year(e.expectedStart) = ?1 AND month(e.expectedStart) = ?2")
	List<Event> findAllByExpectedStart_YearAndExpectedStart_Month_Value(int year, int month);
	
	@RestResource(exported = false)
	@EntityGraph(attributePaths = { "userEventAttendances" })
	@Query("SELECT e FROM Event e WHERE e.id = :id")
	Optional<Event> findByIdFetchUserEventAttendances(@Param("id") long id);
	
	@RestResource(exported = false)
	@EntityGraph(attributePaths = { "nonUserEventAttendances" })
	@Query("SELECT e FROM Event e WHERE e.id = :id")
	Optional<Event> findByIdFetchNonUserEventAttendances(@Param("id") long id);

}
