package com.cybertek.tests.d4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameLocatorTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/sign_up");

        driver.manage().window().maximize();

        WebElement full_name= driver.findElement(By.name("full_name"));

        full_name.click();

        full_name.sendKeys("Ahmet Guclu");

        WebElement email= driver.findElement(By.name("email"));

        email.click();

        email.sendKeys("alo@yahoo.com");


        WebElement submitButton=driver.findElement(By.name("wooden_spoon"));

        submitButton.click();


        Thread.sleep(1000);


        driver.quit();



    }
}
