//IV-63
package com.verizon.appiumtests.allFiles;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class NavigateThrougLevels extends BaseTestClass {

    @Test
    public void testNavigateThrougLevels() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_allFiles);
        baseControlsHelper.clickOnNameContains("Mobile");
        listView.selectFirstItem10();
        baseControlsHelper.tapOnBackButton();
        baseControlsHelper.tapOnBackButton();

        TestCase.assertTrue("All Files not found", baseControlsHelper.getCountById(vz_strings.allFiles) > 0);
    }

}
