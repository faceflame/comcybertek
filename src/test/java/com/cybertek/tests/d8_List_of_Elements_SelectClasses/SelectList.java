package com.cybertek.tests.d8_List_of_Elements_SelectClasses;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SelectList {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement element = driver.findElement(By.id("state"));

        Select states = new Select(element);

        List<WebElement> options = states.getOptions();

        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());

        }


        String actualSelection = states.getFirstSelectedOption().getText();
        System.out.println("actualSelection = " + actualSelection);


        Assert.assertEquals(actualSelection, "Select a State");

        Thread.sleep(2000);


        states.selectByVisibleText("Ohio");
        actualSelection = states.getFirstSelectedOption().getText();

        Assert.assertEquals(actualSelection, "Ohio");



        states.selectByIndex(options.size()-1);

        actualSelection= states.getFirstSelectedOption().getText();


        Assert.assertEquals(actualSelection, "Wyoming");

        states.selectByValue("NC");

        actualSelection= states.getFirstSelectedOption().getText();

        Assert.assertEquals(actualSelection, "North Carolina");


        driver.quit();
    }
}
