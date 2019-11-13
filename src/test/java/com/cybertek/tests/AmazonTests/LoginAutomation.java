package com.cybertek.tests.AmazonTests;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginAutomation {

    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("Chrome");
        driver.get("https://www.w3schools.com/howto/tryit.asp?filename=tryhow_css_login_form_modal");

        WebElement username= driver.findElement(By.name("uname"));
        username.sendKeys("falala");

        WebElement password = driver.findElement(By.name("psw"));
        password.sendKeys("adsa");




    }
}
