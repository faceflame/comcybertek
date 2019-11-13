package com.cybertek.tests.d2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class GetURLandTitle {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.jetbrains.com/idea/download/");

        String title = driver.getTitle();

        System.out.println("title is" + title);

        String url = driver.getCurrentUrl();
        System.out.println("url = " + url);

        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);


    }
    //open chrome browser


}
