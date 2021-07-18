package com.cybertek.tests.day13_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExample {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

    @Test
    public void printTable(){

        WebElement table  = driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println(table.getText());
        Assert.assertTrue(table.getText().contains("jsmith@gmail.com"));


    }

    @Test
    public void getAllHeaders(){
        // how many columns we have?
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());
        //print each column name by one by one
        for (WebElement header : headers) {
            System.out.println(header.getText());

        }

    }

    @Test
    public void printTableSize(){
        //how many columns
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());
        //how many rows we have with header
        List<WebElement> allRowsWithHeaders = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("allRowsWithHeaders.size() = " + allRowsWithHeaders.size());


        //how many rows we have with header
        List<WebElement> allRowsWithoutHeaders = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println("allRowsWithoutHeaders.size() = " + allRowsWithoutHeaders.size());

    }

    @Test
    public void getRow(){
        //print the first row information
        WebElement secondRow = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));
        System.out.println(secondRow.getText());

        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
//        System.out.println("allRowsWithoutHeaders.get(0).getText() = " + allRows.get(0).getText());

        //get all the rows dynamically
        //1.find the number of rows
        //2.iterate one by one
        for (int i = 1; i < allRows.size(); i++) {
            WebElement row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]"));
            System.out.println(row.getText());

        }
    }
    @Test
    public void getAllCellInOneRow(){

        List<WebElement> allCelsInOneRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[3]/td"));

        for (WebElement cell : allCelsInOneRow) {
            System.out.println(cell.getText());
        }
    }

    @Test
    public void getASingleCellByIndex(){
        WebElement singleCell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[4]/td[5]"));
        System.out.println(singleCell.getText());

    }

    @Test
    public void printAllCellsByIndex(){

        int rowNumber = getNumberOfRows();
        int colNumber = getNumberOfColumns();

        System.out.println("colNumber = " + colNumber);
        System.out.println("rowNumber = " + rowNumber);

        //iterate through each row on the table
        for (int i = 1; i <= rowNumber; i++) {
        //iterate through each cell for each row
            for (int j = 1; j <= colNumber; j++) {
                WebElement cell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]"));
                System.out.println("cell["+i+"]["+j+"] =" + cell.getText());


//                String cellXpath = "//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]";
//                System.out.println(cellXpath);
//                WebElement cell = driver.findElement(By.xpath(cellXpath));
//                System.out.println(cell.getText());

            }

        }
    }

    @Test
    public void getCellRelationToAnotherCellInSameRow(){

//        String firstName = "John";
//        WebElement emailCell = driver.findElement(By.xpath("//table[@id='table1']//td[.='"+ name + "']/../td[3]"));
//        String emailText = emailCell.getText();

        String firstName = "John";
        String xpath= "//table[@id='table1']//td[.='"+ firstName+"']/../td[3]";
        WebElement email = driver.findElement(By.xpath(xpath));
        System.out.println(email.getText());

    }




    private int getNumberOfColumns() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));

        return headers.size();
    }

    private int getNumberOfRows() {
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return allRows.size();
    }

}
