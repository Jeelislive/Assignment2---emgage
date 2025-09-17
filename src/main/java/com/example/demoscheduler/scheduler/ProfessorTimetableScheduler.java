package com.example.demoscheduler.scheduler;

import com.example.demoscheduler.model.Professor;
import com.example.demoscheduler.model.Timetable;
import com.example.demoscheduler.service.EmailService;
import com.example.demoscheduler.service.ExcelService;
import com.example.demoscheduler.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProfessorTimetableScheduler {

    @Autowired
    private TimetableService timetableService;

    @Autowired
    private ExcelService excelService;

    @Autowired
    private EmailService emailService;


    //@scheduled(cron = "0 * * * * ?") 
   @Scheduled(cron = "0 0 9 ? * MON")

    public void sendProfessorTimetables() throws Exception {
        List<Professor> professors = timetableService.getProfessors();
        List<Timetable> timetables = timetableService.generateTimetables();

        for (Professor professor : professors) {

            // filter personal timetable
            List<Timetable> personal = timetables.stream()
                .filter(t -> t.getProfessorName().equals(professor.getName()))
                .collect(Collectors.toList());


            // generate three excel file
            byte[] personalExcel = excelService.createPersonalTimetableExcel(professor, personal);
             byte[] csExcel = excelService.createCSTimetableExcel();
            byte[] itExcel = excelService.createITTimetableExcel();

            // created email
            MimeMessage message = emailService.getMailSender().createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);


            helper.setTo(professor.getEmail());
            helper.setSubject("Weekly Timetable for " + professor.getName());
            helper.setText("Attached are your personal timetable and the CS and IT branch timetables.");
            
            helper.addAttachment("personal_timetable_" + professor.getName() + ".xlsx", new org.springframework.core.io.ByteArrayResource(personalExcel));
            
            helper.addAttachment("cs_timetable.xlsx", new org.springframework.core.io.ByteArrayResource(csExcel));
            helper.addAttachment("it_timetable.xlsx", new org.springframework.core.io.ByteArrayResource(itExcel));
            
            
            emailService.getMailSender().send(message);
        }
    }
}