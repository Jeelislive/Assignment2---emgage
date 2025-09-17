package com.example.demoscheduler.service;

import com.example.demoscheduler.model.Professor;
import com.example.demoscheduler.model.Timetable;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {

    public byte[] createSimpleExcel() throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sample Timetable");
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Time");
        header.createCell(1).setCellValue("Class");
        header.createCell(2).setCellValue("Subject");
        Row row = sheet.createRow(1);
        row.createCell(0).setCellValue("08:00-09:00");
        row.createCell(1).setCellValue("Sample Class");
        row.createCell(2).setCellValue("Mathematics");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();
        return out.toByteArray();
    }

    public byte[] createProfessorTimetable(Professor professor, List<Timetable> personal, List<Timetable> cs, List<Timetable> it) throws IOException {
        Workbook workbook = new XSSFWorkbook();

        // Personal Timetable
        Sheet personalSheet = workbook.createSheet("Personal Timetable");
        Row header = personalSheet.createRow(0);
        header.createCell(0).setCellValue("Day");
        header.createCell(1).setCellValue("Time");
        header.createCell(2).setCellValue("Branch");
        header.createCell(3).setCellValue("Subject");
        int rowNum = 1;
        for (Timetable entry : personal) {
            Row row = personalSheet.createRow(rowNum++);
            row.createCell(0).setCellValue(entry.getScheduleDay());
            row.createCell(1).setCellValue(entry.getTimeSlot());
            row.createCell(2).setCellValue(entry.getBranch());
            row.createCell(3).setCellValue(entry.getSubject());
        }

        // CS Students Timetable
        Sheet csSheet = workbook.createSheet("CS Timetable");
        header = csSheet.createRow(0);
        header.createCell(0).setCellValue("Day");
        header.createCell(1).setCellValue("8-9");
        header.createCell(2).setCellValue("9-10");
        header.createCell(3).setCellValue("10-11");
        header.createCell(4).setCellValue("11-12");
        header.createCell(5).setCellValue("12-1");
        header.createCell(6).setCellValue("1-2");
        String[][] csTimetable = {
            {"Monday", "English", "-", "Mathematics", "Physics", "Computer Science", "Chemistry"},
            {"Tuesday", "English", "Physics", "Mathematics", "Physics", "Computer Science", "Chemistry"},
            {"Wednesday", "English", "-", "Mathematics", "Physics", "Computer Science", "Chemistry"},
            {"Thursday", "English", "Physics", "Mathematics", "Physics", "Computer Science", "Chemistry"},
            {"Friday", "English", "-", "Mathematics", "Physics", "Computer Science", "Chemistry"}
        };
        rowNum = 1;
        for (String[] rowData : csTimetable) {
            Row row = csSheet.createRow(rowNum++);
            for (int i = 0; i < rowData.length; i++) {
                row.createCell(i).setCellValue(rowData[i]);
            }
        }

        // IT Students Timetable
        Sheet itSheet = workbook.createSheet("IT Timetable");
        header = itSheet.createRow(0);
        header.createCell(0).setCellValue("Day");
        header.createCell(1).setCellValue("8-9");
        header.createCell(2).setCellValue("9-10");
        header.createCell(3).setCellValue("10-11");
        header.createCell(4).setCellValue("11-12");
        header.createCell(5).setCellValue("12-1");
        header.createCell(6).setCellValue("1-2");
        String[][] itTimetable = {
            {"Monday", "English", "Physics", "Physics", "Mathematics", "Chemistry", "Computer Science"},
            {"Tuesday", "English", "Mathematics", "Physics", "Mathematics", "Chemistry", "Computer Science"},
            {"Wednesday", "English", "Physics", "Physics", "Mathematics", "Chemistry", "Computer Science"},
            {"Thursday", "English", "Mathematics", "Physics", "Mathematics", "Chemistry", "Computer Science"},
            {"Friday", "English", "Physics", "Physics", "Mathematics", "Chemistry", "Computer Science"}
        };
        rowNum = 1;
        for (String[] rowData : itTimetable) {
            Row row = itSheet.createRow(rowNum++);
            for (int i = 0; i < rowData.length; i++) {
                row.createCell(i).setCellValue(rowData[i]);
            }
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();
        return out.toByteArray();
    }
}