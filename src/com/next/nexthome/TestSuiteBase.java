package com.next.nexthome;

import com.next.base.TestBase;
import com.next.util.TestUtil;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import java.io.IOException;

public class TestSuiteBase extends TestBase{
    @BeforeSuite
    public void checkSuiteSkip() throws IOException {
        initialize();
        if(!TestUtil.isSuiteRunnable(projectsuite, "nexthome")){
            throw new SkipException("Runmode of the nexthome suite is set as no, so skipping nexthome suite");
        }
    }

}
