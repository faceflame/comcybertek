package com.cybertek.tests.d3_webelement_class;
/**
 * Verify URL not changed
 * open browser
 * go to http://practice.cybertekschool.com/forgot_password
 * click on Retrieve password
 * verify that url did not change
 */

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyURLNotChanged {
    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        //save expected URL

        String expectedUrl = driver.getCurrentUrl();

        //click on Retrieve password
//WebElement ---> class that represents elements from the webpage
        //FindElement()---> method used to find element on a page
        //returns a webelement

        WebElement retrievePassword =  driver.findElement(By.id("form_submit"));

        retrievePassword.click();

        //verify that Url did not change.

        String actualUrl =driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            System.out.println("PASS");

        }
        else{
            System.out.println("FAIL");

        }

    }
}
