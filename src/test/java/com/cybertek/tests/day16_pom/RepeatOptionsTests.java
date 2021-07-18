package com.cybertek.tests.day16_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTests extends TestBase {

    /*
    VERIFY RADIO BUTTONS
    open browser
    Login as driver
    Go to Activities --> Calendar Events
    Click on create calendar events
    Click repeat
    Verify repeat everyday is checked
    Verify that repeat weekly is not checked
     */

    @Test
    public void test1(){

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        BrowserUtils.waitFor(3);
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEvent = new CreateCalendarEventsPage();

        createCalendarEvent.repeat.click();

        Assert.assertTrue(createCalendarEvent.days.isSelected(),"Verify DAYS is checked");
        Assert.assertFalse(createCalendarEvent.weekday.isSelected(),"Verify WEEKLY IS NOT checked");

    }
    @Test
    public void test2(){
        /*
    VERIFY REPEAT OPTIONS
    open browser
    Login as Driver
    Go to Activities --> Calendar Events
    Click on create calendar events
    Click repeat
    Verify that repeat options are Daily, Weekly, Monthly, Yearly (in this order)
     */
        new LoginPage().loginAsDriver();

        new DashboardPage().navigateToModule("Activities", "Calendar Events");
        BrowserUtils.waitFor(3);

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        BrowserUtils.waitFor(3);
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        BrowserUtils.waitFor(3);
        createCalendarEventsPage.repeat.click();

        Select repeatOptions = createCalendarEventsPage.repeatOptionsList();

        List <String> expectedList = Arrays.asList("Daily","Weekly","Monthly","Yearly");
        List<WebElement> actualOptions = repeatOptions.getOptions();
        //Jamals Way
        List<String> actualList = new ArrayList<>();

        for (WebElement option : actualOptions) {
            actualList.add(option.getText());
        }
       // getting List by ready method
        List <String> actualList2 = BrowserUtils.getElementsText(actualOptions);

        Assert.assertEquals(actualList,expectedList,"Verify Repeat Options List");
        Assert.assertEquals(actualList2,expectedList,"Verify Repeat Options List");


        //My Way

//        for (int i = 0; i < expectedList.size(); i++) {
//             String expectedOption = expectedList.get(i);
//             String actualOption = actualOptions.get(i).getText();
//             System.out.println("actualOption = " + actualOption);
//             System.out.println("expectedOption = " + expectedOption);
//             Assert.assertEquals(actualOption,expectedOption);
//
//        }


    }

}
