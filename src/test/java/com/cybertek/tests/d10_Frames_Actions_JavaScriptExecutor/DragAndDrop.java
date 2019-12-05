package com.cybertek.tests.d10_Frames_Actions_JavaScriptExecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DragAndDrop {

    @Test
    public void test() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");


        driver.findElement(By.xpath("//button[@title='Accept Cookies']")).click();

        Actions action=new Actions(driver);
        WebElement moon= driver.findElement(By.id("draggable"));
        WebElement earth=driver.findElement(By.id("droptarget"));

        Thread.sleep(2000);
        action.dragAndDrop(moon,earth).pause(200).build().perform();
        Thread.sleep(2000);

        Thread.sleep(2000);
        String actualMessage=driver.findElement(By.cssSelector("[id='droptarget']")).getText();
        String expectedMessage="You did great!";

        Assert.assertEquals(actualMessage, expectedMessage, "Drag and drop failed");

        driver.quit();
    }
}
