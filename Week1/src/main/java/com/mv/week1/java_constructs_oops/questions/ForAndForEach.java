package com.mv.week1.java_constructs_oops.questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ForAndForEach {

    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> linkedList = new LinkedList<>(List.of(7, 8, 9, 10, 1));

        // Both for and for each loop are equally fast

        // For
        for (int i = 0; i < arrayList.size(); i++)
            System.out.println(arrayList.get(i));

        for (int x : arrayList)
            System.out.println(x);

        for (int i = 0; i < linkedList.size(); i++)
            System.out.println(linkedList.get(i));

        for (int x : linkedList)
            System.out.println(x);

    }

}
