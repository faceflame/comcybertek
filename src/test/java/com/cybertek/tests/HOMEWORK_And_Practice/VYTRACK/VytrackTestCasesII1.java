package com.cybertek.tests.HOMEWORK_And_Practice.VYTRACK;

import com.cybertek.tests.HOMEWORK_And_Practice.ALERTS.Alerts;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VytrackTestCasesII1 {
    private WebDriver driver;
    String URL = "https://qa2.vytrack.com/";
    String username = "storemanager60";
    String password = "UserUser123";

    @BeforeMethod
    public void setDriver() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(URL);
        //Login
        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password);
        driver.findElement(By.name("_submit")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//a/span[@class='title title-level-1'])[5]"))));

    }

    @Test
    public void test1() throws InterruptedException {

        //Hover over Activities tab
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement ActivitiesTab = driver.findElement(By.xpath("//a/span[contains(text(), 'Acti')]"));
        wait.until(ExpectedConditions.elementToBeClickable(ActivitiesTab));

        //Move to Activities Tab
        Actions actions = new Actions(driver);
        actions.moveToElement(ActivitiesTab).build().perform();
        Thread.sleep(3000);

        //Move to Calender Events and click
        WebElement calendarActTab = driver.findElement(By.xpath("//a/span[contains(text(), 'Calendar Events')]"));
        actions.moveToElement(calendarActTab).build().perform();
        calendarActTab.click();

        //Wait until visibility of Options link.
        Thread.sleep(2000);

        //Hover over the second event where there are ...
        Actions actions1= new Actions(driver);
        actions1.moveToElement(driver.findElement(By.xpath("(//tr[@class='grid-row row-click-action']//a[@class='dropdown-toggle'])[2]"))).build().perform();

        //Find the pop up with edit, delete, etc options

        System.out.println(driver.switchTo().alert().getText());


        Thread.sleep(2000);
    }

        @AfterMethod
        public void teardown () {
            driver.quit();
        }
    }
