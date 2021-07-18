package com.cybertek.tests.yskWorks;

import com.cybertek.pages.YskWorks.ContactPageYsk;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class VytrackRealTestCaseYsk extends TestBase {

    @Test
    public void tets1(){

        extentLogger = report.createTest("VytrackTestCase");

        new LoginPage().loginAsSalesManager();
        BrowserUtils.waitFor(3);
        new DashboardPage().navigateToModule("Customers", "Contacts");

        ContactPageYsk contactPage = new ContactPageYsk();
        contactPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(2);
        List<WebElement> searchResultList = contactPage.searchContactList("Mariam");

        for (WebElement webElement : searchResultList) {
            System.out.println("webElement.getText() = " + webElement.getText());
        }
//        String contact =contactPage.customerNameList.get(2).getText();
//        System.out.println("contact = " + contact);
    }



}
