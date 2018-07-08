package com.next.base;

import com.next.util.XLS_Reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    public static boolean isInitialized;
    public static String[] runmodes;
    public static  Properties OR, Config;
    public static  FileInputStream ip, cp;
    public static XLS_Reader projectsuite, nexthome, men, women, homefurniture;


    //to initalize the properites files and load excel files:
    public void initialize() throws IOException {
        if(!isInitialized){
            OR = new Properties();
            ip = new FileInputStream("/Users/shilpa/IdeaProjects/HybridFrameworkShilpaNext/src/com/next/config/OR.properties");
            OR.load(ip);

            Config = new Properties();
            cp = new FileInputStream("/Users/shilpa/IdeaProjects/HybridFrameworkShilpaNext/src/com/next/config/config.properties");
            Config.load(cp);

            projectsuite =  new XLS_Reader("/Users/shilpa/IdeaProjects/HybridFrameworkShilpaNext/src/com/next/testdata/projectsuite.xlsx");
            nexthome    =   new XLS_Reader("/Users/shilpa/IdeaProjects/HybridFrameworkShilpaNext/src/com/next/testdata/nexthome.xlsx");
            men         =   new XLS_Reader("/Users/shilpa/IdeaProjects/HybridFrameworkShilpaNext/src/com/next/testdata/men.xlsx");
            women       =   new XLS_Reader("/Users/shilpa/IdeaProjects/HybridFrameworkShilpaNext/src/com/next/testdata/women.xlsx");
            homefurniture = new XLS_Reader("/Users/shilpa/IdeaProjects/HybridFrameworkShilpaNext/src/com/next/testdata/homefurniture.xlsx");
        }
    }

}
