package com.techdialogue.javaconcurrency._01lowlevel;

/**
 *  1. Threads communicate information by updating a shared mutable object (somewhere on the heap)
 *
 *      Hence one has to make sure that the access to the shared part is serialized (accessed by only one thread at a time)
 *      In Java this is done by wrapping the code inside synchronized
 *      Synchronized can get a lock on the current object(or any other object acting as monitor)
 *      The lock can be held only by one object at a time
 *
 *  2. Threads only have the power to stop their own execution by calling wait() on a monitor
 *      (After calling wait the thread gives up the monitor)
 *
 *     Sleep can also stop the execution but it does not give up the monitors if held by the thread
 *
 *     Once stopped they can be resumed only by the underlying OS scheduler
 *
 *
 *     But how does the scheduler know its time to wake up a thread ?
 *     it doesn't
 *     We can only signal the scheduler by calling a notify method on the monitor (What happens when notify is called ???)
 *     It's upto the scheduler to decide
 *
 *     Hence there can be spurious wakeups.
 *     Scheduler might try to resume a thread before the waiting condition is fulfilled
 *     Therefore it's good to wait in a loop on that condition before resuming execution
 *
 *     A thread becomes eligible for resuming if it is not waiting on any lock
 *     (hence need for high level concurrency constructs was needed)
 *
 *     Thread's state can be changed by calling wait, notify, notifyall methods of the object that acts as monitor
 *
 *     It makes sense for a thread to halt its execution and wait till the shared data becomes available
 *     When the shared state is updated by a different thread it sends a notify signal to the waiting thread, and it can now resume execution
 *
 *  3. Notify notifies all the threads waiting on the object, we cannot notify a specific thread.
 *      It's upto the scheduler to decide which thread will resume execution
 *
 * 4. join and interrupt are Thread methods
 *
 *  4. Wait gives up lock ??
 */
public class _04ThreadCommunication {

    //somewhat poor choice of words
    //Synchronized ==> Serialized ==> Result is synchronization between threads
    //Concurrency ==> Decomposability (property of a single program) ==> Result is execution of these parts Concurrently

    public static void main(String[] args) {
        Object obj =  new Object();

        //System.out.println("This: "+this);

        Runnable Run1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("1 starts");
                System.out.println("1 this is: "+this);
                System.out.println("1 starting to wait");
                try {
                    synchronized (obj)  {
                        obj.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("1 was interrupted");
                }
                System.out.println("1 resumed execution");
            }
        };


        Runnable Run2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("2 starts");
                System.out.println("2 this is: "+this);
                System.out.println("2 Notifying all waiting threads");
                synchronized (obj) {
                    obj.notifyAll();
                }
                System.out.println("2 finising execution");
            }
        };

        //this refers to different objects in both the runnables, using wait and notify on this will never work
        //use a different object as lock

        new Thread(Run1).start();
        new Thread(Run2).start();
    }
}


