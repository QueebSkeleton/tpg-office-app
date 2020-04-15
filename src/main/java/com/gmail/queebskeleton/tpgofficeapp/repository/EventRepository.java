package com.gmail.queebskeleton.tpgofficeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gmail.queebskeleton.tpgofficeapp.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
