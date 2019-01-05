package com.techdialogue.javaconcurrency._01lowlevel;

public class _03ConceptOfLocks {

    public static void main(String[] args) {
        Object obj = new Object();
        System.out.println("Does this thread hold a lock on obj? "+Thread.holdsLock(obj));

        synchronized (obj){
            System.out.println("What about now: "+ Thread.holdsLock(obj));
        }

        _03ConceptOfLocks col = new _03ConceptOfLocks();
        col.dummyMethod();

    }

    synchronized private void dummyMethod(){
        System.out.println("Default behaviour of sychronized method, lock on this object: "+ Thread.holdsLock(this));
    }

}
