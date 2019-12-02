package com.cybertek.tests.HOMEWORK_And_Practice.ALERTS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

public class a {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        ChromeDriver driver1= new ChromeDriver();
        driver.navigate( ).refresh( );
        driver.sendKeys("F5");
        driver.navigate( ).to(  driver.getCurrentUrl( )  );
        driver.get( driver.getCurrentUrl ( ) );

        String URL= "wwwwww";

        driver.navigate().get( URL);

        driver.navigate().refresh( );
        driver.navigate().to( URL );

        driver.submit( );
        driver.getTitle();
        driver

        OperaDriver driver3 = new OperaDriver();
        driver.navigate().to( URL );
    }
}
