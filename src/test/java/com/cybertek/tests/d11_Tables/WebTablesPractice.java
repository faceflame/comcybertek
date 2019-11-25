package com.cybertek.tests.d11_Tables;

import com.cybertek.utilities.WebDriverFactory;
import org.apache.http.impl.io.IdentityInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTablesPractice {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod(description = "Verify webURL")

    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        wait= new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("table1")));

    }

    @Test(description = "Print Table1 Data")
    public void test1() {
        WebElement table1=driver.findElement(By.id("table1"));
        System.out.println(table1.getText());
    }

    @Test(description = "Count number of columns")
    public void test2(){


         int actualSize=driver.findElements(By.xpath("//table[@id='table1']//th")).size();
         int expectedSize=6;

        Assert.assertEquals(actualSize, expectedSize, "Actual size is wrong");


    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
