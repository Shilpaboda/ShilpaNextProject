package com.next.nexthome;

import com.next.util.TestUtil;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignIn extends TestSuiteBase{
    static int count=-1;
    @BeforeTest
    public  void checkTestCaseSkip(){
        if(!TestUtil.isTestcaseRunnable(nexthome, "SignIn")){
           throw new SkipException("Runmode of the SignIn test case is set as no , so skipping SignIn test cases");
        }
        runmodes = TestUtil.getTestDataRunmodes(nexthome,"SignIn");
    }

    //Execute Test case:
    @Test(dataProvider = "getSignInData")
    public void signin(String uname, String pass){
        count++;
        if(!runmodes[count].equalsIgnoreCase("yes")){
            throw new SkipException("Runmode of the test data is set as no, so skiping rownumber: "+count);
        }
        //Executing test case:
        System.out.println("Executing test cases with test data: "+uname+" === "+pass);
    }

    @DataProvider
    public Object[][] getSignInData(){
        return TestUtil.getTestData(nexthome, "SignIn");
    }



}
