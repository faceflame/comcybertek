package com.cybertek.tests.HOMEWORK_And_Practice.ASSIGNMENT;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ClearTrip {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.cleartrip.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @Test
    public void test() throws InterruptedException {

        driver.findElement(By.id("RoundTrip")).click();
        WebElement sourceCity = driver.findElement(By.id("FromTag"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(sourceCity));

        sourceCity.sendKeys("New");
        Thread.sleep(3000);
        sourceCity.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(3000);
        sourceCity.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(3000);
        sourceCity.sendKeys(Keys.ENTER);
        WebElement destinationCity = driver.findElement(By.id("ToTag"));
        destinationCity.sendKeys("lon");


        for (int i = 0; i < 8; i++) {
            Thread.sleep(1500);
            destinationCity.sendKeys(Keys.ARROW_DOWN);
        }

        Thread.sleep(2000);

        destinationCity.sendKeys(Keys.ENTER);


        //Depart date
        driver.findElement(By.cssSelector("[title='Depart date']")).click();
        driver.findElement(By.cssSelector("[class$='ui-state-active ']")).click();

        //Return date

        driver.findElement(By.id("ReturnDate")).click();
        driver.findElement(By.cssSelector("[class$='ui-state-active ']")).click();

        Select adult = new Select(driver.findElement(By.id("Adults")));
        adult.selectByValue("4");

        Select children = new Select(driver.findElement(By.id("Childrens")));
        children.selectByValue("2");

        Select infants = new Select(driver.findElement(By.id("Infants")));
        infants.selectByValue("1");

        driver.findElement(By.id("SearchBtn")).click();

        String expectedTitle = driver.getTitle();
        String actualTitle = "Cleartrip | New York ⇄ London";

        Assert.assertEquals(actualTitle, expectedTitle, "Actual Title is wrong. You missed an input in booking your flight");

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
