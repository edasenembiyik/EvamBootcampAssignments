package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//SpringBootApplication below , tell us Spring Cointainer start here
@SpringBootApplication
public class StudentRegistrationApplication {

    public static void main(String[] args) {

        // Below code run the Spring Aplication.
        SpringApplication.run(StudentRegistrationApplication.class, args);
        StudentRead studentRead = new StudentRead(); //creating new object
        Thread readThread = new Thread(studentRead);     //Create new thread for studentRead
        StudentWrite studentWrite = new StudentWrite();//creating new object
        Thread writeThread = new Thread(studentWrite); //Create new thread for studentWrite
        readThread.start(); // This code starts tread for StudentRead.
        writeThread.start();// This code starts tread for StudentWrite.

    }


}