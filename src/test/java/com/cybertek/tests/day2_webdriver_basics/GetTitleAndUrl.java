package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com");

        //getting title with selenium
        //Option+Enter shortcut for variable introducing
        String title = driver.getTitle();
        //soutv+Enter to print variable
        System.out.println("title = " + title);

        //getCurrentUrl()--> gets the current Url of the page
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        //getPageSource()--> gets the source code of the page
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);
    }
}
