package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {

    public static void main(String[] args) throws InterruptedException {

        //setting my chromedriver for automation
        WebDriverManager.chromedriver().setup();
        //creating driver object for chrome
        WebDriver driver = new ChromeDriver();
        //navigate to google
        driver.get("https://www.google.com");

        //navigate to another website (with navigate method)
        driver.navigate().to("https://www.facebook.com");

        //wait 3 seconds here
        Thread.sleep(3000);

        //how to go back to google after we navigate to facebook
        //goes back to previous page
        driver.navigate().back();

        //how to go forward to facebook go back again
        driver.navigate().forward();

        //refresh the page
        driver.navigate().refresh();



    }

}
