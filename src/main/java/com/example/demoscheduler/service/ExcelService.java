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

        // Create header style
        CellStyle headerStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        headerStyle.setFont(font);
        headerStyle.setAlignment(HorizontalAlignment.CENTER);

        // Create header row
        Row header = sheet.createRow(0);
        String[] headers = {"Time", "Class", "Subject"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = header.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        // Add sample data
        Row row = sheet.createRow(1);
        row.createCell(0).setCellValue("8:00 AM - 9:00 AM");
        row.createCell(1).setCellValue("Sample Class");
        row.createCell(2).setCellValue("Mathematics");

        // Auto-size columns
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();
        return out.toByteArray();
    }

    public byte[] createPersonalTimetableExcel(Professor professor, List<Timetable> personal) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Personal Timetable");

        // Create header style
        CellStyle headerStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        headerStyle.setFont(font);
        headerStyle.setAlignment(HorizontalAlignment.CENTER);

        // Create header row
        Row header = sheet.createRow(0);
        String[] headers = {"Day", "Time", "Branch", "Subject"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = header.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        // Add data
        int rowNum = 1;
        for (Timetable entry : personal) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(entry.getScheduleDay());
            row.createCell(1).setCellValue(entry.getTimeSlot());
            row.createCell(2).setCellValue(entry.getBranch());
            row.createCell(3).setCellValue(entry.getSubject());
        }

        // Auto-size columns
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();
        return out.toByteArray();
    }

    public byte[] createCSTimetableExcel() throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("CS Timetable");

        // Create header style
        CellStyle headerStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        headerStyle.setFont(font);
        headerStyle.setAlignment(HorizontalAlignment.CENTER);

        // Create header row
        Row header = sheet.createRow(0);
        String[] headers = {"Day", "8:00 AM - 9:00 AM", "9:00 AM - 10:00 AM", "10:00 AM - 11:00 AM", "11:00 AM - 12:00 PM", "12:00 PM - 1:00 PM", "1:00 PM - 2:00 PM"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = header.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        // CS Students Timetable
        String[][] csTimetable = {
            {"Monday", "English", "-", "Mathematics", "Physics", "Computer Science", "Chemistry"},
            {"Tuesday", "English", "Physics", "Mathematics", "Physics", "Computer Science", "Chemistry"},
            {"Wednesday", "English", "-", "Mathematics", "Physics", "Computer Science", "Chemistry"},
            {"Thursday", "English", "Physics", "Mathematics", "Physics", "Computer Science", "Chemistry"},
            {"Friday", "English", "-", "Mathematics", "Physics", "Computer Science", "Chemistry"}
        };

        // Add data
        int rowNum = 1;
        for (String[] rowData : csTimetable) {
            Row row = sheet.createRow(rowNum++);
            for (int i = 0; i < rowData.length; i++) {
                row.createCell(i).setCellValue(rowData[i]);
            }
        }

        // Auto-size columns
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();
        return out.toByteArray();
    }

    public byte[] createITTimetableExcel() throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("IT Timetable");

        // Create header style
        CellStyle headerStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        headerStyle.setFont(font);
        headerStyle.setAlignment(HorizontalAlignment.CENTER);

        Row header = sheet.createRow(0);
        String[] headers = {"Day", "8:00 AM - 9:00 AM", "9:00 AM - 10:00 AM", "10:00 AM - 11:00 AM", "11:00 AM - 12:00 PM", "12:00 PM - 1:00 PM", "1:00 PM - 2:00 PM"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = header.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        String[][] itTimetable = {
            {"Monday", "English", "Physics", "Physics", "Mathematics", "Chemistry", "Computer Science"},
            {"Tuesday", "English", "Mathematics", "Physics", "Mathematics", "Chemistry", "Computer Science"},
            {"Wednesday", "English", "Physics", "Physics", "Mathematics", "Chemistry", "Computer Science"},
            {"Thursday", "English", "Mathematics", "Physics", "Mathematics", "Chemistry", "Computer Science"},
            {"Friday", "English", "Physics", "Physics", "Mathematics", "Chemistry", "Computer Science"}
        };

        // add data
        int rowNum = 1;
        for (String[] rowData : itTimetable) {
            Row row = sheet.createRow(rowNum++);
            for (int i = 0; i < rowData.length; i++) {
                row.createCell(i).setCellValue(rowData[i]);
            }
        }

        // Auto-size columns
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();
        return out.toByteArray();
    }
}