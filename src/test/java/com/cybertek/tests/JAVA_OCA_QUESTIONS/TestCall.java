package com.cybertek.tests.JAVA_OCA_QUESTIONS;

class Caller {

    private void init(){
        System.out.println("initialized");
    }

    private void start(){
        init();
        System.out.println("started");
    }

}


public class TestCall {
    public static void main(String[] args) {
        Caller C= new Caller();



    }

}
