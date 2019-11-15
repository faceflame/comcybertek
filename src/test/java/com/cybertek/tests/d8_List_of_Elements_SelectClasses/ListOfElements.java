package com.cybertek.tests.d8_List_of_Elements_SelectClasses;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

    @Test
    public void Test(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        List<WebElement> buttons= driver.findElements(By.tagName("button"));

        System.out.println(buttons.size());

        Assert.assertEquals(buttons.size(), 6);

        for (int i = 0; i <buttons.size() ; i++) {
            System.out.println(buttons.get(i).getText());
        }


        driver.quit();
    }

    @Test
    public void Test2(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        List<WebElement> buttons= driver.findElements(By.tagName("button1"));

        System.out.println(buttons.size());


        Assert.assertEquals(buttons.size(), 1);
        driver.quit();

    }
}
