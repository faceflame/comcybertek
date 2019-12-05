package com.cybertek.tests.PageObjectModelBasedTests;

import com.cybertek.Pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTests extends TestBase {

    @Test
    public void wrongPasswordTest(){

        LoginPage loginPage=new LoginPage();
        loginPage.userName.sendKeys("salesmanager101");
        loginPage.password.sendKeys("Useser123");
        loginPage.submit.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login");
        }

       @Test
    public void wrongUsernameTest(){

        LoginPage loginPage= new LoginPage();
        loginPage.userName.sendKeys("salesmanager6060");
        loginPage.password.sendKeys("UserUser123");
        loginPage.submit.click();

        Assert.assertEquals(driver.getTitle(), "Login");

       }

}
