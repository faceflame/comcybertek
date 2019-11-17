package com.cybertek.tests.HOMEWORK_MarufJon.BASIC_NAVIGATION;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class CybertekNumOfLinksTest {
@Test

    public void Test() throws InterruptedException {
    WebDriver driver= WebDriverFactory.getDriver("Chrome");
    driver.get("https://cybertekschool.com/");

    List<WebElement>links=driver.findElements(By.tagName("a"));

    Thread.sleep(5000);
    System.out.println(links.size());

    for (int i = 0; i <links.size() ; i++) {
        System.out.println(links.get(i).getText());

    }
    System.out.println("Number of links is: " + links.size());
    driver.quit();
}

}
