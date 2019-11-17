package com.cybertek.tests.HOMEWORK_MarufJon.BASIC_NAVIGATION;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UdemyPractice {

    @Test

    public void login() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://login.salesforce.com/");

        driver.findElement(By.id("username")).sendKeys("yollart");
        driver.findElement(By.id("password")).sendKeys("olsun");
        driver.findElement(By.id("rememberUn")).click();
        driver.findElement(By.name("Login")).click();

        String expectedErrorMessage = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
        String actualErrorMessage = driver.findElement(By.id("error")).getText();

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

        Thread.sleep(2000);

        driver.quit();

    }

}
