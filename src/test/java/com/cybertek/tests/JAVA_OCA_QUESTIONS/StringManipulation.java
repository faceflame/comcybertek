package com.cybertek.tests.JAVA_OCA_QUESTIONS;

public class StringManipulation {
    public static void main(String[] args) {

        StringBuilder s1= new StringBuilder("Java");
        String s2="Love";

        s1.append(s2);
        s1.substring(4);
        int a=s1.indexOf(s2);

        System.out.println(a);

    }
}
