package com.cybertek.tests.HOMEWORK_And_Practice.BASIC_NAVIGATION;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UdemyReddit {

    @Test
    public void test() throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("https://www.rediff.com/");

        driver.findElement(By.xpath("//a[@class='signin']")).click();

        driver.findElement(By.xpath("//input[contains(@id, 'log')]")).sendKeys("olacak");
        driver.findElement(By.xpath("//input[contains(@id, 'pa')]")).sendKeys("olmalar");
        driver.findElement(By.id("remember")).click();
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        String actualErrorMessage=driver.findElement(By.xpath("//div[@class='login-form']/div")).getText();
        String expectedErrorMessage="Wrong username and password combination.";

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);


        driver.quit();





    }
}
