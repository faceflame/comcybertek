package com.cybertek.tests.d06_testing;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionsTest {

    @Test
    public void test1() {
        System.out.println("First Assertion");
        Assert.assertEquals(1, "One");

        Assert.assertEquals(1, 2);


    }

    @Test
    public void test2() {
        System.out.println("Second Assertion");
        Assert.assertNotEquals("two", "Two");
    }

    @Test
    public void test3() {
        System.out.println("Third Assertion");
        String expectedTitle = "CYCE";
        String actualTitle = "CY";

        Assert.assertTrue(expectedTitle.startsWith(actualTitle));
    }

    @Test
    public void test4() {
        System.out.println("Fourth Assertion");
        Assert.assertFalse(1 < 4);
    }

    @Test
    public void test5() {

        Assert.assertEquals("Ccbt", "Cct", "Title did not match");



    }


}
