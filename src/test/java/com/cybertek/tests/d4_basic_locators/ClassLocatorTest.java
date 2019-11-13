package com.cybertek.tests.d4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassLocatorTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement home = driver.findElement(By.className("nav-link"));

        home.click();

        String title = driver.getTitle();
        System.out.println(title);

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement title2 = driver.findElement(By.className("h3"));

        System.out.println(title2.getText());

        //This does not print anyhting out because there is a space in the class

        WebElement button1= driver.findElement(By.tagName("button"));

        button1.click();

        Thread.sleep(1000);
        driver.quit();
    }
}
