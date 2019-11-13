package com.cybertek.tests.d5_xpathLocators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathLocator {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement MultipleButtons= driver.findElement(By.xpath("//button[@onclick=\"button1()\"]"));
        MultipleButtons.click();

        WebElement element= driver.findElement(By.id("result"));
        String result =element.getText();
        System.out.println(result);

        WebElement button3= driver.findElement(By.xpath("//button[starts-with(@id, \"button_\")]"));
        button3.click();


        WebElement element2= driver.findElement(By.id("result"));
        String result2 =element.getText();
        System.out.println(result2);
        Thread.sleep(2000);


        driver.quit();
    }
}
