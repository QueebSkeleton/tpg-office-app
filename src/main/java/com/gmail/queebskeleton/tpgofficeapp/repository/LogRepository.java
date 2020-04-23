package com.gmail.queebskeleton.tpgofficeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gmail.queebskeleton.tpgofficeapp.entity.Log;
import org.springframework.data.rest.core.annotation.RestResource;

import java.time.Month;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "logs", path = "logs")
public interface LogRepository extends JpaRepository<Log, Long> {

    @RestResource
    @Query("SELECT l FROM Log l WHERE year(l.createdOn) = ?1 AND month(l.createdOn) = ?2")
    List<Log> findAllByCreatedOn_YearAndCreatedOn_Month(int year, int month);

}
