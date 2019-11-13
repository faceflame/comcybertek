package com.cybertek.tests.VyTrackAutomation;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class SuccessfulLogin {
    public static void main(String[] args) throws InterruptedException {
//AUTOMATION SCRIPT FOR POSITIVE TEST CASE:  "VERIFY AUTHORIZED USER CAN LOGIN"

        //Allows user to input which WebBrowser s/he prefers to execute the automated script on
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //To get the testing environment login page for VyTrack application
        driver.get("https://qa2.vytrack.com/user/login");

        //List of valid usernames
        ArrayList<String> Usernames = new ArrayList<>(Arrays.asList("user13", "user14", "user14", "storemanager59", "storemanager60", "salesmanager113", "salesmanager114", "salesmanager115"));

        //Valid password
        String Password = "UserUser123";


        //Expected Webpage Title after successful login
        String expectedTitle = "Dashboard";

        //Actual Webpage Ttitle after successful login

        String actualTitle="";

        for (int i = 0; i < Usernames.size(); i++) {
            WebElement loginInput = driver.findElement(By.name("_username"));
            loginInput.sendKeys(Usernames.get(i));


            WebElement passwordInput = driver.findElement(By.name("_password"));
            passwordInput.sendKeys(Password);


            WebElement loginButton = driver.findElement(By.id("_submit"));
            loginButton.click();

            Thread.sleep(2000);


             actualTitle = driver.getTitle();

            if (actualTitle.equals(expectedTitle)) {
                System.out.println("User-" + (i+1)+ " Pass");
            } else {
                System.out.println("User-" + (i+1)+ "Fail");
                System.out.println("Expected WebpageTitle: " + expectedTitle);
                System.out.println("Actual WebpageTitle: " + actualTitle);
            }

            Thread.sleep(5000);

            WebElement scrolDownButton = driver.findElement(By.className("fa-caret-down"));
            scrolDownButton.click();

            WebElement logoutButton = driver.findElement( By.xpath("html/body/div[2]/div[2]/header/div/div/ul/li[4]/ul/li[5]/a"));
            logoutButton.click();


        }

        driver.quit();
    }

}
