package com.mv.week1.part2.questions;

public class ValidPalindrome {

    public static boolean validPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++)
            if (s.charAt(i) != s.charAt(n - i - 1))
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("aabaa"));
    }

}
