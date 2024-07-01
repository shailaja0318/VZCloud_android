//https://jira.synchronoss.net:8443/jira/browse/IV-2447
package com.verizon.appiumtests.photosandvideos.fuji;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class WithinStorySelect extends BaseTestClass {

    @Test
    public void testWithinStorySelect() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        photosAndVideosView.openStory10();
        baseControlsHelper.waitForContent();
        gridView.tapItemInSelectModeByXpath(vz_strings.DataType.PHOTO);
        photosAndVideosView.clickPrintsAndGift(vz_strings.context_printAndGifts, vz_strings.context_icon_printShop);
        baseControlsHelper.waitForDismiss(vz_strings.spinner);
        baseControlsHelper.clickOnElementByXpath(vz_strings.button_exit_1);
        baseControlsHelper.clickOn(vz_strings.button_yes);
        baseControlsHelper.clickOn(vz_strings.button_cancel);
        baseControlsHelper.waitForShow(vz_strings.tab_storiesScenes);
        baseControlsHelper.tapOnBackButton();
        TestCase.assertTrue("Story not present ?", baseControlsHelper.isVisible("Photos stories"));

    }
}
