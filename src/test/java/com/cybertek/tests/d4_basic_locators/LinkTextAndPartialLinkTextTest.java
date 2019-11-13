package com.cybertek.tests.d4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkTextAndPartialLinkTextTest {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        WebElement link = driver.findElement(By.linkText("Example 3: Element on page that is hidden and become visible after 5 seconds"));

        System.out.println(link.getText());

        WebElement cyberteklink= driver.findElement(By.linkText("Cybertek School"));

        System.out.println(cyberteklink.getText());

        WebElement link6= driver.findElement(By.partialLinkText("Example 5"));

        System.out.println(link6.getText());



        driver.quit();

    }
}
