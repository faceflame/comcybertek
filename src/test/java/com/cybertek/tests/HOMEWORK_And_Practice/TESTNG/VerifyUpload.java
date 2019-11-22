package com.cybertek.tests.HOMEWORK_And_Practice.TESTNG;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyUpload {

    @Test(description = "Verify sucessful upload")
    public void test(){

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        //click on file upload
        driver.findElement(By.linkText("File Upload")).click();
/*
        //click on upload button
        driver.findElement(By.id("file-upload")).click();
*/
        //select file by giving pathway in send keys

        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\mysah\\OneDrive\\Desktop\\Yollar.txt");
        driver.findElement(By.id("file-submit")).click();

        String actualSubject= driver.findElement(By.xpath("//div/h3")).getText();
        String expectedSubject= "File Uploaded!";

        Assert.assertEquals(actualSubject, expectedSubject, "Sucessful upload subject is wrong");


        driver.quit();



    }
}
