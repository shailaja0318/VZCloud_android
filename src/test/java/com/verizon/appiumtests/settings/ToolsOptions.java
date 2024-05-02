package com.verizon.appiumtests.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class ToolsOptions extends BaseTestClass {
    private final static Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    @Test(testName = "Tools Options",
            description = "Verify display of tools options ")
    public void testToolsOptions() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_settings);
        baseControlsHelper.clickOn(vz_strings.navi_tools);

        TestCase.assertTrue("Restore Not Found", baseControlsHelper.getCountById(vz_strings.tools_restore) != 0);
        TestCase.assertTrue("Sign in Not Found", baseControlsHelper.getCountById(vz_strings.tools_signIn) != 0);
        TestCase.assertTrue("Merge Not Found", baseControlsHelper.getCountById(vz_strings.tools_merge) != 0);
    }
}
