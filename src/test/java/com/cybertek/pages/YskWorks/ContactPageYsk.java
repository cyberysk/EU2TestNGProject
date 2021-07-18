package com.cybertek.pages.YskWorks;

import com.cybertek.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ContactPageYsk extends BasePage {

    @FindBy(xpath = "//tbody//td[@data-column-label='First name']")
    public List<WebElement> customerNameList;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> allContacts;

    public List<WebElement> searchContactList (String name){
        List<WebElement> searchContactList = new ArrayList<>();

//        System.out.println("allContacts.size() = " + allContacts.size());
        for(int i=0; i<allContacts.size();i++) {
            if (customerNameList.get(i).getText().equals(name)) {
                searchContactList.add(allContacts.get(i));
            }
        }
        return searchContactList;
    }
}
