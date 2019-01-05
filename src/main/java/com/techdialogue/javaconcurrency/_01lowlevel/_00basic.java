package com.techdialogue.javaconcurrency._01lowlevel;

import java.util.Arrays;
import java.util.stream.Stream;

public class _00basic {

    public static void main(String[] args) {

        //Process

        //Thread

        //Process vs Thread

        //Java thread has following states
        System.out.println("**************** THREAD STATES in JAVA ********************");
        Arrays.stream(Thread.State.values()).forEach(System.out::println);
        System.out.println("***********************************************************");

        //Scheduler
    }
}
