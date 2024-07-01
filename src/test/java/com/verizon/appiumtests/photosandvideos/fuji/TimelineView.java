//TODO: TL Remove or Replace
//https://jira.synchronoss.net:8443/jira/browse/IV-2448
package com.verizon.appiumtests.photosandvideos.fuji;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;

public class TimelineView extends BaseTestClass {

    public void testTimelineView() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.openMonth10("Timeline");
        gridView.tapItemInSelectMode(vz_strings.DataType.PHOTO);
        photosAndVideosView.clickPrintsAndGift(vz_strings.context_printAndGifts, vz_strings.context_icon_printShop);
        baseControlsHelper.waitForDismiss(vz_strings.spinner);
        baseControlsHelper.clickOnElementByXpath(vz_strings.button_exit);
        baseControlsHelper.clickOn(vz_strings.button_yes);
        baseControlsHelper.tapOnBackButton();
        TestCase.assertTrue("Time line not present ?", baseControlsHelper.isVisible("Photos timeline"));
    }
}
