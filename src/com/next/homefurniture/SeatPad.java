package com.next.homefurniture;

import com.next.util.TestUtil;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SeatPad extends TestSuiteBase{
    static int count=-1;

    @BeforeTest
    public void checktestcase(){

    if(!TestUtil.isTestcaseRunnable(homefurniture,"SeatPad")){
        throw new SkipException("Runmode of the seatpad Testcase is set as no,so skipping seatpadtestcases");
    }
    runmodes=TestUtil.getTestDataRunmodes(homefurniture,"SeatPad");
}

    @Test(dataProvider = "getSeatPadData")
    public void seatpad(String Products, String Category, String colour, String Type, String Design) {


        count++;

        if(!runmodes[count].equalsIgnoreCase("yes")){
            throw  new SkipException("Runmode of the testdata is set as no,so skipping row number:"+count);

        }
        System.out.println("Executing testcase with testdata");
        System.out.println(Products+ "==="+Category+"==="+colour+"==="+Type+"==="+Design);
}


        @DataProvider
        public Object[][] getSeatPadData(){
            return  TestUtil.getTestData(homefurniture,"Seatpad");
        }




        }

