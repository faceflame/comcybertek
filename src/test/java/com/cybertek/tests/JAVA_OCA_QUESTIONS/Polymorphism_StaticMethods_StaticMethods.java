package com.cybertek.tests.JAVA_OCA_QUESTIONS;

abstract class Writer {
    public static void write() {
        System.out.println("writing ....");
    }
}
class author extends Writer {

    public static void write() {
        System.out.println("writing book");
    }
}

public class Polymorphism_StaticMethods_StaticMethods extends Writer{

    public static void write() {
        System.out.println("writing code");
    }
    public static void main(String[] args) {
        Writer w= new Polymorphism_StaticMethods_StaticMethods();
        w.write();

    }
}
