package com.next.homefurniture;

import com.next.util.TestUtil;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SideTables extends TestSuiteBase {
    static int count=-1;

    @BeforeTest
    public void checktestcase(){

        if(!TestUtil.isTestcaseRunnable(homefurniture,"SideTables")){
            throw new SkipException("Runmode of the sidetables Testcase is set as no,so skipping sidetables testcases");
        }
        runmodes=TestUtil.getTestDataRunmodes(homefurniture,"SideTables");

    }

    @Test(dataProvider = "getSideTablesData")
    public void sidetables(String Products, String Category, String colour, String Brand, String Finishes,String Type,String Assembly) {


        count++;

        if(!runmodes[count].equalsIgnoreCase("yes")){
            throw  new SkipException("Runmode of the testdata is set as no,so skipping row number:"+count);

        }
        System.out.println("Executing testcasewith testdata");
        System.out.println(Products+ "==="+Category+"==="+colour+"==="+Brand+"==="+Finishes+"==="+Type+"==="+Assembly);
    }

    @DataProvider
    public Object[][] getSideTablesData(){
        return  TestUtil.getTestData(homefurniture,"SideTables");
    }
}

