package com.techdialogue.javaconcurrency._01lowlevel;

public class _02ThreadCreation {
    public static void main(String[] args) {

        System.out.println("So which thread is this ? "+ Thread.currentThread().getName());

        //============================================
        //Creating new Thread by extending Thread class
        Thread thread1 =  new Thread(){
          public void run(){
              System.out.println("Running in a new thread");
              System.out.println("Current thread is: "+Thread.currentThread().getName());
          }
        };
        thread1.start();

        //===========================================
        //Creating new Thread by implemnting Runnable
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("This is a Runnable");
                System.out.println("Runnable is runnning on thread: "+Thread.currentThread().getName());
            }
        };
        Thread thread2 = new Thread(runnable);
        thread2.start();

    }


    /**
     * What's the problem:
     * 1. How many threads should I create? rampant creation of threads hinders performance.
     * Getting a new thread to run and removing an already running thread is called Context switching and it needs resources
     * Each Java thread is mapped to a an underlying OS thread.
     * Since there are fixed OS threads based on the machine more java threads would mean more context switching
     *
     * 2. Thread management is cumbersome and really difficult especially interthread communication
     * 3. Sharing state can lead to various problems(DeadLocks, LiveLocks and Starvation)
     */
}
