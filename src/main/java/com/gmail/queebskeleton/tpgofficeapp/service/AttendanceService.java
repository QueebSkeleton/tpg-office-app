package com.gmail.queebskeleton.tpgofficeapp.service;

import java.io.IOException;

import org.springframework.core.io.Resource;

public interface AttendanceService {

	Resource generateAttendanceWorksheetForEvent(long eventId) throws IOException;

}