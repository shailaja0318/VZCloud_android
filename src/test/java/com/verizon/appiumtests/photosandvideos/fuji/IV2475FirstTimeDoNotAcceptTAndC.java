//https://jira.synchronoss.net:8443/jira/browse/VPCIOS-4273
package com.verizon.appiumtests.photosandvideos.fuji;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/*
 * IV-2475 Fuji Print: First-time user splash screen - Do not accept Terms and Conditions
 * */

public class IV2475FirstTimeDoNotAcceptTAndC extends BaseTestClass {

    //@Test
    public void testIV2475FirstTimeDoNotAcceptTAndC() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        baseControlsHelper.clickOn(vz_strings.button_cartIcon);
        if (baseControlsHelper.getCountById(vz_strings.button_ok) != 0)
            baseControlsHelper.clickOn(vz_strings.button_ok);
        baseControlsHelper.waitForDismiss(vz_strings.spinner);
        baseControlsHelper.clickOn(vz_strings.button_exit);
        baseControlsHelper.clickOn(vz_strings.button_yes);
        baseControlsHelper.clickOn(vz_strings.button_cartIcon);
        baseControlsHelper.waitForDismiss(vz_strings.spinner);
        TestCase.assertTrue("Prints & Gifts screen missing ", baseControlsHelper.isVisible(vz_strings.text_printsAndGifts));
    }
}

