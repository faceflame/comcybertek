package com.cybertek.tests.d10_Frames_Actions_JavaScriptExecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsClass {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/hovers");
    }

    @Test(description = "Verify first image")
    public void test1() throws InterruptedException {

        //to create object of actions class(drag and drop, click, specific point, etc)
        Actions action = new Actions(driver);
        WebElement image1 = driver.findElement(By.xpath("(//div[@class='figure'])[1]"));
        WebElement image2 = driver.findElement(By.xpath("(//div[@class='figure'])[2]"));
        WebElement image3 = driver.findElement(By.xpath("(//div[@class='figure'])[3]"));
        //just to hover on image. Not click
        //do that action only once
        action.moveToElement(image1).perform();
        //to the sane task repetitively
        WebElement image1Element = driver.findElement(By.xpath("(//div/h5)[1]"));


        String Actualimage1ElementText = image1Element.getText();
        String Expectedimage1ElementText = "name: user1";
        System.out.println(image1Element);
        action.moveToElement(image1).build();

        Assert.assertEquals(Actualimage1ElementText, Expectedimage1ElementText, "Wrong Image1 text");

    }

    @Test
        public void test2() throws InterruptedException{
            Actions images = new Actions(driver);

            for (int i = 1; i < 4; i++) {

                images.moveToElement(driver.findElement(By.xpath("(//div[@class='figure'])[i]"))).perform();
                Thread.sleep(2000);
                String name = driver.findElement(By.xpath("(//div/h5)[1]")).getText();
                System.out.println(name);

            }

        }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
