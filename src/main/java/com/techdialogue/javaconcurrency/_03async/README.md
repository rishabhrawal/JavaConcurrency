https://www.youtube.com/watch?v=lyJBtg6Dgwc


Synchronouos code is blocking.
What is meant by Blocking ??
Asynchronous code is non blocking

f(x){
    //takes 500 m_sec
}

g(x){
    //takes 10 m_sec
}


//would take little more than 10 m_sec
h(x){   
     a = f(x); //non blocking, async
     b = g(x);
}


how can we make asynchronous method calls
1. In single threaded model ==> Any asynchronous call is pushed in a separate queue and can be hanled later on
2. In multithreaded model ==> We have the privilege to execute it in parallel on a separate thread

The underlying premise of an asynchronous execution is that the method call should return immediately
and should not wait for the method execution to finish.

Thus it is not a problem if you have an independent piece of code block to be executed
But what to do if I want the method to return some result.

Now things get tricky again
1. Either you try to  get the result at somepoint in the future, in a synchronous way (get blocked if the result is not available)
2. Pass a Function that should be exucuted once this call finishes (Javascript do it by passing callbacks)

CompletableFuture implements Future and CompletionStage interfaces.<br>
Future adds the async capabilities, but the method get() is still blocking.<br>
CompletionStage adds the async capabilities, runAsync() supplyAsync()