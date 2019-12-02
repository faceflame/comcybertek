package com.cybertek.tests.HOMEWORK_And_Practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ShoppingCartExample {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        List<WebElement> products = driver.findElements(By.xpath("//*[@class='product-name']"));
        String veggiesToPurchase [] = {"Cucumber", "Carrot", "Mango", "Beans"};
        List shoppingList = Arrays.asList( veggiesToPurchase);

        int count = 0;
        for (int i = 0; i < products.size(); i++) {

            String[] name = products.get(i).getText().split("-");
            String nameInput = name[0].trim();

            if (shoppingList.contains(nameInput)) {
                count++;
                driver.findElements(By.xpath("//a[@class='increment']")).get(i).click();
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
            }
            if (count == veggiesToPurchase.length) {
                break;
            }
        }
        driver.findElement(By.xpath("//a[@class='cart-icon']")).click();


        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

        List<WebElement> itemsInCart=driver.findElements(By.xpath("//table/tr/td/p[@class='product-name']"));

Thread.sleep(2000);

        for (int i = 0; i<itemsInCart.size(); i++) {

            String []names=itemsInCart.get(i).getText().split("-");
            String namesInCart=names[0].trim();

            if (shoppingList.equals(namesInCart)){

            }

        }


        }




    @AfterMethod
    public void teardown() {
        //driver.quit();
    }
}
