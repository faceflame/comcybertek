package com.cybertek.tests.d9_TabSwitch_Frames_FileUploading_AlertsPopups;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class SwitchTabs {
    private WebDriver driver;

    @BeforeMethod(description = "Browser Setup")
    public void setUpBrowser() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();

    }

    @Test(description = "Verif that title is Practice")
    public void test1() throws InterruptedException {
        driver.findElement(By.linkText("New tab")).click();
        //After 3 seconds, another website  will be opened in the second tab.
        //Selenium does not switch automatically to the new window
        Thread.sleep(4000);
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Practice", "Title is not Practice");
    }

    @Test(description = "Verify that user successfully switched to new tab")
    public void test2() throws InterruptedException {
        driver.findElement(By.linkText("New tab")).click();
        //After 3 seconds, another website  will be opened in the second tab.
        //Selenium does not switch automatically to the new window

        //Records id of original window that we opened initially
        String oldWindow=driver.getWindowHandle();

        Thread.sleep(4000);
        //in selenium every windiw has an id. That id calls window handle
        //to read window handle we use method getWindowHandle()

        //after new window is opened, we can get list of all window ids.

        //Set is like a List but it does not contain duplicates. You cannot easily access anything. There is no get() method.
        //we have to loop through the set to get data from a Set

        Set<String> windowHandles=driver.getWindowHandles();

        for (String windowhandle:windowHandles) {
            //if it is the old OldWindow
            if(!windowhandle.equals(oldWindow)){
                //switch to the new Window
                driver.switchTo().window(windowhandle);
            }
        }

        String newWindow=driver.getWindowHandle();

        System.out.println(driver.getTitle());

        //come back to the original page
        //we can build a function that would jump between windows based on page title

        String pageTitle="Practice";

        for (String windowHandle: windowHandles) {
            driver.switchTo().window(windowHandle);

            if(driver.getTitle().equals(pageTitle)){
                break;
            }
        }

        System.out.println(driver.getTitle());

    }


    @AfterMethod(description = "Close browser")
    public void tearDown() {
        driver.quit();
    }


}