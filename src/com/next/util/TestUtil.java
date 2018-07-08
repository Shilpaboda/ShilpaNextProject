package com.next.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 1. to get the runmode of the suite: isSuiteRunnable
 * 2. to get the runmode of the test case: isTestcaseRunnable
 * 3. get the test case runmodes: getTestdataRunmode
 * 4. get test data runmodes: getTestData
 * 5. read properties:
 */
public class TestUtil {
    public static void main(String[] args) throws IOException {
        //XLS_Reader xls = new XLS_Reader("/Users/shilpa/IdeaProjects/HybridFrameworkShilpaNext/src/com/next/testdata/nexthome.xlsx");
       // System.out.println(isSuiteRunnable(xls, "men"));
        //System.out.println(isTestcaseRunnable(xls, "SignIn"));
       // getTestDataRunmodes(xls, "SignIn");
        //getTestData(xls, "SignIn");

        Properties OR = new Properties();
        FileInputStream ip = new FileInputStream("/Users/shilpa/IdeaProjects/HybridFrameworkShilpaNext/src/com/next/config/OR.properties");
        OR.load(ip);
        System.out.println(OR.getProperty("selectflag"));
        System.out.println(OR.getProperty("selectcountry"));

        Properties Config = new Properties();
        FileInputStream cp = new FileInputStream("/Users/shilpa/IdeaProjects/HybridFrameworkShilpaNext/src/com/next/config/config.properties");
        Config.load(cp);
        System.out.println(Config.getProperty("baseurl"));
        System.out.println(Config.getProperty("browsertype"));

    }


    //get the runmode of the SUite:
    public static boolean isSuiteRunnable(XLS_Reader xls, String suiteName){
        boolean isExecutable=false;
        for (int i=2;i<=xls.getRowCount("Testsuites");i++){
          String suite = xls.getCellData("Testsuites","TSID",i);
          String runmode = xls.getCellData("Testsuites", "Runmode",i);
            System.out.println(suite+" ==== "+runmode);
            if (suite.equalsIgnoreCase(suiteName)){
               if(runmode.equalsIgnoreCase("Yes")){
                   isExecutable=true;
               }
            }
        }
        return isExecutable;
    }

    //to get the runmode of the test case:
    public static boolean isTestcaseRunnable(XLS_Reader xls, String testcaseName){
        boolean isExecutable=false;
        for(int i=2;i<=xls.getRowCount("Testcases");i++){
            String testcase = xls.getCellData("Testcases", "TCID",i);
            String runmode = xls.getCellData("Testcases", "Runmode",i);
            System.out.println(testcase+" ===== "+runmode);

            if(testcase.equalsIgnoreCase(testcaseName)){
                if(runmode.equalsIgnoreCase("Yes")){
                    isExecutable=true;
                }
            }
        }
        return isExecutable;
    }

    //to get the testdata runmodes:
    public static String[] getTestDataRunmodes(XLS_Reader xls, String sheetName){
        if(!xls.isSheetExist(sheetName)){
            System.out.println("Test data sheet not found");
        }
        int rows = xls.getRowCount(sheetName);
        String[] runmodes = new String[rows-1];
        for(int i=2;i<=rows;i++){
            runmodes[i-2] = xls.getCellData("Testcases", "Runmode", i);
            System.out.println(xls.getCellData("Testcases", "Runmode", i));
        }
        return runmodes;

    }


    //get testdata for test case from the excel file:
    public static Object[][] getTestData(XLS_Reader xls, String sheetName){
        if (!xls.isSheetExist(sheetName)){
            System.out.println("Test data sheet not found");
        }
        int rows = xls.getRowCount(sheetName);
        int cols = xls.getColumnCount(sheetName);

        Object[][] data = new String[rows-1][cols-1];
        for (int rowNum=2;rowNum<=rows;rowNum++){
            for (int colNum=0;colNum<=cols-2;colNum++){
                data[rowNum-2][colNum] = xls.getCellData(sheetName,colNum, rowNum);
                System.out.print(xls.getCellData(sheetName, colNum, rowNum)+" === ");
            }
            System.out.println();
        }
        return  data;
    }



}
