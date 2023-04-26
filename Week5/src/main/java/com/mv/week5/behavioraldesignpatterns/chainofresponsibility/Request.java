package com.mv.week5.behavioraldesignpatterns.chainofresponsibility;

public class Request {

    private int a;
    private int b;
    private Operation operationToBePerformed;

    public Request(int a, int b, Operation operationToBePerformed) {
        this.a = a;
        this.b = b;
        this.operationToBePerformed = operationToBePerformed;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public Operation getOperationToBePerformed() {
        return operationToBePerformed;
    }
}
