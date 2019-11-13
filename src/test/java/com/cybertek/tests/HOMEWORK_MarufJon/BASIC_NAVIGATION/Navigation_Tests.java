package com.cybertek.tests.HOMEWORK_MarufJon.BASIC_NAVIGATION;

import com.cybertek.utilities.StringUtility;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;

import static com.cybertek.utilities.StringUtility.VerifyEquals;

public class Navigation_Tests {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String>browsers= new ArrayList<>(Arrays.asList("chrome", "firefox", "edge"));

        for (int i = 0; i <browsers.size() ; i++) {

        WebDriver driver = WebDriverFactory.getDriver(browsers.get(i));
        driver.manage().window().maximize();


        driver.get("https://google.com");
        String GoogleFirstTitle = driver.getTitle();
        driver.get("https://www.etsy.com/");
        String EtsyFirstTitle = driver.getTitle();
        driver.navigate().back();
        String GoogleSecondTitle = driver.getTitle();

        VerifyEquals(GoogleFirstTitle, GoogleSecondTitle);


        driver.navigate().forward();
        String EtsySecondTitle = driver.getTitle();
        VerifyEquals(EtsyFirstTitle, EtsySecondTitle);

        Thread.sleep(2000);

        driver.quit();
    }
    }
}
