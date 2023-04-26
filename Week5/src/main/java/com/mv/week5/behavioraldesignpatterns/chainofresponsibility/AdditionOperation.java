package com.mv.week5.behavioraldesignpatterns.chainofresponsibility;

public class AdditionOperation implements Chain {

    private Chain nextInChain;

    @Override
    public void setNextChain(Chain chain) {
        this.nextInChain = chain;
    }

    @Override
    public void calculate(Request numbers) {
        if (numbers.getOperationToBePerformed() == Operation.ADD)
            System.out.println(numbers.getA() + numbers.getB());
        else if (nextInChain != null)
            nextInChain.calculate(numbers);
        else
            System.out.println("Can't proceed further...\nWorks only for add, sub, multiplication and division operation");
    }
}
