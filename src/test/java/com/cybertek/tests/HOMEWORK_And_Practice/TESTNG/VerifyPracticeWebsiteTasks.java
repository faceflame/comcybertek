package com.cybertek.tests.HOMEWORK_And_Practice.TESTNG;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VerifyPracticeWebsiteTasks {

    private WebDriver driver;

    @BeforeMethod(description = "browser setup")
    public void setDriver(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test1(){
        driver.findElement(By.linkText("Status Codes")).click();
        driver.findElement(By.linkText("200")).click();

        String expectedMessage= "This page returned a 200 status code";
        String actualMessage= driver.findElement(By.tagName("p")).getAttribute("textContent");

        Assert.assertEquals(actualMessage, expectedMessage, "Error Message is wrong");
    }

    @Test
    public void test2(){
        driver.findElement(By.linkText("301")).click();
        String expectedMessage= "This page returned a 301 status code";
        String actualMessage= driver.findElement(By.tagName("p")).getText();

        Assert.assertEquals(actualMessage, expectedMessage, "Error Message wrong");

    }

    @Test
    public void test3(){
        driver.findElement(By.linkText("404")).click();
        String expectedMessage= "This page returned a 404 status code";
        String actualMessage= driver.findElement(By.tagName("p")).getText();

        Assert.assertEquals(actualMessage, expectedMessage, "Error Message wrong");

    }

    @Test
    public void test4(){
        driver.findElement(By.linkText("500")).click();
        String expectedMessage= "This page returned a 500 status code";
        String actualMessage= driver.findElement(By.tagName("p")).getText();

        boolean outcome=actualMessage.contains(expectedMessage);

        Assert.assertTrue(outcome);



    }

    @AfterMethod(description = "close browser")
    public void tearDown(){
        driver.quit();
    }
}
