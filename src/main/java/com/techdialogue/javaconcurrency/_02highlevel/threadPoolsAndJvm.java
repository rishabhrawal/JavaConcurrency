package com.techdialogue.javaconcurrency._02highlevel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class threadPoolsAndJvm {
    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(5);


        es.submit(()->{
                System.out.println("Task complete");
        });

        //shut down the executor or else Runtime will not exit
        //alternatively use daemons which are killed main program execution finishes
        es.shutdown();

    }
}
