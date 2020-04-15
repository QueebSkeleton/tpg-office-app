package com.gmail.queebskeleton.tpgofficeapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.gmail.queebskeleton.tpgofficeapp.entity.User;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUsername(String username);

}
