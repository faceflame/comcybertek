package com.cybertek.tests.d1_basic_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class OpenBrowserDemo {


    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://learn.cybertekschool.com/courses/208/assignments/1086");

        Thread.sleep(1000);


        driver.get("https://amazon.com");

        driver.navigate().back();

        driver.navigate().forward();

        driver.quit();




    }

}
