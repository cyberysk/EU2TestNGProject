package com.cybertek.tests.day18_review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyContactInfoTest extends TestBase {

    @Test
    public void contactDetailsTest(){

        extentLogger = report.createTest("Verify Contact Info");

        extentLogger.info("username: " + ConfigurationReader.get("salesmanager_username"));
        extentLogger.info("password: " + ConfigurationReader.get("salesmanager_password"));
        new LoginPage().loginAsSalesManager();

        BrowserUtils.waitFor(2);
        extentLogger.info("Navigate to Customer --- Contacts");
        new DashboardPage().navigateToModule("Customers", "Contacts");

        ContactsPage contactsPage = new ContactsPage();
        contactsPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Click on mbrackstone9@example.com");
        contactsPage.getContactEmail("mbrackstone9@example.com").click();

        ContactInfoPage contactInfoPage = new ContactInfoPage();
        contactInfoPage.waitUntilLoaderScreenDisappear();

        String expected = "Mariam Brackstone";
        String actual = contactInfoPage.fullName.getText();

        extentLogger.info("Verify Fullname");
        Assert.assertEquals(actual,expected,"Verify fullname");

        expected = "mbrackstone9@example.com";
        actual = contactInfoPage.email.getText();

        extentLogger.info("Verify Email");
        Assert.assertEquals(actual,expected, "Verify email");

        expected = "+18982323434";
        actual = contactInfoPage.phone.getText();

        extentLogger.info("Verify Phone Number");
        Assert.assertEquals(actual,expected, "Verify Phone Number");

        extentLogger.pass("PASS : Contact Info Test");


    }


}
