package com.cybertek.tests.d9_TabSwitch_Frames_FileUploading_AlertsPopups;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.security.mscapi.CPublicKey;

public class UploadFiles {
    private WebDriver driver;


    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");

    }

    @Test(description = "Verify Successful Upload")
    public void test1() throws InterruptedException {
        driver.findElement(By.linkText("File Upload")).click();
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\mysah\\OneDrive\\Desktop\\Photos\\image2.jpeg");
        driver.findElement(By.id("file-submit")).click();

        Thread.sleep(12000);

        String expectedFileName="image2.jpeg";
        String actualFileName= driver.findElement(By.id("uploaded-files")).getText();

        Assert.assertEquals(actualFileName, expectedFileName, "File not uploaded");

    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
