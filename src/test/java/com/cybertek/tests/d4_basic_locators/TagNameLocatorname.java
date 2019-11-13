package com.cybertek.tests.d4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TagNameLocatorname {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullname = driver.findElement(By.tagName("input"));
        fullname.sendKeys("Yolanda Dolla");

        WebElement email = driver.findElement(By.name("input"));
        email.sendKeys("selami@hotmail.com");

        WebElement button = driver.findElement(By.tagName("button"));

        button.click();


        Thread.sleep(5000);
        driver.quit();


    }
}
