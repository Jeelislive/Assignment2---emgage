package com.example.demoscheduler.service;

import com.example.demoscheduler.model.Professor;
import com.example.demoscheduler.model.Timetable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimetableService {

    private static final String[] SUBJECTS = {"Mathematics", "Physics", "Computer Science", "Chemistry", "English"};

    public List<Timetable> generateTimetables() {
        List<Timetable> timetables = new ArrayList<>();
        int timetableId = 1;

        // professor 1 (10 AM - 4 PM)
        String[][] prof1Schedule = {
            {"Monday", "10:00 AM - 11:00 AM", "CS", "Mathematics", "Professor1"},
            {"Monday", "11:00 AM - 12:00 PM", "IT", "Physics", "Professor1"},
            {"Monday", "12:00 PM - 1:00 PM", "CS", "Physics", "Professor1"},
            {"Monday", "1:00 PM - 2:00 PM", "IT", "Mathematics", "Professor1"},
            {"Tuesday", "10:00 AM - 11:00 AM", "IT", "Mathematics", "Professor1"},
            {"Tuesday", "11:00 AM - 12:00 PM", "CS", "Physics", "Professor1"},
            {"Tuesday", "12:00 PM - 1:00 PM", "IT", "Physics", "Professor1"},
            {"Tuesday", "1:00 PM - 2:00 PM", "CS", "Mathematics", "Professor1"},
            {"Wednesday", "10:00 AM - 11:00 AM", "CS", "Mathematics", "Professor1"},
            {"Wednesday", "11:00 AM - 12:00 PM", "IT", "Physics", "Professor1"},
            {"Wednesday", "12:00 PM - 1:00 PM", "CS", "Physics", "Professor1"},
            {"Wednesday", "1:00 PM - 2:00 PM", "IT", "Mathematics", "Professor1"},
            {"Thursday", "10:00 AM - 11:00 AM", "IT", "Mathematics", "Professor1"},
            {"Thursday", "11:00 AM - 12:00 PM", "CS", "Physics", "Professor1"},
            {"Thursday", "12:00 PM - 1:00 PM", "IT", "Physics", "Professor1"},
            {"Thursday", "1:00 PM - 2:00 PM", "CS", "Mathematics", "Professor1"},
            {"Friday", "10:00 AM - 11:00 AM", "CS", "Mathematics", "Professor1"},
            {"Friday", "11:00 AM - 12:00 PM", "IT", "Physics", "Professor1"},
            {"Friday", "12:00 PM - 1:00 PM", "CS", "Physics", "Professor1"},
            {"Friday", "1:00 PM - 2:00 PM", "IT", "Mathematics", "Professor1"}
        };

        // professor 2 (12-)
        String[][] prof2Schedule = {
            {"Monday", "12:00 PM - 1:00 PM", "CS", "Computer Science", "Professor2"},
            {"Monday", "1:00 PM - 2:00 PM", "IT", "Chemistry", "Professor2"},
            {"Tuesday", "12:00 PM - 1:00 PM", "IT", "Computer Science", "Professor2"},
            {"Tuesday", "1:00 PM - 2:00 PM", "CS", "Chemistry", "Professor2"},
            {"Wednesday", "12:00 PM - 1:00 PM", "CS", "Computer Science", "Professor2"},
            {"Wednesday", "1:00 PM - 2:00 PM", "IT", "Chemistry", "Professor2"},
            {"Thursday", "12:00 PM - 1:00 PM", "IT", "Computer Science", "Professor2"},
            {"Thursday", "1:00 PM - 2:00 PM", "CS", "Chemistry", "Professor2"},
            {"Friday", "12:00 PM - 1:00 PM", "CS", "Computer Science", "Professor2"},
            {"Friday", "1:00 PM - 2:00 PM", "IT", "Chemistry", "Professor2"}
        };

        // professor 3 (6 AM - 12 PM)
        String[][] prof3Schedule = {
            {"Monday", "8:00 AM - 9:00 AM", "CS", "English", "Professor3"},
            {"Monday", "9:00 AM - 10:00 AM", "IT", "English", "Professor3"},
            {"Tuesday", "8:00 AM - 9:00 AM", "IT", "English", "Professor3"},
            {"Tuesday", "9:00 AM - 10:00 AM", "CS", "English", "Professor3"},
            {"Wednesday", "8:00 AM - 9:00 AM", "CS", "English", "Professor3"},
            {"Wednesday", "9:00 AM - 10:00 AM", "IT", "English", "Professor3"},
            {"Thursday", "8:00 AM - 9:00 AM", "IT", "English", "Professor3"},
            {"Thursday", "9:00 AM - 10:00 AM", "CS", "English", "Professor3"},
            {"Friday", "8:00 AM - 9:00 AM", "CS", "English", "Professor3"},
            {"Friday", "9:00 AM - 10:00 AM", "IT", "English", "Professor3"}
        };

        // add all professor schedules to timetables
        for (String[] entry : prof1Schedule) {
            timetables.add(createTimetable((long) timetableId++, entry[4], entry[2], entry[1], entry[0], entry[3]));
        }
        for (String[] entry : prof2Schedule) {
            timetables.add(createTimetable((long) timetableId++, entry[4], entry[2], entry[1], entry[0], entry[3]));
        }
        for (String[] entry : prof3Schedule) {
            timetables.add(createTimetable((long) timetableId++, entry[4], entry[2], entry[1], entry[0], entry[3]));
        }

        return timetables;
    }

    public List<Professor> getProfessors() {
        List<Professor> professors = new ArrayList<>();
        professors.add(createProfessor(1L, "Professor1", "jeelrupareliya255@gmail.com", "10:00", "16:00"));
        professors.add(createProfessor(2L, "Professor2", "jeelrupareliya255@gmail.com", "12:00", "18:00"));
        professors.add(createProfessor(3L, "Professor3", "jeelrupareliya255@gmail.com", "06:00", "12:00"));
        return professors;
    }

    private Timetable createTimetable(Long id, String professorName, String branch, String timeSlot, String scheduleDay, String subject) {
        Timetable timetable = new Timetable();
        timetable.setId(id);
        timetable.setProfessorName(professorName);
        timetable.setBranch(branch);
        timetable.setTimeSlot(timeSlot);
        timetable.setScheduleDay(scheduleDay);
        timetable.setSubject(subject);
        return timetable;
    }

    private Professor createProfessor(Long id, String name, String email, String availableFrom, String availableTo) {
        Professor professor = new Professor();
        professor.setId(id);
        professor.setName(name);
        professor.setEmail(email);
        professor.setAvailableFrom(availableFrom);
        professor.setAvailableTo(availableTo);
        return professor;
    }
}