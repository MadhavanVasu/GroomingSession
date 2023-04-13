package com.mv.week4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsDemo {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        List<Integer> perfectSquares = numbers.stream().map(a -> a*a).collect(Collectors.toList());
        List<Integer> perfectSquaresLL = numbers.stream().map(a -> a*a).collect(Collectors.toCollection(LinkedList::new));
        System.out.println(perfectSquares);
        System.out.println(perfectSquaresLL);

    }

}
