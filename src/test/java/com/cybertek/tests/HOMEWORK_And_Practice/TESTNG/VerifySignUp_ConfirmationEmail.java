package com.cybertek.tests.HOMEWORK_And_Practice.TESTNG;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class VerifySignUp_ConfirmationEmail {

    private WebDriver driver;

    @BeforeMethod(description = "Setup the browder")
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");


    }

    @Test(description = "Verify successful signup", priority = 1)
    public void test1() {
        driver.get("https://www.tempmailaddress.com/");
        //copy and save email on the page as a String
        String email = driver.findElement(By.id("email")).getText();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        //click on signup button
        driver.findElement(By.cssSelector("[href$='sign_up']")).click();
        //put 'sehaj jarome' on name box
        driver.findElement(By.name("full_name")).sendKeys("Sehaj Jarome");
        //put in the input in String email
        driver.findElement(By.name("email")).sendKeys(email);
        //click on sign up button
        driver.findElement(By.name("wooden_spoon")).click();
        //store expected Signup Message
        String expectedSignupMessage = "Thank you for signing up. Click the button below to return to the home page.";
        //find actual signup message and store in a String
        String actualSignupMessage = driver.findElement(By.name("signup_message")).getText();

       Assert.assertEquals(actualSignupMessage, expectedSignupMessage, "The actual successful signup message does not match");
        //got back to the first page
        driver.navigate().back();
        driver.navigate().back();

        driver.findElement(By.cssSelector("tr>td.from")).click();
        //Expected sender of first message
        String expectedEMailSender = "do-not-reply@practice.cybertekschool.com";
        //find first message sent to this email by ..., and store its text
        String actualReceivedEmail =driver.findElement(By.id("odesilatel")).getText();

        Assert.assertEquals(actualReceivedEmail, expectedEMailSender, "Actual sender of the email is " + actualReceivedEmail);


    }

    @AfterMethod(description = "close browser")
    public void tearDown() {
        driver.quit();
    }
}