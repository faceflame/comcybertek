package com.cybertek.tests.d3_webelement_class;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Verify confirmation message
 * open browser
 * go to http://practice.cybertekschool.com/forgot_password
 * enter any email
 * click on Retrieve password
 * verify that confirmation message says 'Your e-mail's been sent!'
 */

public class VerifyConfirmationMessage {
    public static void main(String[] args){
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement emailInput = driver.findElement(By.name("email"));

//sendKeys      ----> enters given text

        String expectedEmail = "admiral@email.com";

        emailInput.sendKeys(expectedEmail);

        //verify that email is displayed in the inout box
//.getAttribute("value") ----> get text from input box
        String actualEmail = emailInput.getAttribute("value");

        if (expectedEmail.equals(actualEmail)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("expectedEmail= " + expectedEmail);
            System.out.println("actualEmail= " + actualEmail);
        }
            // click on Retrieve password

            WebElement retrievePassword = driver.findElement(By.id("form_submit"));

            retrievePassword.click();

           // Thread.sleep(1000);

            //Verify that confirmation message says 'Your e-mail's been sent!'

            String expectedMessage = "'Your e-mail's been sent!'";

            WebElement messageElement = driver.findElement(By.name("confirmation_message"));

            String actualMessage = messageElement.getText();

            if (expectedMessage.equals(actualMessage)) {
                System.out.println("Pass");
            } else {
                System.out.println("Fail");
            }


            //driver.quit();


        }


    }
