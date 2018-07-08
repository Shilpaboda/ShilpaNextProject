package com.next.nexthome;


import com.next.util.TestUtil;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SelectLocation extends TestSuiteBase{
    static int count=-1;
    @BeforeTest
    public void checktestcase(){
        if(!TestUtil.isTestcaseRunnable(nexthome,"SelectLocation")){
            throw new SkipException("Runmode of the select Location test case is set as no,so skipping SelectLocation testcases");
            }
            runmodes=TestUtil.getTestDataRunmodes(nexthome,"SelectLocation");
        }

        @Test(dataProvider ="getSelectLocationData")
        public void selectLocation(String location)
        {
            count++;
         if(!runmodes[count].equalsIgnoreCase("yes")) {
             throw new SkipException("Runmode of the test data is set as no,so skipping row number:" + count);
         }
            System.out.println("Executing testcase with testdata: "+location);
         }
         @DataProvider
         public Object[][] getSelectLocationData(){
            return  TestUtil.getTestData(nexthome,"SelectLocation");
         }


}

