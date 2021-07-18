package com.cybertek.tests.day19_ddf;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ExcelUtil;
import org.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {

    @Test
    public void readExcelFile(){

        //create an object from excelUtil
        //it accepts two argument
        //Argument 1 : Location of the file (path)
        //Argument 2 : sheet that we want to open(sheetName)

        ExcelUtil qa3Short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx", "QA3-short");

        //how many rows in the sheet
        System.out.println("Row Count = " + qa3Short.rowCount());

        //how many column in the sheet
        System.out.println("Column Count = " + qa3Short.columnCount());

        //get all column names
        System.out.println("Column Names = " + qa3Short.getColumnsNames());

        //get all data in list of maps
        List<Map<String, String>> dataList = qa3Short.getDataList();

        for (Map<String, String> oneRow : dataList) {
            System.out.println(oneRow);
        }
//        //get specific value of maps
//        System.out.println(dataList.get(2).get("firstname"));

        //get all data in 2d array
        String[][] dataArray = qa3Short.getDataArray();

        //print 2d array
        System.out.println(Arrays.deepToString(dataArray));

        // get specific value getting from our map
        System.out.println(dataList.get(8).get("lastname"));




    }
}
