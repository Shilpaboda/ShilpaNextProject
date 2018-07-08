package com.next.homefurniture;

import com.next.base.TestBase;
import com.next.util.TestUtil;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class TestSuiteBase extends TestBase{

    @BeforeSuite
    public void checksuiteSkip() throws IOException {
        initialize();
        if(!TestUtil.isSuiteRunnable(projectsuite, "homefurniture")){
            throw new SkipException("Runmode of the homefurniture suite is set as no, so skipping homefurniture suite");
        }

    }

}
