package com.gmail.queebskeleton.tpgofficeapp.controller;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gmail.queebskeleton.tpgofficeapp.service.AttendanceService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class EventController {
	
	private final AttendanceService attendanceService;

	@GetMapping(value = "/api/events/{id}/attendance-book.xlsx", produces = "application/vnd.ms-excel")
	public Resource eventAttendanceExcelFile(
			@PathVariable("id") long id) throws IOException {
		
		return attendanceService.generateAttendanceWorksheetForEvent(id);
		
	}
	
}
