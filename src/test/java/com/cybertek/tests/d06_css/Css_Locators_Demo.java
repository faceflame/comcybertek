package com.cybertek.tests.d06_css;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Css_Locators_Demo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");


        WebElement dissappearingButon = driver.findElement(By.cssSelector("#disappearing_button"));

        System.out.println(dissappearingButon.getText());


        WebElement homeButton = driver.findElement(By.cssSelector(".nav-link"));

        System.out.println(homeButton.getText());

        WebElement button6 = driver.findElement(By.cssSelector("[onclick=\"button2()\"]"));
        button6.click();

        WebElement home= driver.findElement(By.linkText("Home"));

        home.click();
        System.out.println(driver.findElement(By.linkText("Home")).getText());

        Thread.sleep(2000);


        driver.quit();


    }
}
