package com.techdialogue.javaconcurrency;

public class Utility {

    public static void delay(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void longDelay(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void veryLongDelay(){
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void randomDelay(){
        try {
            Thread.sleep(1000 + (long)Math.random()*10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
