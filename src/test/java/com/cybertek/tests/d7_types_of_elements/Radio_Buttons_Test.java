package com.cybertek.tests.d7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Radio_Buttons_Test {
    @Test
    public void test1() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueButton = driver.findElement(By.id("blue"));
        System.out.println(blueButton.getAttribute("type"));
        System.out.println(blueButton.getAttribute("href"));
        System.out.println(blueButton.getAttribute("checked"));
        System.out.println(blueButton.getAttribute("outerHTML"));
        System.out.println(blueButton.getAttribute("value"));
        System.out.println(blueButton.getAttribute("innerHTML"));

        System.out.println();



        WebElement redButton = driver.findElement(By.id("red"));

        System.out.println("Is blue selected?" + blueButton.isSelected());
        System.out.println("Is red selected " + redButton.isSelected());

        Assert.assertTrue(blueButton.isSelected());
        Assert.assertFalse(redButton.isSelected());

        redButton.click();


        System.out.println("Is blue selected?" + blueButton.isSelected());
        System.out.println("Is red selected " + redButton.isSelected());

        //verify blue is not selected
        Assert.assertFalse(blueButton.isSelected());

        //verify red is selected
        Assert.assertTrue(redButton.isSelected());


        driver.quit();

    }
}
