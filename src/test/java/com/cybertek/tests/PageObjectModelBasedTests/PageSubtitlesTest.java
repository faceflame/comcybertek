package com.cybertek.tests.PageObjectModelBasedTests;

import com.cybertek.Pages.DashboardPage;
import com.cybertek.Pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitlesTest extends TestBase {

    @Test
    public void verifySubtitleTest(){
        LoginPage loginPage= new LoginPage();
        String username= ConfigurationReader.get("driver_username");
        String password=ConfigurationReader.get("password");
        loginPage.login(username, password);

        DashboardPage dashboardPage= new DashboardPage();
        String actual=dashboardPage.getPageSubTitle();


        Assert.assertEquals(actual, "Quick Launchpad");

    }



}
