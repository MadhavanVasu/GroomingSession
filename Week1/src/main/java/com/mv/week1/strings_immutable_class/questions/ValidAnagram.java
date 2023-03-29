package com.mv.week1.strings_immutable_class.questions;

import java.util.HashMap;

public class ValidAnagram {

    public static boolean validAnagram(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        for (char c : s2.toCharArray()) map.put(c, map.getOrDefault(c, 0) - 1);
        for (char c : map.keySet())
            if (map.get(c) != 0)
                return false;
        return true;
    }

    public static void main(String[] args) {

        System.out.println(validAnagram("care", "race"));

    }

}
