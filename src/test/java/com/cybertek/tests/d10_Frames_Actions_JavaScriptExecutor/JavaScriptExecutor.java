package com.cybertek.tests.d10_Frames_Actions_JavaScriptExecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutor {
private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
    }
    @Test
    public void test() throws InterruptedException {
    driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js= (JavascriptExecutor) driver;

        for (int i = 0; i <11 ; i++) {
            js.executeScript("window.scrollBy(0, 500)");
        }

        Thread.sleep(2000);
    }

    @Test(description = "Scrolling with JSexecutor")
    public void test2() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/large");
        WebElement link= driver.findElement(By.linkText("Cybertek School"));
        Thread.sleep(2000);
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", link);
        Thread.sleep(2000);
    }
    @Test
    public void test3() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        WebElement link1= driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        Thread.sleep(2000);
        js.executeScript("arguments[0].click()", link1);
        Thread.sleep(2000);
    }


    @Test(description = "Enter text w JS executor")
    public void test4() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement name= driver.findElement(By.name("full_name"));
        WebElement email=driver.findElement(By.name("email"));
        WebElement signupbutton=driver.findElement(By.name("wooden_spoon"));

        JavascriptExecutor js= (JavascriptExecutor) driver;

        js.executeScript("arguments[0].setAttribute('value', 'Ad Soyad')", name);
        Thread.sleep(2000);
        js.executeScript("arguments[0].setAttribute('value', 'AdSoyad@yhoj.kol')", email);
        Thread.sleep(2000);
        js.executeScript("arguments[0].click()", signupbutton);

    }
    @AfterMethod

    public void tearDown(){
        driver.quit();
    }
}
