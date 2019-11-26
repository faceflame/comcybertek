package com.cybertek.tests.HOMEWORK_And_Practice.VYTRACK;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.util.UriEncoder;
import sun.security.provider.DRBG;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class VytrackTestCases {
    private WebDriver driver;
    String URL = "https://qa2.vytrack.com/";
    String username = "storemanager85";
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

        //Move to Calender Events
        WebElement calendarActTab = driver.findElement(By.xpath("//a/span[contains(text(), 'Calendar Events')]"));
        actions.moveToElement(calendarActTab).build().perform();
        calendarActTab.click();

        //Wait until visibility of Options link.
        Thread.sleep(2000);
        WebElement optionsLink = driver.findElement(By.xpath("//div[@class='btn btn-link dropdown-toggle']"));
        wait.until(ExpectedConditions.visibilityOf(optionsLink));

//Assert if Options is displayed
        boolean optionsLinkDisplayed = optionsLink.isDisplayed();
        Assert.assertTrue(optionsLinkDisplayed);
    }

    @Test
    public void test2() throws InterruptedException {

//Hover over Activities Tab and move to it
        Actions actions = new Actions(driver);
        WebElement ActivitiesTab = driver.findElement(By.xpath("(//a/span[@class='title title-level-1'])[5]"));
        actions.moveToElement(ActivitiesTab).build().perform();
        //Hover over Calander Events and move to it
        WebElement CalanderEventsTab = driver.findElement(By.xpath("//span[contains(text(), 'Calendar Events')]"));
        actions.moveToElement(CalanderEventsTab).build().perform();
        //Find page number button get the value of it


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement pageNum = driver.findElement(By.xpath("//input[@class='input-widget']"));
        String ActualnumOfPage = pageNum.getAttribute("value");
        String ExpectednumOfPage = "1";

        Assert.assertEquals(ActualnumOfPage, ExpectednumOfPage);
    }

    @Test
    public void test3() throws InterruptedException {
        Actions actions = new Actions(driver);
        //Activiies tab
        WebElement ActivitiesTab = driver.findElement(By.xpath("(//a/span[@class='title title-level-1'])[5]"));
        actions.moveToElement(ActivitiesTab).build().perform();
        //Hover over Calander Events and move to it
        WebElement CalanderEventsTab = driver.findElement(By.xpath("//span[contains(text(), 'Calendar Event')]"));
        actions.moveToElement(CalanderEventsTab).build().perform();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement Nums = driver.findElement(By.cssSelector("[class='btn dropdown-toggle ']"));
        String actualNum = Nums.getText();
        String expectedNum = "25";

        Assert.assertEquals(actualNum, expectedNum);
    }

    @Test
    public void test4(){
        Actions actions = new Actions(driver);
        //Activiies tab
        WebElement ActivitiesTab = driver.findElement(By.xpath("(//a/span[@class='title title-level-1'])[5]"));
        actions.moveToElement(ActivitiesTab).build().perform();
        //Hover over Calander Events and move to it
        WebElement CalanderEventsTab = driver.findElement(By.xpath("//span[contains(text(), 'Calendar Event')]"));
        actions.moveToElement(CalanderEventsTab).build().perform();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List<WebElement>rows=driver.findElements(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr"));
        String RowsNum=  ""+rows.size();
        System.out.println(RowsNum);
        String RecordsNum=driver.findElement(By.xpath("//label[contains(text(), 'Tota')]")).getText();
        System.out.println(RecordsNum);

        Assert.assertTrue(RecordsNum.contains(RowsNum));


    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
