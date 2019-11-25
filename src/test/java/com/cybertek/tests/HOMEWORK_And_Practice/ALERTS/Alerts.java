package com.cybertek.tests.HOMEWORK_And_Practice.ALERTS;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Alerts {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @Test
    public void test(){
        String name = "Ozcan";
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("alertbtn")).click();

        String ActualpopupMessage=driver.switchTo().alert().getText();
        System.out.println(ActualpopupMessage);
        driver.switchTo().alert().accept();
        String ExpectedpopupMessage="Hello Ozcan, share this practice page and share your knowledge";

        Assert.assertEquals(ActualpopupMessage, ExpectedpopupMessage, "Expected alert message does not match");


        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("confirmbtn")).click();
        String actual_PopupQuestion=driver.switchTo().alert().getText();
        String expected_PopupQuestion="Hello " + name +  " Are you sure you want to confirm?";

        Assert.assertEquals(actual_PopupQuestion, expected_PopupQuestion, "PopUp question is wrong");

        driver.switchTo().alert().dismiss();

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
