package com.cybertek.tests.aVytrackPageObjectModelTests;

import com.cybertek.Pages.DashboardPage;
import com.cybertek.Pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitlesTest extends TestBase {

    @Test
    public void verifySubTitleTest() {
        LoginPage loginPage = new LoginPage();
        //Login as a driver
        //Open browser
        //Login as driver
        //Verify that page subtitle is Quick Launchpad
        //Go to Activities —> Calendar Events
        //Verify that page subtitle is Calendar Events
        String userName = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        loginPage.login(userName, password);
        loginPage.submit.click();
        DashboardPage dashboardPage = new DashboardPage();
        String actual = dashboardPage.getPageSubTitle();
        Assert.assertEquals(actual, "Quick Launchpad");
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        actual = dashboardPage.getPageSubTitle();
        Assert.assertEquals(actual, "Calendar Events");
    }
}



