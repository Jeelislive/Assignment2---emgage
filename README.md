# Overview

**Demo Scheduler** is a Spring Boot application that automates **timetable generation** and **email delivery** for professors and students.  

## Features

### Monday Module  
- Sends **weekly emails** to professors **every Monday at 8 AM** (or **every minute** for testing).  
- Email includes **three Excel attachments**:
  - **Personal Timetable** – Professor’s schedule.  
  - **CS Students Timetable** – Computer Science branch schedule.  
  - **IT Students Timetable** – Information Technology branch schedule.  

### Half-Hourly Module  
- Sends a **sample timetable email every 30 minutes** (or **every minute** for testing).  

## Timetable Details
- Uses **AM/PM timing** (e.g., `8:00 AM - 9:00 AM`).  
- Readable formatting with:
  - **Bold headers**  
  - **Auto-sized columns**  

## Subjects
- **Mathematics**  
- **Physics**  
- **Computer Science**  
- **Chemistry**  
- **English**
