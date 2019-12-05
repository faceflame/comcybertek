package com.cybertek.tests.d10_Frames_Actions_JavaScriptExecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Frames {
    private WebDriver driver;


    @BeforeMethod(description = "Browser setup")
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/frames");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'iFrame')]")).click();

        driver.switchTo().frame("mce_0_ifr");

        String actualText=driver.findElement(By.xpath("//body[@id='tinymce']/p ")).getText();
        String expectedText="Your content goes here.";



        Assert.assertEquals(actualText, expectedText, "Actual text is wrong");


        driver.findElement(By.xpath("//body[@id='tinymce']/p ")).clear();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//body[@id='tinymce']/p ")).sendKeys("oldu???");

        Thread.sleep(2000);


        actualText=driver.findElement(By.xpath("//body/p")).getText();
        expectedText="oldu???";

        Assert.assertEquals(actualText, expectedText);
        driver.switchTo().defaultContent();
    }

    @Test
    public void test2(){
        driver.findElement(By.linkText("Nested Frames")).click();

        driver.switchTo().frame("frame-top");


        driver.switchTo().frame("frame-middle");
        driver.findElement(By.id("content")).getText();

        String expectedEntry= "MIDDLE";
        String actualEntry=driver.findElement(By.id("content")).getText();

        Assert.assertEquals(expectedEntry, actualEntry);
        System.out.println(actualEntry);
    }


    @AfterMethod(description = "close browser")
    public void tearDown(){
        driver.quit();
    }
}
