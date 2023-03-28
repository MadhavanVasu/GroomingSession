package com.mv.week1.part2.questions;

import java.util.*;

public class CountVowelStrings {

    public static int vowelStrings(String[] words, int left, int right) {
        int res = 0;
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        for (int i = left; i <= right; i++) {
            if (set.contains(words[i].charAt(0)) && set.contains(words[i].charAt(words[i].length() - 1)))
                res += 1;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"hey","aeo","mu","ooo","artro"};
        int left = 1;
        int right = 4;
        System.out.println(vowelStrings(words, left, right));

    }
}
