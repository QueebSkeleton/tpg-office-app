package com.gmail.queebskeleton.tpgofficeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gmail.queebskeleton.tpgofficeapp.entity.NonUserEventAttendance;

@Repository
public interface NonUserEventAttendanceRepository
	extends JpaRepository<NonUserEventAttendance, Long> {

}
