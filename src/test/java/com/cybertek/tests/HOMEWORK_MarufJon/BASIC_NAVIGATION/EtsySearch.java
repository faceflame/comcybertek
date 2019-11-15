package com.cybertek.tests.HOMEWORK_MarufJon.BASIC_NAVIGATION;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class EtsySearch {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://login1.nextbasecrm.com/");


        Faker dummydata= new Faker();
        String name= dummydata.name().fullName();
        driver.findElement(By.name("USER_LOGIN")).sendKeys(name);


        String password= dummydata.name().name();
        driver.findElement(By.name("USER_PASSWORD")).sendKeys(password);

        driver.findElement(By.className("login-btn")).click();

        String actualErrorMessage=driver.findElement(By.className("errortext")).getText();
        String expectedErrorMessage="Incorrect login or password";


        if (actualErrorMessage.equals(expectedErrorMessage)){
            System.out.println("PASS");
        }
        else {
            System.out.println("FAIL");
        }


        driver.quit();


    }
}
