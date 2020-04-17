package com.gmail.queebskeleton.tpgofficeapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.gmail.queebskeleton.tpgofficeapp.entity.UserEventAttendance;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RepositoryRestResource(collectionResourceRel = "attendances", path = "user-attendances")
public interface UserEventAttendanceRepository
	extends JpaRepository<UserEventAttendance, Long> {

	@Override
	@RestResource(exported = false)
	List<UserEventAttendance> findAll();
	
	@Override
	@RestResource(exported = false)
	List<UserEventAttendance> findAll(Sort sort);
	
	@Override
	@RestResource(exported = false)
	Page<UserEventAttendance> findAll(Pageable pageable);
	
	@Override
	@RestResource(exported = false)
	Optional<UserEventAttendance> findById(Long id);
	
}
