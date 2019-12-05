package com.cybertek.tests.d9_TabSwitch_Frames_FileUploading_AlertsPopups;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Alerts {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

    @Test(description = "Click ok on pop up message", priority = 1)
    public void test1() throws InterruptedException {
        driver.findElement(By.xpath("//li/a[@href='/javascript_alerts']")).click();
        driver.findElement(By.cssSelector("[onclick='jsAlert()']")).click();
        Thread.sleep(1000);

        Alert alert = driver.switchTo().alert();

        //to click ok on the alert.
        Thread.sleep(1000);

        //to print the pop up message
        System.out.println(alert.getText());
        alert.accept();

    }

    @Test(description = "Click cancel on pop up message", priority = 2)
    public void test2() throws InterruptedException {
        driver.findElement(By.xpath("//li/a[@href='/javascript_alerts']")).click();
        driver.findElement(By.cssSelector("[onclick='jsConfirm()']")).click();
        Thread.sleep(1000);

        Alert alert = driver.switchTo().alert();

        //to print the pop up message
        System.out.println(alert.getText());

        //to click ok on the alert.
        Thread.sleep(1000);

        alert.dismiss();

        //to print text of the result
        System.out.println(driver.findElement(By.id("result")).getText());

    }

    @Test  (description = "Click on Button 3, enter some text and then click ok")
        public void test3() throws InterruptedException {
        driver.findElement(By.xpath("//li/a[@href='/javascript_alerts']")).click();
        driver.findElement(By.cssSelector("[onclick='jsPrompt()']")).click();
        Thread.sleep(1000);

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("I am ready for this");
        alert.accept();

        System.out.println(driver.findElement(By.id("result")).getText());
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
