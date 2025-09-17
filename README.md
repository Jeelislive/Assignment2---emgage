# Overview Assignment2 - Emgage

**mail scheduler** is a spring boot application that automates **timetable generation** and **email delivery** for professors and students.  

## Features

### monday module  
- sends **weekly emails** to professors **every monday at 8 AM** (or **every minute** for testing).  
- Email includes **three Excel attachments**:
  - **Personal timetable** – professor’s schedule.  
  - **CS students timetable** – Computer Science branch schedule.  
  - **IT students timetable** – Information Technology branch schedule.  

### Half-Hourly Module  
- Sends a **sample timetable email every 30 minutes** (or **every minute** for testing).  

## Timetable Details
- uses **AM/PM timing** (e.g., `8:00 AM - 9:00 AM`).  
- readable formatting with:
  - **headers**  
  - **auto-sized columns**  

## Subjects
- **mathematics**  
- **physics**  
- **computer science**  
- **chemistry**  
- **english**
