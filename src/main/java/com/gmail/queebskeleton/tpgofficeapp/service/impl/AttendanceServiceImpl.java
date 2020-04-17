package com.gmail.queebskeleton.tpgofficeapp.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gmail.queebskeleton.tpgofficeapp.entity.NonUserEventAttendance;
import com.gmail.queebskeleton.tpgofficeapp.entity.User;
import com.gmail.queebskeleton.tpgofficeapp.entity.UserEventAttendance;
import com.gmail.queebskeleton.tpgofficeapp.repository.EventRepository;
import com.gmail.queebskeleton.tpgofficeapp.service.AttendanceService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AttendanceServiceImpl implements AttendanceService {
	
	private final EventRepository eventRepository;
	
	@Override
	@Transactional
	public Resource generateAttendanceWorksheetForEvent(long eventId)
			throws IOException {
		
		// TODO: Improve Sheets Design
		
		Workbook attendanceBook = WorkbookFactory.create(true);
		
		generateUserAttendanceSheet(attendanceBook,
				eventRepository.findByIdFetchUserEventAttendances(eventId)
					.orElseThrow(() -> new RuntimeException("Invalid ID."))
					.getUserEventAttendances());
		generateNonUserAttendanceSheet(attendanceBook,
				eventRepository.findByIdFetchNonUserEventAttendances(eventId)
					.orElseThrow(() -> new RuntimeException("Invalid ID."))
					.getNonUserEventAttendances());
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		attendanceBook.write(baos);
		
		return new ByteArrayResource(baos.toByteArray());
		
	}
	
	private void generateNonUserAttendanceSheet(Workbook attendanceBook,
			List<NonUserEventAttendance> nonUserEventAttendances) {
		
		Sheet attendanceSheet = attendanceBook.createSheet("Members Attended");
		
		// Write User Attendances to First Sheet
		int currentRow = 0;
		nonUserEventAttendances.forEach(attendance -> {
			
			Row attendanceRow = attendanceSheet.createRow(currentRow);
			
			Cell nameCell = attendanceRow.createCell(0);
			
			nameCell.setCellValue(attendance.getAttendeeName());
			
		});
		
	}

	private void generateUserAttendanceSheet(
			Workbook attendanceBook,
			List<UserEventAttendance> userEventAttendances) {
		
		Sheet attendanceSheet = attendanceBook.createSheet("Non-Members Attended");
		
		// Write User Attendances to First Sheet
		int currentRow = 0;
		userEventAttendances.forEach(attendance -> {
			
			Row attendanceRow = attendanceSheet.createRow(currentRow);
			
			Cell nameCell = attendanceRow.createCell(0);
			
			User user = attendance.getUser();
			
			nameCell.setCellValue(
					new StringBuilder()
						.append(user.getLastName())
						.append(", ")
						.append(user.getFirstName())
						.append(user.getMiddleName().charAt(0))
						.append(".")
						.toString());
			
			Cell isPreRegisteredCell = attendanceRow.createCell(1);
			isPreRegisteredCell.getCellStyle().setAlignment(
					HorizontalAlignment.CENTER);
			isPreRegisteredCell.getCellStyle().setFillBackgroundColor(
					IndexedColors.GREEN.index);
			isPreRegisteredCell.getCellStyle().setFillForegroundColor(
					IndexedColors.WHITE.index);
			isPreRegisteredCell.setCellValue("Registered");
			
		});
		
	}

}
