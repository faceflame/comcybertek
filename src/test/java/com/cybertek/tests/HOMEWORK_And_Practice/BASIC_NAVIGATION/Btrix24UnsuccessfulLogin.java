package com.cybertek.tests.HOMEWORK_And_Practice.BASIC_NAVIGATION;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Btrix24UnsuccessfulLogin {
    @Test

    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://login1.nextbasecrm.com/");
/*        driver.findElement(By.cssSelector("[name='USER_LOGIN']")).sendKeys("adasdas@g.com");
        driver.findElement(By.xpath("(//input[@class='login-inp'])[2]")).sendKeys("asdsa");
        driver.findElement(By.id("USER_REMEMBER")).click();
        driver.findElement(By.cssSelector("[type='submit']")).click();


        String actualErrorMessage=driver.findElement(By.cssSelector("[class='errortext']")).getText();
        String expectedErrorMessage="Incorrect login or password";

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
*/
        ArrayList<String> usernames = new ArrayList<>(Arrays.asList("helpdesk9@cybertekschool.com", "helpdesk10@cybertekschool.com", "marketing9@cybertekschool.com", "marketing10@cybertekschool.com", "hr9@cybertekschool.com", "hr10@cybertekschool.com"));
        String password = "UserUser";
        String ExpectedURLTitle = "Portal";


        for (int i = 0; i < usernames.size(); i++) {


            driver.findElement(By.name("USER_LOGIN")).clear();
            Thread.sleep(1000);
            driver.findElement(By.name("USER_LOGIN")).sendKeys(usernames.get(i));
            Thread.sleep(1000);
            driver.findElement(By.name("USER_PASSWORD")).clear();
            driver.findElement(By.name("USER_PASSWORD")).sendKeys(password);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@class='login-btn']")).click();

            Thread.sleep(1000);
            String actualURLTitle = driver.getTitle();
            Thread.sleep(1000);

            Assert.assertEquals(actualURLTitle, ExpectedURLTitle);
            Thread.sleep(1000);
            driver.findElement(By.id("user-name")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("(//span[@class='menu-popup-item-text'])[5]")).click();

        }


        driver.quit();
    }
}
