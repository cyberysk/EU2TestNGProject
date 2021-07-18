package com.cybertek.tests.day16_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.pages.YskWorks.BasePageYsk;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class missionMyWay extends TestBase {

    @Test
    public void activities() throws InterruptedException {

        LoginPage loginPage = new LoginPage();



        loginPage.login(ConfigurationReader.get("driver_username"), ConfigurationReader.get("driver_password"));

        BasePageYsk dashboard = new BasePageYsk();

        dashboard.activities.click();
        dashboard.calendarEvents.click();

        BrowserUtils.waitForPresenceOfElement(By.xpath("//h1[@class='oro-subtitle']"),5);

        //Thread.sleep(3000);

        String expectedPage = "Calendar Events";
        String actualPage = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(actualPage, expectedPage);
    }


}
