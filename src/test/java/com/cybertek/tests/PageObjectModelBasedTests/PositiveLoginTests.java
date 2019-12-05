package com.cybertek.tests.PageObjectModelBasedTests;

import com.cybertek.Pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTests extends TestBase {

    @Test
    public void test1(){
        LoginPage loginPage=new LoginPage();
        loginPage.userName.sendKeys("storemanager65");
        loginPage.password.sendKeys("UserUser123");
        loginPage.submit.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");
    }

    @Test
    public void loginAsStoreManager(){
        LoginPage loginPage=new LoginPage();
        loginPage.login("storemanager85", "UserUser123");

        Assert.assertEquals(driver.getTitle(), "Dashboard");
    }
}
