package com.cybertek.tests.VyTrackAutomation;

import com.cybertek.Pages.BasePage;
import com.cybertek.Pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

//By extension we can Before and After methods from TestBase class

//This class will be dedicated to Login only.
public class LoginTest extends BasePage {

    @Test(description = "Verify page title after login is 'Dashboard'")
    public void test1() throws InterruptedException {
        LoginPage loginPage=new LoginPage();
        loginPage.login("storemanager85", "UserUser123");

        WebDriverWait wait= new WebDriverWait(Driver.get(), 10);
        wait.until(ExpectedConditions.titleIs("Dashboard"));

        Assert.assertEquals(Driver.get().getTitle(), "Dashboard");

    }
    
    
}
