package com.cybertek.tests.HOMEWORK_And_Practice.TESTNG;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class VerifySignUp_ConfirmationEmail {

    private WebDriver driver;

    @BeforeMethod(description = "Setup the browser")
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

    }

    @Test(description = "Verify successful signup", priority = 1)
    public void test1() throws InterruptedException {
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

        System.out.println(email);

        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().back();
        driver.navigate().back();
        Thread.sleep(1000);

        //Clicks on the first email sent to this address
        driver.findElement(By.id("schranka")).click();
        Thread.sleep(1000);


//Expected sender of first message
        String expectedEMailSender = "do-not-reply@practice.cybertekschool.com";
        String actualEmailSender = driver.findElement(By.id("odesilatel")).getText();

        //Verifies the email address of the sender of the first message
        Assert.assertEquals(actualEmailSender, expectedEMailSender, "Actual sender of the email is " + actualEmailSender);


    }

    @AfterMethod(description = "close browser")
    public void tearDown() {
        driver.quit();
    }
}