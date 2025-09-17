package com.example.demoscheduler.scheduler;

import com.example.demoscheduler.service.EmailService;
import com.example.demoscheduler.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ExcelScheduler {

    @Autowired
    private ExcelService excelService;

    @Autowired
    private EmailService emailService;

    // @scheduled(cron = "0 * * * * ?") 



    @Scheduled(cron = "0 0/30 * * * ?")
    public void sendExcelEmail() throws Exception {
        byte[] excelBytes = excelService.createSimpleExcel();
        emailService.sendEmailWithAttachment(
            "jeelrupareliya255@gmail.com",
            "Half-Hourly Timetable",
            "Attached is the latest timetable.",
            excelBytes,
            "timetable.xlsx"
        );
    }
}