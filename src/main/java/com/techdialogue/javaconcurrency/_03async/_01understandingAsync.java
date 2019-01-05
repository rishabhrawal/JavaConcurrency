package com.techdialogue.javaconcurrency._03async;

public class _01understandingAsync {

    //Async means somthing that is not heppenning right now
    //probably not in the current flow

    // https://en.wikipedia.org/wiki/Asynchronous_procedure_call
    //If a piece of code(probably a method call) is executed in an asynchronous way
    //it means that it will be stacked up somewhere else for execution
    //(it can be executed later by the same thread or right now on a different thread, depending on the language model)

    //the gist is current program flow will continue and it will not wait for the nethod to return

    //Javascrit is single threaded, it manages asynchrony by pushing these calls on a separate queue
    //these calls can be executed(network calls) either by a webworker or picked by the Main thread on the call stack
    //So how to handle the results in this case ? Callbacks ==> functions to be run once the execution is complete

}
