package com.cybertek.tests.HOMEWORK_MarufJon.BASIC_NAVIGATION;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UdemyFacebook {

@Test
    public void test1(){

    WebDriver driver= WebDriverFactory.getDriver("chrome");
    driver.get("https://www.facebook.com/");

    driver.findElement(By.xpath("//input[@name='email']")).sendKeys("aaaa@hoyya.com");
    driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("olmaz");
    driver.findElement(By.xpath("//input[@type='submit']")).click();

    String actualErrorMessage= driver.findElement(By.cssSelector("div[class='fsl fwb fcb']")).getText();
    String expectedErrorMessage="You Can't Do That Right Now";

    Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

    driver.quit();




}

}
