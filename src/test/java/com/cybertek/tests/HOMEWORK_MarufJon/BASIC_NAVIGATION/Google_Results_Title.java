package com.cybertek.tests.HOMEWORK_MarufJon.BASIC_NAVIGATION;

import com.cybertek.utilities.StringUtility;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;

import static com.cybertek.utilities.StringUtility.VerifyEquals;

public class Google_Results_Title {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        ArrayList<String> wordsToSearch = new ArrayList<>(Arrays.asList("Java", "JUnit", "Selenium"));

        for (int i = 0; i <wordsToSearch.size() ; i++) {

        driver.get("https://www.google.com/");
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.sendKeys(wordsToSearch.get(i));

        Thread.sleep(2000);

        driver.findElement(By.id("lga")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("(//input[@class='gNO89b'])[2]")).click();

        String firstURL = driver.findElement(By.xpath("//a/div/cite")).getText();

        driver.findElement(By.xpath("//a/h3/span")).click();
        String secondURL = driver.getCurrentUrl();
        Thread.sleep(2000);
        VerifyEquals(firstURL, secondURL);

        driver.navigate().back();
        Thread.sleep(2000);

        }


        driver.quit();

    }
}
