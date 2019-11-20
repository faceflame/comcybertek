package com.cybertek.tests.d9_Frames_Syncronization;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class WaitsPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

    @Test
    public void test1() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("[href='/dynamic_loading']")).click();
        driver.findElement(By.cssSelector("[href='/dynamic_loading/2']")).click();
        driver.findElement(By.xpath("//div[@id='start']/button")).click();

        String actualMessage = driver.findElement(By.xpath("//div[@id='finish']/h4")).getText();
        String expectedMessage = "Hello World!";

        Assert.assertEquals(actualMessage, expectedMessage, "Actual Message did not match");
        System.out.println(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText());

    }

    @Test
    public void test2() throws InterruptedException {

        driver.findElement(By.cssSelector("[href='/dynamic_loading']")).click();
        driver.findElement(By.partialLinkText("Example 1: ")).click();
        driver.findElement(By.xpath("//div[@id='start']/button")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement usernameInputBox = driver.findElement(By.id("username"));

        wait.until(ExpectedConditions.visibilityOf(usernameInputBox));
        usernameInputBox.sendKeys("tomsmith");

        WebElement passwordInputBox = driver.findElement(By.id("pwd"));
        wait.until(ExpectedConditions.visibilityOf(passwordInputBox));
        passwordInputBox.sendKeys("SuperSecretPassword");

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@type='submit']"))));
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String ActualTitle = driver.getTitle();
        String expectedTitle = "Practice";

        Assert.assertEquals(ActualTitle, expectedTitle, "Title is wrong");

    }

    @Test
    public void test3() throws InterruptedException {
        driver.findElement(By.cssSelector("[href='/dynamic_loading']")).click();
        driver.findElement(By.cssSelector("[href='/dynamic_loading/5']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement usernameBox = driver.findElement(By.id("username"));
        wait.until(ExpectedConditions.visibilityOf(usernameBox));
        usernameBox.sendKeys("tomsmith");

        WebElement passwordBox = driver.findElement(By.id("pwd"));
        wait.until(ExpectedConditions.visibilityOf(passwordBox));
        passwordBox.sendKeys("SuperSecretPassword");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//div/button")).click();
        String ActualoutputMessage = driver.findElement(By.cssSelector("[class='superheader']")).getText();
        String ExpectedOutputMessage = "Welcome to the Secure Area. When you are done click logout below.";

        Assert.assertEquals(ActualoutputMessage, ExpectedOutputMessage, "Message is wrong");


    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
