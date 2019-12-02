package com.cybertek.tests.HOMEWORK_And_Practice.VYTRACK;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class VytrackTestCasesI5_6 {


 WebDriver driver;
    String URL = "https://qa2.vytrack.com/";
    String username = "storemanager60";
    String password = "UserUser123";






    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password);
        driver.findElement(By.name("_submit")).click();




    }

    @Test(description = "Verify all checkboxes are selected")
    public void test5() throws InterruptedException {
        //Login
        Thread.sleep(3000);

        WebElement ActivitiesTab = driver.findElement(By.xpath("//a/span[contains(text(), 'Acti')]"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(ActivitiesTab));

        //Move to Activities Tab
        Actions actions = new Actions(driver);
        actions.moveToElement(ActivitiesTab).build().perform();
        Thread.sleep(3000);

        //Move to Calender Events
        WebElement calendarActTab = driver.findElement(By.xpath("//a/span[contains(text(), 'Calendar Events')]"));
        actions.moveToElement(calendarActTab).build().perform();
        calendarActTab.click();

        Thread.sleep(2000);
        //Click on checkbox for activities
        driver.findElement(By.xpath("//button/input[@type='checkbox']")).click();

        //find all checkboxes
        List<WebElement> checkboxes = driver.findElements(By.xpath("//td/input[@type='checkbox']"));

        Thread.sleep(3000);

        for (int i = 0; i < checkboxes.size(); i++) {
            Assert.assertTrue(checkboxes.get(i).isSelected());

        }
    }

    @Test(description = "Verify the contents of a table in the calander events")
    public void test6() throws InterruptedException {
        Thread.sleep(3000);

        WebElement ActivitiesTab = driver.findElement(By.xpath("//a/span[contains(text(), 'Acti')]"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(ActivitiesTab));

        //Move to Activities Tab
        Actions actions = new Actions(driver);
        actions.moveToElement(ActivitiesTab).build().perform();
        Thread.sleep(3000);

        //Move to Calender Events
        WebElement calendarActTab = driver.findElement(By.xpath("//a/span[contains(text(), 'Calendar Events')]"));
        actions.moveToElement(calendarActTab).build().perform();
        calendarActTab.click();

        Thread.sleep(2000);

        //find the first event checkbox and click on it
        WebElement firstCheckbox = driver.findElement(By.xpath("//tbody/tr[@class='grid-row row-click-action']"));
        firstCheckbox.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//Find the list of items on General Information, Verify they are displayed,
// Verify that they correspond to Expected Titles of Info.
        List<WebElement> actualGeneralInfoTitles = driver.findElements(By.xpath("//div[@class='control-group attribute-row']/label"));
        ArrayList<String> expectedGeneralInfoTitles = new ArrayList<>(Arrays.asList("Title", "Description", "Start", "End", "All-Day Event", "Organizer", "Call Via Hangout"));

//Verify the corresponding text of info provided into each Title
        List<WebElement>actualInputTexts=driver.findElements(By.xpath("//div[@class='controls']/div"));
        ArrayList<String>expectedInputTexts=new ArrayList<>(Arrays.asList("hohohoho", "N/A", "Oct 1, 2019, 6:00 PM", "Oct 1, 2019, 7:00 PM",
                           "No", driver.findElement(By.xpath("//div[@class='controls']/div/div/a")).getText(), "No"));


        for (int i = 0; i < actualGeneralInfoTitles.size(); i++) {
            Assert.assertTrue(actualGeneralInfoTitles.get(i).isDisplayed());
            Assert.assertFalse(!actualGeneralInfoTitles.get(i).getText().equalsIgnoreCase(expectedGeneralInfoTitles.get(i)));

            Assert.assertTrue(actualInputTexts.get(i).isDisplayed());
            Assert.assertFalse(!actualGeneralInfoTitles.get(i).getText().equalsIgnoreCase(expectedInputTexts.get(i)));


        }


    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
