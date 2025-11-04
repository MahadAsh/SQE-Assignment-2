package com.example.app;

public class StringUtils {
    public static boolean isPalindrome(String s){
        if(s == null) throw new IllegalArgumentException("null");
        String cleaned = s.replaceAll("\\s+","").toLowerCase();
        return new StringBuilder(cleaned).reverse().toString().equals(cleaned);
    }
    public static String reverse(String s){
        if(s == null) return null;
        return new StringBuilder(s).reverse().toString();
    }
}
