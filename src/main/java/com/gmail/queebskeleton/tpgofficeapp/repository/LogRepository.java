package com.gmail.queebskeleton.tpgofficeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gmail.queebskeleton.tpgofficeapp.entity.Log;

@RepositoryRestResource(collectionResourceRel = "logs", path = "logs")
public interface LogRepository extends JpaRepository<Log, Long> {

}
