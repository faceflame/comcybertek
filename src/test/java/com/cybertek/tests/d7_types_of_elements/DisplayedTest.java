package com.cybertek.tests.d7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedTest {
@Test
    public void Test1(){

    WebDriver driver = WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();

    driver.get("http://practice.cybertekschool.com/radio_buttons");

    WebElement blue= driver.findElement(By.id("blue"));

    //verify if element is displated on screen, verify

    Assert.assertTrue(blue.isDisplayed());

    driver.quit();



}

}
