package com.gmail.queebskeleton.tpgofficeapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.gmail.queebskeleton.tpgofficeapp.entity.Event;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RepositoryRestResource(collectionResourceRel = "events", path = "events")
public interface EventRepository extends JpaRepository<Event, Long> {
	
	@EntityGraph(attributePaths = { "userEventAttendances" })
	@Query("SELECT e FROM Event e WHERE e.id = :id")
	Optional<Event> findByIdFetchUserEventAttendances(@Param("id") long id);
	
	@EntityGraph(attributePaths = { "nonUserEventAttendances" })
	@Query("SELECT e FROM Event e WHERE e.id = :id")
	Optional<Event> findByIdFetchNonUserEventAttendances(@Param("id") long id);

}
