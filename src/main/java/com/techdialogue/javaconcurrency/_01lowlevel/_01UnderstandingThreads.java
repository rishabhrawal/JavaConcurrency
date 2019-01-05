package com.techdialogue.javaconcurrency._01lowlevel;

public class _01UnderstandingThreads {

    public static void main(String[] args) {
        System.out.println("Processors: "+ Runtime.getRuntime().availableProcessors());
        System.out.println("Active Thread count:"+ Thread.activeCount());
        System.out.println("Default Exception handler: "+Thread.getDefaultUncaughtExceptionHandler());

        //Concept of threads and lock
        System.out.println("Current Thread: "+ Thread.currentThread().getName());
        System.out.println("Current thread state:"+Thread.currentThread().getState());


        //understanding interrupt
        Thread.currentThread().interrupt();
        System.out.println("Checks the interrupt and clears the status: "+Thread.interrupted());
        System.out.println("Interrupt status now: "+Thread.interrupted());
    }
}