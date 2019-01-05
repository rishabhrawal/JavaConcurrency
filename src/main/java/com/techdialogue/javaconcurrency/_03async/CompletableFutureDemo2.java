package com.techdialogue.javaconcurrency._03async;

import com.techdialogue.javaconcurrency.Utility;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static java.lang.Thread.sleep;

public class CompletableFutureDemo2 {

    /**
     * Execution of the thread starts as soon as we call runAsync or supplyAsync
     * if we call get on a supplier it blocks till the result is ready.
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        //return will always be Void for runAsync(Runnable)
        CompletableFuture<Void> cf1 = CompletableFuture.runAsync(()->{
            System.out.println("Executing Runnable");
            System.out.println("Runnable thread: "+Thread.currentThread().getName());
            System.out.println("India");
        });

        //return can be anything depending on the supplier
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(()->{
            System.out.println("Executing supplier");
            System.out.println("Supplier thread: "+Thread.currentThread().getName());
            Utility.longDelay();
            return "won";
        });

        /*try {
            String result = cf2.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/

        //since get is blocked we can use the result in non blocking fashion as follows
        cf2.thenAccept(System.out::println);

        System.out.println("finished...");
        Utility.longDelay(); //wait else the program execution will finish killing the threads in pool

    }
}
