package com.mv.week5.behavioraldesignpatterns.chainofresponsibility;

public class MainClass {

    public static void main(String[] args) {

        // Chain of Responsibility is a behavioral design pattern that lets you pass requests along a
        // chain of handlers.
        // Upon receiving a request, each handler decides either to process the request or
        // to pass it to the next handler in the chain.

        // Chain of Responsibility relies on transforming particular behaviors into stand-alone objects called handlers.
        // In our case, each check should be extracted to its own class with a single method that performs the check.
        // The request, along with its data, is passed to this method as an argument.
        //The pattern suggests that you link these handlers into a chain.
        // Each linked handler has a field for storing a reference to the next handler in the chain.
        // In addition to processing a request, handlers pass the request further along the chain.
        // The request travels along the chain until all handlers have had a chance to process it.

        // A handler can also decide not to pass the request further down the chain
        // and effectively stop any further processing.

        // Each check we can transform to a stand-alone object.
        // Having multiple if-else check would become cumbersome.
        // If we want to use condition in multiple place, then also it would result in code duplicacy.
        // So it is better to convert those checks to objects.

        Chain additionOperation = new AdditionOperation();
        Chain subtractionOperation = new SubtractionOperation();
        Chain multiplicationOperation = new MultiplicationOperation();
        Chain divisionOperation = new DivisionOperation();
        Request numbers = new Request(2, 3, Operation.MULTIPLICATION);

        additionOperation.setNextChain(subtractionOperation);
        subtractionOperation.setNextChain(multiplicationOperation);
        multiplicationOperation.setNextChain(divisionOperation);

        additionOperation.calculate(numbers);

    }

}
