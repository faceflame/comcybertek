package com.cybertek.tests.d8_List_of_Elements_SelectClasses;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownListNotSelecttagTest {

    @Test

    public void test(){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropdownlink =driver.findElement(By.id("dropdownMenuLink"));

        dropdownlink.click();

        List<WebElement>options= driver.findElements(By.className("dropdown-item"));
        System.out.println("options size is : " + options.size());


        for (int i = 0; i <options.size() ; i++) {

            System.out.println(options.get(i).getText());

        }

        driver.findElement(By.linkText("Yahoo")).click();

        driver.quit();
    }
}
