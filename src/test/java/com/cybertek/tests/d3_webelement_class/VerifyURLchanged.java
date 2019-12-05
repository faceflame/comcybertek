package com.cybertek.tests.d3_webelement_class;
/**
 Verify URL changed

 open browser
 go to http://practice.cybertekschool.com/forgot_password
 enter any email
 click on Retrieve password
 verify that url changed to http://practice.cybertekschool.com/email_sent

 */
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyURLchanged {
    public static void main(String[] args) {


        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement emailInput= driver.findElement(By.name("email"));

//sendKeys      ----> enters given text


        emailInput.sendKeys("alo@yolla.com");

        WebElement retrievePassword = driver.findElement(By.id("form_submit"));

        retrievePassword.click();

        String expected = "http://practice.cybertekschool.com/email_sent";
        String actual = driver.getCurrentUrl();


        if(actual.equals(expected)){
            System.out.println("PASS");
        }

        else {
            System.out.println("FAIL");
        }

        driver.quit();


    }

}
