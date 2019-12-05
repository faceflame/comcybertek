package com.cybertek.tests.HOMEWORK_And_Practice.Checkboxes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Udemy_Checkboxes_Example {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://qaclickacademy.com/practice.php");

    }

    @Test
    public void test(){

        //Check the first checkbox and verify that it is checked
        WebElement checkbox1=driver.findElement(By.id("checkBoxOption1"));
        checkbox1.click();
        Assert.assertTrue(checkbox1.isSelected());

        //Uncheck the first checkbox and verify that it is unchecked
        checkbox1.click();
        Assert.assertTrue(!checkbox1.isSelected());
        //or
        Assert.assertFalse(checkbox1.isSelected());

        //to get the total numbers on the page

        System.out.println(driver.findElements(By.cssSelector("[type='checkbox']")).size());



    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
