package com.mv.week1.part2.questions;

public class ReverseAString {

    public static String reverseStringMethod1(String str) {
        StringBuilder sb = new StringBuilder(str);
        int n = sb.length();
        for (int i = 0; i < n / 2; i++) {
            String temp = sb.substring(i, i + 1);
            sb.replace(i, i + 1, sb.substring(sb.length() - i - 1, sb.length() - i));
            sb.replace(sb.length() - i - 1, sb.length() - i, temp);
        }
        return sb.toString();
    }

    public static String reverseStringMethod2(String str) {
        StringBuilder sb = new StringBuilder("");
        int n = str.length();
        for (int i = n - 1; i >= 0; i--) sb.append(str.charAt(i));
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "Hello world";
        System.out.println(reverseStringMethod2(str));
    }

}
