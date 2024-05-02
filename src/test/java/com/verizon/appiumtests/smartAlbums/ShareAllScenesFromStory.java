//IV-138
package com.verizon.appiumtests.smartAlbums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class ShareAllScenesFromStory extends BaseTestClass {

    @Test
    public void testSShareAllScenesFromStory() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        photosAndVideosView.openStory10();
        baseControlsHelper.waitForContent();
        gridView.clickAllElements();
        baseControlsHelper.openContext(vz_strings.context_share);
        baseControlsHelper.clickOn(vz_strings.button_yesRemindMeNextTime);
        baseControlsHelper.waitForDismiss(vz_strings.toast_creatingSocialShareLink);
        baseControlsHelper.waitForShow(vz_strings.share_ShareTo);

        TestCase.assertTrue("Share To is not seen", baseControlsHelper.getCountById(vz_strings.share_ShareTo) > 0);
        TestCase.assertTrue("Share via Link is not seen", baseControlsHelper.getCountById(vz_strings.share_ShareViaLink) > 0);


    }
}
