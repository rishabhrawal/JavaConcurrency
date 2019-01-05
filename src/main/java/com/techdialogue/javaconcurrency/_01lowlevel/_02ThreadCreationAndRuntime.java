package com.techdialogue.javaconcurrency._01lowlevel;

import com.techdialogue.javaconcurrency.Utility;

public class _02ThreadCreationAndRuntime {

    public static void main(String[] args) {
        Thread t1 = new Thread(){
            public void run(){
            System.out.println();
            System.out.print("Thread 1 started");
            Utility.longDelay();
            System.out.print("Thread 1 completed");
        }};

        //Runtime does not exit untill all the threads have finished execution
        //If the thread is marked as daemon, jre kills it when the main method completes
        //uncomment below line to see the difference
        //t1.setDaemon(true);
        t1.start();
    }
}
