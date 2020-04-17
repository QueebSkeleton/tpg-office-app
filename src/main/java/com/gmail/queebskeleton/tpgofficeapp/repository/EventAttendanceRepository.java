package com.gmail.queebskeleton.tpgofficeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gmail.queebskeleton.tpgofficeapp.entity.EventAttendance;

@Repository
public interface EventAttendanceRepository extends JpaRepository<EventAttendance, Long> {

}
