package com.cybertek.tests.day16_pom;

import com.cybertek.pages.BasePage;
import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {

    /*
    Test case
    open browser
    login as a driver
    verify that page subtitle is quick launchpad
    go to activities -->calendar events
    verify that pages subtitle is calendar events
     */

    @Test
    public void test1(){

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();
        //For verify login successfully
        //same thing with Thread.sleep(3000)
        BrowserUtils.waitFor(3);

        DashboardPage dashboardPage = new DashboardPage();

        String expectedSubtitle = "Quick Launchpad";
        String actualSubtitle = dashboardPage.getPageSubTitle();

        Assert.assertEquals(actualSubtitle,expectedSubtitle,"Verify Subtitle");

        dashboardPage.navigateToModule("Activities", "Calendar Events");


        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        BrowserUtils.waitFor(3);
        expectedSubtitle = "Calendar Events";
        actualSubtitle = calendarEventsPage.getPageSubTitle();

        Assert.assertEquals(actualSubtitle,expectedSubtitle, "Verify Subtitle");

    }

}
