package com.cybertek.tests.d4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IdLocatorTest {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        driver.manage().window().maximize();

        //<button class="btn btn-primary" onclick="button1()">Button 1</button>
        //<button class="btn btn-primary" onclick="button3()" id="button_btnbtn">Button 3</button>

        WebElement element = driver.findElement(By.id("disappearing_button"));
        String txt = element.getText();

        element.click();


        String result = element.getText();


        System.out.println(txt);



        driver.quit();

    }
}
