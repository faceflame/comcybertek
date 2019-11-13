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

        driver.get("https://www.google.com/");
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.sendKeys("Java");
        WebElement searchButton= driver.findElement(By.cssSelector("input[value='Google Search']"));
        searchButton.click();

        driver.navigate().back();

        driver.quit();

    }
}
