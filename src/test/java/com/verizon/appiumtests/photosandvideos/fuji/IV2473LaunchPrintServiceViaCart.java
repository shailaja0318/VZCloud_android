//https://jira.synchronoss.net:8443/jira/browse/IV-2473
package com.verizon.appiumtests.photosandvideos.fuji;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/*
 * IV-2473 Launch Fuji Print Service via cart icon - no items in shopping cart.
 * */

public class IV2473LaunchPrintServiceViaCart extends BaseTestClass {

    @Test
    public void testIV2473LaunchPrintServiceViaCart() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        baseControlsHelper.clickOn(vz_strings.button_cartIcon);
        baseControlsHelper.waitForDismiss(vz_strings.spinner);
        if (baseControlsHelper.getCountById(vz_strings.text_printsAndGifts) != 0) {
            baseControlsHelper.clickOn(vz_strings.button_exit);
            baseControlsHelper.clickOn(vz_strings.button_yes);
            baseControlsHelper.waitForShow(vz_strings.tab_all);
            TestCase.assertTrue("Photos and Videos screen missing ", baseControlsHelper.isVisible(vz_strings.text_photosAndVideos));
        } else {
            TestCase.assertTrue("Cart screen not found", ("Cart").equals(baseControlsHelper.getTextByNameContains("Cart")));
        }
    }
}

