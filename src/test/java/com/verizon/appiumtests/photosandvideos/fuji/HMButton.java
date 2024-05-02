//https://jira.synchronoss.net:8443/jira/browse/IV-2455
package com.verizon.appiumtests.photosandvideos.fuji;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class HMButton extends BaseTestClass {

    @Test
    public void testHMButton() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_printshop);
        baseControlsHelper.waitForDismiss(vz_strings.spinner);
        baseControlsHelper.clickOn(vz_strings.button_exit);
        baseControlsHelper.clickOn(vz_strings.button_yes);
        baseControlsHelper.waitForShow(vz_strings.navi_icon);
        homeScreenView.navigateTo(vz_strings.navi_home);
        TestCase.assertTrue("We not back to HM ", baseControlsHelper.isVisible(vz_strings.name_homeScreen));
    }
}
