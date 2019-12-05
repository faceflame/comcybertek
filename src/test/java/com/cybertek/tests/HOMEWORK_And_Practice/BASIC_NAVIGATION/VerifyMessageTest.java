package com.cybertek.tests.HOMEWORK_And_Practice.BASIC_NAVIGATION;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyMessageTest {
private WebDriver driver;
    @BeforeMethod
    public void setDriver(){
         driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

    }

    @Test

    public void verifyButton2(){
        String expectedMessage="Clicked on button two!";
        driver.findElement(By.cssSelector("[name^='button2']")).click();
        String actualMessage=driver.findElement(By.id("result")).getText();

        Assert.assertEquals(actualMessage, expectedMessage);
    }


    @Test
    public void verifyButton5(){
        String expectedMessage="Clicked on button five!";

        driver.findElement(By.id("btn324")).click();
        String actualMessage=driver.findElement(By.cssSelector("id='result'")).getText();

        Assert.assertEquals(actualMessage, expectedMessage, "This did not work out");


    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
