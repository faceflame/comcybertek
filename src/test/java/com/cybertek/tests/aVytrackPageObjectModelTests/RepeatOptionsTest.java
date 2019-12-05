package com.cybertek.tests.aVytrackPageObjectModelTests;

import com.cybertek.Pages.CalendarEventsPage;
import com.cybertek.Pages.CreateCalendarEventsPage;
import com.cybertek.Pages.DashboardPage;
import com.cybertek.Pages.LoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTest {

    /*
   VERIFY RADIO BUTTONS
Open browser
Login as driver
Go to Activities —> Calenday Events
Click on crate calendar events
Click on repeat
Verify that repeat every days is checked
Verify that repeat weekday is not checked
    */
    @Test
    public void repeatEveryRadioBtnTest() {
        LoginPage loginPage = new LoginPage();
        String userName = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        loginPage.login(userName, password);
        loginPage.submit.click();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        // this line is waiting until the page load completes.
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();
        //click on repeat
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        createCalendarEventsPage.repeat.click();

        //Verify that repeat every days is checked
        Assert.assertTrue(createCalendarEventsPage.days.isSelected(), "Repeat Every day(s) should be selected");
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(), "Weekdays should not be selected");
    }

    @Test
    public void repeatOptionsTest() {
        /*
        VERIFY REPEAP OPTIONS
Open browser
Login as driver
Go to Activities —> Calenday Events
Click on crate calendar events
Click on repeat
Verify that repeat options are Daily, Weekly, Monthly, Yearly (in this order)
         */
        LoginPage loginPage = new LoginPage();
        String userName = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        loginPage.login(userName, password);
        loginPage.submit.click();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        // this line is waiting until the page load completes.
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();
        //click on repeat
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        createCalendarEventsPage.repeat.click();
        //Verify that repeat options are Daily, Weekly, Monthly, Yearly (in this order)


        List<String> expectedList = Arrays.asList("Daily", "Weekly", "Monthly", "Yearly");
        List<WebElement> options = createCalendarEventsPage.repeatOptionsList().getOptions();
//       List<String> actualList = new ArrayList<>();
//        for (WebElement option : options) {
//            actualList.add(option.getText())
//        }
        //the following line substitues the previous lines.

        List<String> actualList = BrowserUtils.getElementsText(options);
        Assert.assertEquals(actualList, expectedList, "repeat - options did not match.");

    }
}
