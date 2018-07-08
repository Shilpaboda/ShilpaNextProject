package com.next.nexthome;

import com.next.util.TestUtil;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Registration extends TestSuiteBase{
    static int count=-1;
    @BeforeTest
    public void checkTestCaseSkip(){
        if(!TestUtil.isTestcaseRunnable(nexthome, "Registration")){
            throw new SkipException("Runmode of the Registration test case is set as no, so skipping Registration test cases");
        }
        runmodes= TestUtil.getTestDataRunmodes(nexthome,"Registration");
    }

    //Executing Test case:
    @Test(dataProvider = "getRegistrationData")
    public void registration(String title, String fname, String lname, String email, String pass, String dob, String contact, String housenumber, String postcode){
       count++;
       if(!runmodes[count].equalsIgnoreCase("Yes")){
           throw new SkipException("Runmode of the test data is set as no, so skipping row number: "+count);
       }
       //Executing test case:
       System.out.print("Executing test case with test data: ");
       System.out.println(title+" === "+fname+" === "+lname+" === "+email+" === "+pass+" === "+dob+" === "+contact+" === "+housenumber+" === "+postcode);


    }

    @DataProvider
    public Object[][] getRegistrationData(){
        return TestUtil.getTestData(nexthome, "Registration");
    }

}
