package com.techdialogue.javaconcurrency._03async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;


public class CompletableFutureDemo1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /**
         * *********************************************************************
         * It implements Future and CompletionStage interfaces
         * Now this future can be completed by any one, even by a separate Thread
         * We have a handle to it, in the current execution flow to get the result
         */
        CompletableFuture<Integer> cf1 = new CompletableFuture<>();
        cf1.complete(5);
        System.out.println("Value "+cf1.get());
        cf1.complete(8);
        System.out.println("Cannot be completed again: "+cf1.get());
        System.out.println("******************************************");


        /**
         * *********************************************************************
         * Running it in a separate Thread or ExecutorService,
         * For Asynchronous call
         */

        CompletableFuture<Integer> cf2 = new CompletableFuture<>();
        ExecutorService es = Executors.newFixedThreadPool(5);
        es.submit(()->{
            System.out.println("Current Thread: "+ Thread.currentThread().getName());
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int value = 5; //probably getting from a network call
            cf2.complete(value);});

        try {

            // get method is blocking
            // though we started the task asynchronously
            // but still our program has to wait to get the result and handle it
            Integer result = cf2.get();
            System.out.println("Was blocked :( but finally got the resut: "+result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("******************************************");

        /**
         * ****************************************************************************
         * Truly Asynchronous behaviour
         * by using CompletionStage
         */
        CompletableFuture<Integer> cf3 = new CompletableFuture<>();
        es.submit(()->{
            System.out.println("Current Thread: "+ Thread.currentThread().getName());
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int value = 5; //probably getting from a network call
            cf3.complete(value);});
        cf3.thenAccept(System.out::println);
        System.out.println("Not blocked anymore :)");

        //es.shutdownNow();
    }
}
