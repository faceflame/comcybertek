package com.cybertek.tests.HOMEWORK_And_Practice.TESTNG;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class VerifyInvalidDateOfBirth {
    private WebDriver driver;

    @BeforeMethod(description = "Browser Setup")
    public void setUpBrowser() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();
        Thread.sleep(2000);
    }

    @Test(description = "Verify DOB_Not_Valid_Entry", priority = 2)
    public void test1() {
        String input = "wrong_dob";
        String expectedResult = "The date of birth is not valid";

        driver.findElement(By.name("birthday")).sendKeys(input);
        String actualResult = driver.findElement(By.cssSelector("[data-bv-result='INVALID']")).getText();

        Assert.assertEquals(actualResult, expectedResult, "wrong DOB message was CORRECT");

    }

    @Test(description = "Verify List of Programming Languages", priority = 3)

    public void test2() {
        List<WebElement> programs = driver.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println(programs.size());
        for (int i = 0; i < programs.size(); i++) {

            Assert.assertTrue(programs.get(i).isDisplayed());

        }

    }

    @Test(description = "Verify Invalid_Name_Entry")
    public void test3() {

        driver.findElement(By.name("firstname")).sendKeys("K");
        Assert.assertTrue(driver.findElement(By.xpath("(//small[@class='help-block'])[2]")).isDisplayed());
    }


    @Test(description = "Verify Invalid_LastName_Entry")
    public void test4() {
        String expectedResult = "“The last name must be more than 2 and less than\n" +
                "64 characters long";
        driver.findElement(By.name("lastname")).sendKeys("a");

        Assert.assertTrue(driver.findElement(By.xpath("(//small[@class='help-block'])[6]")).isDisplayed());
    }

    @Test(description = "Sucessful Login")
    public void test5() throws InterruptedException {

        Select department = new Select(driver.findElement(By.name("department")));
        Select jobTitle = new Select(driver.findElement(By.name("job_title")));

        driver.findElement(By.name("firstname")).sendKeys("Karun");
        Thread.sleep(1000);
        driver.findElement(By.name("lastname")).sendKeys("KadarZengin");
        Thread.sleep(1000);
        driver.findElement(By.name("username")).sendKeys("ItzWolfSune");
        Thread.sleep(1000);
        driver.findElement(By.name("email")).sendKeys("sakka@sukka.com");
        Thread.sleep(1000);
        driver.findElement(By.name("password")).sendKeys("passwordSahi");
        Thread.sleep(1000);
        driver.findElement(By.name("phone")).sendKeys("653-956-2351");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[name='gender'][value='male']")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("birthday")).sendKeys("12/08/1986");
        Thread.sleep(1000);
        department.selectByVisibleText("Department of Agriculture");
        Thread.sleep(1000);
        jobTitle.selectByVisibleText("Manager");
        Thread.sleep(1000);
        driver.findElement(By.id("inlineCheckbox3")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[class$='primary']")).click();
        Thread.sleep(1000);

        String actualSuccesfulLoginMessage = driver.findElement(By.cssSelector("[class='alert-heading']")).getText();
        String expectedSuccessfulLoginMessage = "You've successfully completed\n" +
                "registration!";

        Thread.sleep(1000);

        Assert.assertEquals(actualSuccesfulLoginMessage, expectedSuccessfulLoginMessage, "No successful registry");




    }


    @AfterMethod(description = "Close browser")
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();
    }
}
