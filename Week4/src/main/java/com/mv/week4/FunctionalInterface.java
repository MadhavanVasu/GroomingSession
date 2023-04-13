package com.mv.week4;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://blog.knoldus.com/functional-interfaces-in-java-8/
public class FunctionalInterface {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // Predicate<T>
        // It represents a function that takes an input of type T and returns a boolean value.
        // It is often used for filtering elements in a collection based on a condition.
        // It has a single method test(T t) which returns a boolean value.
        // Filter even numbers using Predicate
        Predicate<Integer> isEven = num -> num % 2 == 0;
        List<Integer> evenNumbers = numbers.stream()
                .filter(isEven)
                .collect(Collectors.toList());
        System.out.println(isEven.test(4));
        System.out.println(isEven.test(3));
        System.out.println(evenNumbers); // Output: [2, 4, 6, 8, 10]

        // Supplier<T>
        // It represents a function that takes no input and returns a value of type T.
        // It is often used for providing values or generating data on demand.
        // It has a single method get() which returns a value of type T.
        // Generate random numbers using Supplier
        Supplier<Integer> randomGenerator = () -> new Random().nextInt(100);
        List<Integer> randomNumbers = Stream.generate(randomGenerator)
                .limit(10)
                .collect(Collectors.toList());

        System.out.println(randomNumbers); // Output: [37, 47, 57, 60, 6, 13, 60, 86, 91, 1]



    }

}
