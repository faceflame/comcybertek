package com.cybertek.tests.HOMEWORK_And_Practice.BASIC_NAVIGATION;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RadioButtonsTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUpBrowser() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Radio Buttons")).click();
    }

    @Test(description = "Verify that green button is not clickable")
    public void test1() {

        WebElement greenButton = driver.findElement(By.id("green"));
        Assert.assertFalse(greenButton.isEnabled());

    }

    @Test(description = "Verify that blue button is clicked")
    public void test2() {

        WebElement blueBut = driver.findElement(By.id("blue"));
        System.out.println("is blue button selected? " + blueBut.isSelected());
        Assert.assertTrue(blueBut.isSelected());

    }

    @Test(description = "Verify that red button is clicked")

    public void test3() {
        WebElement redBut = driver.findElement(By.id("red"));
        redBut.click();
        Assert.assertTrue(redBut.isSelected());
        System.out.println("is red button clicked? " + redBut.isSelected());

    }

    @Test(description = "Find all radio buttons  and click on them on them one by one if not already selected")

    public void test4() throws InterruptedException {
        List<WebElement> buttons = driver.findElements(By.cssSelector("[type='radio']"));
        System.out.println(buttons.size());

        for (int i = 0; i < buttons.size(); i++) {

            if(buttons.get(i).isEnabled() && !buttons.get(i).isSelected()) {

                buttons.get(i).click();
                System.out.println("Button clicked: " + buttons.get(i).getAttribute("id"));
              }
            else{
                System.out.println("Button was not clicked:" + buttons.get(i).getAttribute("id"));
            }

            Thread.sleep(1000);

        }
        Assert.assertTrue(buttons.get(buttons.size()-1).isSelected());

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
