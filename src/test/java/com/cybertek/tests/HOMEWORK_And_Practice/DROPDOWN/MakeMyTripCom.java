package com.cybertek.tests.HOMEWORK_And_Practice.DROPDOWN;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MakeMyTripCom {
    private WebDriver driver;

    @BeforeMethod(description = "browser set up")

    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.makemytrip.com/");
        ;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test(description = "Verify successful reservation on makemytrip.com")
    public void test1() throws InterruptedException {

        //select round trip
        driver.findElement(By.xpath("//li[@data-cy='roundTrip']//span[@class='tabsCircle appendRight5']")).click();
        //go to From button, click,  clear  and send first three letters of the city

        driver.findElement(By.xpath("//input[@id='fromCity']")).click();
        Thread.sleep(1000);
        WebElement from = driver.findElement(By.xpath("//input[@placeholder='From']"));
        from.sendKeys("new");
        Thread.sleep(1000);
        from.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        from.sendKeys(Keys.ENTER);

        //hit enter to click on the first option that comes out


        Thread.sleep(1000);
        WebElement to = driver.findElement(By.xpath("//input[@placeholder='To']"));
        Thread.sleep(1000);
        to.sendKeys("Che");
        Thread.sleep(1000);
        to.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        to.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        to.sendKeys(Keys.ENTER);


        driver.findElement(By.xpath("//label[@for='departure']/span")).click();
        driver.findElement(By.cssSelector("[aria-label='Thu Nov 28 2019']")).click();

        driver.findElement(By.cssSelector("[for='return']")).click();


    }


    @AfterMethod(description = "close browser")

    public void teardown() {
        driver.quit();
    }

}
