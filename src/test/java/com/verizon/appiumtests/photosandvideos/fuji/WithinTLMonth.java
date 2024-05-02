//TODO: TL Remove or Replace
//https://jira.synchronoss.net:8443/jira/browse/IV-2450
package com.verizon.appiumtests.photosandvideos.fuji;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;

public class WithinTLMonth extends BaseTestClass {

    public void testWithinTLMoth() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_timeline);
        gridView.tapFolderInSelectMode10("Timeline");
        photosAndVideosView.clickPrintsAndGift(vz_strings.context_printAndGifts, vz_strings.context_icon_printShop);
        baseControlsHelper.waitForDismiss(vz_strings.spinner);
        baseControlsHelper.clickOn(vz_strings.button_exit);
        baseControlsHelper.clickOn(vz_strings.button_yes);
        baseControlsHelper.waitForShow(vz_strings.tab_timeline);
        TestCase.assertTrue("Time line not present ?", baseControlsHelper.isVisible("Photos timeline"));
    }
}
