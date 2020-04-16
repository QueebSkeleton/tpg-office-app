package com.gmail.queebskeleton.tpgofficeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.gmail.queebskeleton.tpgofficeapp.entity.Event;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RepositoryRestResource(collectionResourceRel = "events", path = "events")
public interface EventRepository extends JpaRepository<Event, Long> {

}
