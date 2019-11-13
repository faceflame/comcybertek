package com.cybertek.tests.PracticesByVAsya;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class TestCase2 {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("http://practice-cybertekschool.herokuapp.com/");

        WebElement list= driver.findElement(By.xpath("/html/body/div/div[2]/div/ul/li"));


        System.out.println(list.getSize());

    }
}
