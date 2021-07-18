package com.cybertek.tests.day16_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

    @Test
    public void loginAsDriver(){

        LoginPage loginPage = new LoginPage();

//        loginPage.usernameInput.sendKeys(ConfigurationReader.get("driver_username"));
//        loginPage.passwordInput.sendKeys(ConfigurationReader.get("driver_password"));
//        loginPage.loginBtn.click();

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        loginPage.login(username,password);
        /*
        //we can also create method in loginPage and we can use that

        loginPage.loginAsDriver();
        */
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa3.vytrack.com/");

    }

    @Test
    public void loginAsStoreManager(){

        LoginPage loginpage = new LoginPage();

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        loginpage.login(username,password);

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa3.vytrack.com/");

    }

}
