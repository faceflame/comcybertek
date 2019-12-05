package com.cybertek.tests.d7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxTest {

    @Test

    public void test2() {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

        System.out.println("Is checkbox1 selected " + checkbox1.isSelected());
        System.out.println("Is checkbox2 selected " + checkbox2.isSelected());


        //verify one is not selected
        Assert.assertFalse(checkbox1.isSelected());
        //verify two is selected
        Assert.assertTrue(checkbox2.isSelected());

        System.out.println("check box 1");
        checkbox1.click();

        System.out.println("check box 2");


        System.out.println("Is checkbox1 selected " + checkbox1.isSelected());
        System.out.println("Is checkbox2 selected " + checkbox2.isSelected());




        driver.quit();

    }
}
