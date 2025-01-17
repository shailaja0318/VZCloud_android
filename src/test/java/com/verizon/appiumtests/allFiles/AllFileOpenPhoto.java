//IV-65
package com.verizon.appiumtests.allFiles;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class AllFileOpenPhoto extends BaseTestClass {

    @Test
    public void testAllFileOpenPhoto() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_allFiles);
        baseControlsHelper.clickOnNameContains("Mobile");
        listView.selectFirstItem10();
        TestCase.assertTrue("ImageView is not open", baseControlsHelper.getCountByClassName("XCUIElementTypeScrollView") != 0);
    }
}