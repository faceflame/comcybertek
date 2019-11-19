package com.cybertek.tests.HOMEWORK_And_Practice.TESTNG;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CheckHiddenElement {

    @Test
            public void test(){

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.tempmailaddress.com/");


        driver.findElement(By.cssSelector("tr > td.from")).click();

        System.out.println("clicked");

        //


    }
}
