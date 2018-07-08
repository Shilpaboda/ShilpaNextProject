package com.next.men;

import com.next.util.TestUtil;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CasualShirts extends TestSuiteBase{
    static int count=-1;

    @BeforeTest
    public void checktestcase(){

        if(!TestUtil.isTestcaseRunnable(men,"CasualShirts")){
            throw new SkipException("Runmode of the CasualShirts Testcase is set as no,so skipping CasualShirts testcases");
        }
        runmodes=TestUtil.getTestDataRunmodes(men,"CasualShirts");

    }

    @Test(dataProvider = "getCasualShirtsData")
    public void sidetables(String Products, String Category, String colour, String Size, String Fit,String Use,String DesignFeatures,String Benefit,String Brand,String Sleeve) {


        count++;

        if(!runmodes[count].equalsIgnoreCase("yes")){
            throw  new SkipException("Runmode of the testdata is set as no,so skipping row number:"+count);

        }
        System.out.println("Executing testcasewith testdata");
        System.out.println(Products+"==="+Category+"==="+colour+"==="+Size+"==="+Fit+"==="+Use+"==="+DesignFeatures+"==="+Benefit+"==="+Brand+"==="+Sleeve);
    }

    @DataProvider
    public Object[][] getCasualShirtsData(){
        return  TestUtil.getTestData(men,"CasualShirts");
    }
}



