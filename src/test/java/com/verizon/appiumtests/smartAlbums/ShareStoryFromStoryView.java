//IV-134
package com.verizon.appiumtests.smartAlbums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class ShareStoryFromStoryView extends BaseTestClass {

    @Test
    public void testShareStoryFromStoryView() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        gridView.tapFolderInSelectMode10("Story-0");
        baseControlsHelper.openContext(vz_strings.context_share);
        baseControlsHelper.clickOn(vz_strings.button_yesRemindMeNextTime);
        baseControlsHelper.waitForDismiss(vz_strings.toast_creatingSocialShareLink);
        baseControlsHelper.waitForShow("Cancel");

        TestCase.assertTrue(baseControlsHelper.getCountById("Cancel") > 0);

    }
}
