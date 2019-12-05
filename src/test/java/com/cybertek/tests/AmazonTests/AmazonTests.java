package com.cybertek.tests.AmazonTests;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTests {
    public static void main(String[] args) {
//BookdetailsGit reset —hard orgigin master
        bookDetailsTest();
    }

    private static void bookDetailsTest() {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");

        WebElement search= driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("Selenium Cookbook");

        driver.findElement(By.className("nav-input")).click();

        driver.findElement(By.className("a-size-medium a-color-base a-text-normal")).click();


        WebElement Booktitle=driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal'][1]"));
        String actualFirstBookTitle=Booktitle.getText();
        String expectedFirstBookTitle= "Mastering Selenium WebDriver 3.0: Boost the performance and reliability of your automated checks by mastering";


        WebElement author= driver.findElement(By.xpath("//a[@class='a-size-base a-link-normal'][1]"));
        String actualAuthor=author.getText();
        String expectedAuthor= "Mark Collin";

        if (actualFirstBookTitle.equals(expectedFirstBookTitle)){
            System.out.println("PASS");
        }
        else {
            System.out.println("FAIL");
            System.out.println("Expected first book title was: " + expectedFirstBookTitle);
            System.out.println("Actual first book title is: " +actualFirstBookTitle);
            System.out.println("Expected first book author was: " + expectedAuthor);
            System.out.println("Actual first book author is: " + actualAuthor);
        }

        driver.quit();







    }

    private static void titleTest() {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");

        WebElement search= driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("Selenium Cookbook");

        driver.findElement(By.className("nav-input")).click();

        driver.findElement(By.linkText("Books")).click();

        String title= driver.getTitle();

        if(title.endsWith("Books")){
            System.out.println("PASS");
        }
        else {
            System.out.println("FAIL");
            System.out.println(title);
        }

        WebElement anyDepartment = driver.findElement(By.linkText("Any Department"));
        anyDepartment.click();
        String newTitle= driver.getTitle();



        if (!newTitle.endsWith("Books")){
            System.out.println("Pass");
        }
        else {
            System.out.println("Fail");
            System.out.println(newTitle);
        }

driver.quit();

    }
}
