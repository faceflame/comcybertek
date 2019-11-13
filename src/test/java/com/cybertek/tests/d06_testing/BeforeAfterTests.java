package com.cybertek.tests.d06_testing;

import org.testng.annotations.*;

public class BeforeAfterTests {

    @Test
    public void test1() {
        System.out.println("This is test one");

    }

    @Test

    public void test2() {
        System.out.println("This is test two");
    }

    @BeforeMethod
    public void setupMethod() {
        System.out.println("BEFORE METHOD");
        System.out.println("OPENING CHROME");
    }

    @AfterMethod
    public void teardownMethod(){
        System.out.println("AFTER METHOD");
        System.out.println("CLOSING DOWN THE CHROME");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("BEfore Class: Running only Once!");
    }


@AfterClass
    public void afterClass(){
        System.out.println("After Class: Running only Once!");
    }


}
