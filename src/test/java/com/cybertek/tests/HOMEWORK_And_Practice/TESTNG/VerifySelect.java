package com.cybertek.tests.HOMEWORK_And_Practice.TESTNG;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifySelect {

    @Test(description = "Verify selected state")
    public void test() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Autocomplete")).click();

        driver.findElement(By.id("myCountry")).sendKeys("United States of America");

        driver.findElement(By.cssSelector("[onclick='log()']")).click();

        String actualSelection = driver.findElement(By.id("result")).getText();
        String expectedSelection = "You selected: United States of America";

        Assert.assertEquals(actualSelection, expectedSelection, "Selection message is wrong");

        driver.quit();
    }

}
