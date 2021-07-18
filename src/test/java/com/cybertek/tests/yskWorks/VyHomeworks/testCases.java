package com.cybertek.tests.yskWorks.VyHomeworks;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class testCases extends TestBase {

    @Test
    public void test1(){

        new LoginPage().loginAsStoremanager();

        new DashboardPage().navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        BrowserUtils.waitFor(5);

        String actualSubtitle = calendarEventsPage.subtitle.getText();
        String expectedSubtitle = "Options";

        Assert.assertEquals(actualSubtitle,expectedSubtitle, "Verify that susbtitle");

    }

    @Test
    public void test2(){
        new LoginPage().loginAsStoremanager();

        new DashboardPage().navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
      //  BrowserUtils.waitFor(5);

        WebElement counter = driver.findElement(By.cssSelector("input[type='number']"));
        String actualNumber = counter.getAttribute("value");
        //System.out.println("actualNumber = " + actualNumber);
        String expectedNumber = "1";

        Assert.assertEquals(actualNumber,expectedNumber, "Verify on Page 1");

    }
    @Test
    public void test3(){

        new LoginPage().loginAsStoremanager();
        new DashboardPage().navigateToModule("Activities", "Calendar Events");

        BrowserUtils.waitFor(3);
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        String actualNumber = calendarEventsPage.perNumberPage.getText();
        System.out.println("actualNumber = " + actualNumber);
        String expectedNumber = String.valueOf(calendarEventsPage.numberOfRowsWithOutHeader.size());
        System.out.println("expectedNumber = " + expectedNumber);

        Assert.assertEquals(actualNumber,expectedNumber, "Verify perPage shows 25 number");

    }

    @Test
    public void test4(){

        new LoginPage().loginAsStoremanager();
        new DashboardPage().navigateToModule("Activities", "Calendar Events");

        BrowserUtils.waitFor(3);
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        String totalPageStr = calendarEventsPage.totalPage.getText();
        //System.out.println("totalPage = " + totalPage);
        String[] pageStr = totalPageStr.split(" ");
        Integer totalPageNumber = Integer.parseInt(pageStr[1]);
        //System.out.println("totalPageNmr = " + totalPageNmr);
        
        String totalRecordStr = calendarEventsPage.totalRecords.getText();
        //System.out.println("totalRecordStr = " + totalRecordStr);
        String [] totalRec = totalRecordStr.split(" " );
        String expectedRecordsNumber = totalRec[2];
        System.out.println("expectedRecordsNumber = " + expectedRecordsNumber);

        Integer actualRecordNumber = 0;
        for (int i = 1; i <=totalPageNumber; i++) {
            actualRecordNumber = actualRecordNumber + calendarEventsPage.numberOfRowsWithOutHeader.size();
            calendarEventsPage.nextBtn.click();
            calendarEventsPage.waitUntilLoaderScreenDisappear();
        }

        //System.out.println(actualRecordNumber);

        Assert.assertEquals(actualRecordNumber,expectedRecordsNumber, "Verify Total Record Number");


    }

    @Test
    public void test5() {

        new LoginPage().loginAsStoremanager();
        new DashboardPage().navigateToModule("Activities", "Calendar Events");

        BrowserUtils.waitFor(3);
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        calendarEventsPage.checkBox.click();
        BrowserUtils.waitFor(3);

        int rowNumber = 0;
        for (int i = 0;i<calendarEventsPage.numberOfRowsWithOutHeader.size();i++){
            Assert.assertTrue(calendarEventsPage.checkBox.isSelected());
            rowNumber++;
        }
      //  System.out.println(rowNumber);

//        int numberOfRow = calendarEventsPage.numberOfRowsWithOutHeader.size();
//        int selectedRow = calendarEventsPage.selectedRowsNumber.size();
//        System.out.println("numberOfRow = " + numberOfRow);
//        System.out.println("selectedRow = " + selectedRow);
//        Assert.assertEquals(selectedRow,numberOfRow);


    }
}
