package com.mv.week5.behavioraldesignpatterns.chainofresponsibility;

// Each concrete class of this chain interface are called as handlers
// They can either handle the request or pass the request to the next handler in chain
// They can also not process the request and also not pass it to the next handler.
public interface Chain {

    public void setNextChain(Chain chain);

    public void calculate(Request numbers);

}
