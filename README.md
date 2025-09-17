  # Overview Assignment2 - Emgage
  
  **mail scheduler** is a spring boot application that automates **timetable generation** and **email delivery** for professors and students.  
  
  ## Prerequisites
  - **Java 17**
  - **Maven 3.6+**
  - **Gmail account** with an **app-specific password**
  - **H2 database** (in-memory, configured by default)
  
  ## Screenshots
Below are some preview screenshots of the application:

![Screenshot 1](https://res.cloudinary.com/dupv4u12a/image/upload/v1758133952/Screenshot_from_2025-09-17_23-53-36_bfg126.png)  
![Screenshot 2](https://res.cloudinary.com/dupv4u12a/image/upload/v1758133952/Screenshot_from_2025-09-17_23-53-47_qmwvck.png)  
![Screenshot 3](https://res.cloudinary.com/dupv4u12a/image/upload/v1758133952/Screenshot_from_2025-09-17_23-53-22_teym2b.png)  
![Screenshot 4](https://res.cloudinary.com/dupv4u12a/image/upload/v1758133952/Screenshot_from_2025-09-17_23-54-11_gmtzyb.png)  
![Screenshot 5](https://res.cloudinary.com/dupv4u12a/image/upload/v1758133952/Screenshot_from_2025-09-17_23-53-54_nifxas.png)  

  
  ## Configure Gmail
  
  Generate an app-specific password:
      Go to Google Security
   → 2-Step Verification → App passwords.
   
  -> Update src/main/resources/application.properties:
  
  1.spring.mail.username=your-email@gmail.com
  2.spring.mail.password=<your-16-character-password>
  
  3️⃣ Build and Run
  mvn clean install
  mvn spring-boot:run
  
  
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
  - 3 Professors 
  
  ## Subjects
  - **mathematics**  
  - **physics**  
  - **computer science**  
  - **chemistry**  
  - **english**
