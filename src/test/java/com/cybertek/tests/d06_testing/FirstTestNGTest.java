package com.cybertek.tests.d06_testing;


import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class FirstTestNGTest {

    @Test
    public void test1() {
        System.out.println("This is the first step");

    }


    @Ignore
    @Test
    public void test2(){
        System.out.println("This is the second test");
    }
}
