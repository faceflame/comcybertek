package com.cybertek.tests.d7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Radio_Buttons_2_Test {

    @Test
    public void test(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement basketball= driver.findElement(By.id("basketball"));
        WebElement football= driver.findElement(By.id("football"));

        //verify if both radio buttons are not selected

        Assert.assertFalse(basketball.isSelected());

        Assert.assertFalse(football.isSelected());


        driver.quit();



    }
}
