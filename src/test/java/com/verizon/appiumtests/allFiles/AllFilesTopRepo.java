package com.verizon.appiumtests.allFiles;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class AllFilesTopRepo extends BaseTestClass {

    @Test
    public void testAllFilesTopRepo() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_allFiles);

        TestCase.assertTrue("All Files not found", baseControlsHelper.getCountById(vz_strings.allFiles) > 0);
    }
}
