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

import java.util.ArrayList;
import java.util.List;

public class WebTablesPractice {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod(description = "Verify webURL")

    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("table1")));

    }

    @Test(description = "Print Table1 Data")
    public void test1() {
        WebElement table1 = driver.findElement(By.id("table1"));
        System.out.println(table1.getText());
    }

    @Test(description = "Count number of columns")
    public void test2() {
        int actualNumOfColumns = driver.findElements(By.xpath("//table[@id='table1']//th")).size();
        int expectedNumOfColumns = 6;

        Assert.assertEquals(actualNumOfColumns, expectedNumOfColumns, "Actual size is wrong");
    }

    @Test(description = "verify that no of rows is 5")
    public void test3() {
        int actualNumOfRows = driver.findElements(By.xpath("//table[@id='table1']//tr")).size();
        int expectedNumOfRows = 5;
        Assert.assertEquals(actualNumOfRows, expectedNumOfRows, "Actual number of rows is wrong");
    }

    @Test(description = "print all values from the second row excluding table header")

    public void test4() {


        List<WebElement> a = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr[2]/td"));
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i).getText());

        }

    }


    @Test
    public void test5() {
        int row = 3;
        int column = 3;

        WebElement cell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + row + "]/td[" + column + "]"));
        String expectedEmail = "jdoe@hotmail.com";
        String actualEmail = cell.getText();

        Assert.assertEquals(actualEmail, expectedEmail);

    }


    @Test(description = "Get all values from email column and verify that every value contains '@'")
    public void test6() {
        int a = 0;
        boolean result = true;

        List<WebElement> emails = driver.findElements(By.xpath("//table[@id='table1']/tbody//td[" + a + "]"));
        for (a = 0; a < emails.size(); a++) {
            System.out.println(emails.get(a).getText());
            Assert.assertTrue(emails.get(a).getText().contains("@"), "Email no " + a + " does not include '@' sign");
        }
    }

    @Test(description = "Verify that after clicking on last name, values will be sorted in alphabetical order")
    public void test7() throws InterruptedException {
        /*
        Step1. Click on last name
        Step2. Get all values from "last name" column
        Step3. Verify that column is sorted in alphabetical order
        */

        //if the result of word.compareTo(word2) is less than 0, sequence of words is correct
        //if result is 0, words are equal
        //if result is positive, sequence is opposite of alphabetical order

        WebElement lastname=driver.findElement(By.xpath("(//span[contains(text(), 'Last Name')])[1]"));
        Thread.sleep(3000);
        lastname.click();


        List<WebElement>lastnames=driver.findElements(By.xpath("//table[@id='table1']//tbody//td[1]"));


        for (int i = 0; i <lastnames.size()-1; i++) {
            System.out.println(lastnames.get(i).getText());
            String value= lastnames.get(i).getText();
            String followingValue=lastnames.get(i+1).getText();
            Assert.assertTrue(value.compareTo(followingValue)<0);

        }





    }


    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
