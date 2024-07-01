//IV-135
package com.verizon.appiumtests.smartAlbums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class ShareVideoSceneFromStory extends BaseTestClass {

    @Test
    public void testShareVideoSceneFromStory() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        photosAndVideosView.openStory10();
        baseControlsHelper.waitForContent();
        gridView.tapItemInSelectMode(vz_strings.DataType.VIDEO);
        baseControlsHelper.openContext(vz_strings.context_share);
        baseControlsHelper.clickOn(vz_strings.button_yesRemindMeNextTime);
        baseControlsHelper.waitForDismiss(vz_strings.toast_creatingSocialShareLink);
        //baseControlsHelper.waitForShow("Cancel");

        TestCase.assertTrue(baseControlsHelper.isVisible(vz_strings.share_ShareViaLink));
        TestCase.assertTrue(baseControlsHelper.isVisible(vz_strings.share_ShareTo));

    }

}
