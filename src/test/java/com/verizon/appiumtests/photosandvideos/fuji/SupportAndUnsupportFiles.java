//https://jira.synchronoss.net:8443/jira/browse/IV-2465
package com.verizon.appiumtests.photosandvideos.fuji;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * Created by kram0003 on 23/01/18.
 */
public class SupportAndUnsupportFiles extends BaseTestClass {
    @Test
    public void supportAndUnSupport() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        baseControlsHelper.openContext(vz_strings.context_select);
        gridView.tapItems();
        photosAndVideosView.clickPrintsAndGift(vz_strings.context_printAndGifts, vz_strings.context_icon_printShop);
        baseControlsHelper.clickOn(vz_strings.button_continue);
        baseControlsHelper.waitForDismiss(vz_strings.spinner);
        baseControlsHelper.clickOnElementByXpath(vz_strings.button_exit_1);
        baseControlsHelper.clickOn(vz_strings.button_yes);
        baseControlsHelper.clickOn(vz_strings.button_cancel);
        TestCase.assertTrue("Photos and Videos screen missing ", baseControlsHelper.getCountByClassName("XCUIElementTypeCell") > 0);
    }
}
