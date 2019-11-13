package com.cybertek.tests.VyTrackAutomation;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UnsuccessulLogin {
    public static void main(String[] args) throws InterruptedException {

        //Allows the user to pick browser of choice

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //navigates to the login page
        driver.get("https://qa2.vytrack.com/user/login");

        String username = "storemanager6";
        String password = "UserUser123";
        String expectedTitle = "Login";


        //finds the username box and stores it in an object
        WebElement element = driver.findElement(By.name("_username"));

        //types in the username as put in by the user

        element.sendKeys(username);

        //finds the password box and stores it as Webelement object
        WebElement element1 = driver.findElement(By.name("_password"));

        //types in password
        element1.sendKeys(password);

        Thread.sleep(2000);

        //finds the login button and clicks it
        WebElement element2 = driver.findElement(By.id("_submit"));
        element2.click();

        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Pass");
            String message = driver.findElement(By.xpath("/html/body/div/div/div/div/div/form/fieldset/div/div")).getText();
            System.out.println("The message displayed by the webpage is " + message );


        } else {
            System.out.println("Fail");
            System.out.println("Expected webpage title after unauthorized login attempt message was: " + expectedTitle);
            System.out.println("Actual webpage title after unauthorized login attempt message was displayed is: " + actualTitle);

        }


        driver.quit();
    }

}
