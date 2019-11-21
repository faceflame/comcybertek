package com.cybertek.tests.HOMEWORK_And_Practice.DROPDOWN;

import com.cybertek.tests.d8_List_of_Elements_SelectClasses.DropdownListNotSelecttagTest;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SpiceJet {
    private WebDriver driver;

    @BeforeMethod
    public void setDriver() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.spicejet.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @Test(description = "Verify Successful Reservation", priority = 1)
    public void test1() throws InterruptedException {

        //finds the list of cities in the dropdown for departures and selects Bagdogra

        driver.findElement(By.xpath("//span[@id='ctl00_mainContent_ddl_originStation1_CTXTaction']")).click();
        driver.findElement(By.cssSelector("[text='Bagdogra (IXB)']")).click();

        //finds the list of cities in the dropdown for arrivals and selects Muscat
        driver.findElement(By.cssSelector("[id='ctl00_mainContent_ddl_destinationStation1_CTXTaction']")).click();
        driver.findElement(By.xpath("(//a[@text='Muscat (MCT)'])[1]")).click();

        //Intereaction w the calendar
        driver.findElement(By.cssSelector("[id='ctl00_mainContent_view_date1']")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/table[1]/tbody[1]/tr[4]/td[4]/a[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/table[1]/tbody[1]/tr[5]/td[6]/a[1]")).click();

        //Finds number of passengers button

        Thread.sleep(3000);
        driver.findElement(By.id("divpaxinfo")).click();

        //Selecct number of adults
        Select numberOfAdults = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
        numberOfAdults.selectByValue("4");
        Thread.sleep(2000);

        //Select number of children
        Select numOfKids= new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Child")));
        numOfKids.selectByValue("2");

        //Select number of infants
        Select numOfInfants= new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Infant")));
        numOfInfants.selectByValue("2");

        //finds available currencies to make payments & select USD
        Select currencyList = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
        currencyList.selectByValue("USD");

        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();


        Thread.sleep(3000);

        String ActualURL=driver.getCurrentUrl();
        String ExpectedURL="https://book.spicejet.com/Select.aspx";

        Assert.assertEquals(ActualURL, ExpectedURL);



    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
