package com.cybertek.tests.HOMEWORK_And_Practice.BASIC_NAVIGATION;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ButtonsClickTest {
    @Test(description = "Click on buttons one by one")
    public void test() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        List<WebElement> buttons = driver.findElements(By.xpath("//button"));

        for (int i = 0; i < buttons.size(); i++) {
            System.out.println("Now clicking " + buttons.get(i).getText() );
            buttons.get(i).click();
            Thread.sleep(1000);
            WebElement message=driver.findElement(By.id("result"));
            System.out.println(message.getText());
        }
        Assert.assertEquals('C', "C");
driver.quit();
    }



}
