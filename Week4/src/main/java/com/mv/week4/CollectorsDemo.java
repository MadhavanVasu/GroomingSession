package com.mv.week4;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsDemo {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> perfectSquares = numbers.stream().map(a -> a * a).collect(Collectors.toList());
        List<Integer> perfectSquaresLL = numbers.stream().map(a -> a * a).collect(Collectors.toCollection(LinkedList::new));
        List<Integer> unmodifiablePerfectSquares = numbers.stream().map(a -> a * a).collect(Collectors.toUnmodifiableList());
        System.out.println(perfectSquares);
        System.out.println(perfectSquaresLL);
        System.out.println(unmodifiablePerfectSquares);
        // Throws UnsupportedOperationException
        // unmodifiablePerfectSquares.add(5);

        // toMap() takes 2 functions are argument.
        // One function should return the key and other should return value.
        // Function.identity() Returns a function that always returns its input argument. (t -> t)
        // Method 1
        Map<String, Integer> map = Arrays.asList("Hello", "World").stream().collect(Collectors.toMap(Function.identity(), String::length));
        // Method 2
        Map<String, Integer> map2 = Arrays.asList("Hello", "World").stream().collect(Collectors.toMap(s -> s, s -> s.length()));
        System.out.println(map);
        System.out.println(map2);
    }

}
