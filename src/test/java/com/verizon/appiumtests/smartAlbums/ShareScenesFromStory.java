//IV-137
package com.verizon.appiumtests.smartAlbums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class ShareScenesFromStory extends BaseTestClass {

    @Test
    public void testShareScenesFromStory() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        photosAndVideosView.openStory10();
        baseControlsHelper.waitForContent();
        baseControlsHelper.clickOn(vz_strings.context_menu);
        baseControlsHelper.clickOn(vz_strings.context_select);
        baseControlsHelper.waitForShowByXpath(vz_strings.name_photo_index);
        baseControlsHelper.clickOnElementByXpath(vz_strings.name_photo_index);
        baseControlsHelper.clickOn(vz_strings.context_menu);
        baseControlsHelper.clickOn(vz_strings.context_share);
        baseControlsHelper.clickOn(vz_strings.button_yesRemindMeNextTime);
        baseControlsHelper.waitForDismiss(vz_strings.toast_creatingSocialShareLink);
        baseControlsHelper.waitForShow("assetNotificationClose");

        TestCase.assertTrue("Message not seen",
                baseControlsHelper.getCountById("selectedItemsAccessibilityID") > 0);

    }
}
