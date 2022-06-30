package com;

import static java.lang.System.out;

// If we want to use treath , we have to implements Runnable
public class StudentWrite implements Runnable {
    @Override
    public void run() {
        // As assignment want, Write Json operation has to wait Read Json Operation
        //  synchronized keywords provide waiting
        synchronized (StudentRead.syncObject) {
            out.println( Thread.currentThread().getName() +"is waiting");
            //Below try catch block works until Student Read process finish and wait for sync object notify.
            while (!StudentRead.isReadProcessDone) {
                try {
                    StudentRead.syncObject.wait();
                    out.println( Thread.currentThread().getName() +" is waiting");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //Write readed objects from student list
            StudentRead.studentList.stream().forEach(out::println);
        }
    }
}

