package com.verizon.appiumtests.smartAlbums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/* IV-146: Create Story: All Photos and Videos
 * https://jira.synchronoss.net:8443/jira/browse/IV-146
 * */

public class CreateStoryByPhotoAndVideo extends BaseTestClass {

    @Test
    public void testCreateStoryByPhotoAndVideo() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        gridView.tapItemsInSelectMode();
        baseControlsHelper.openContext(vz_strings.context_createStory);
        //baseControlsHelper.clickOn(vz_strings.button_gotIt);
        baseControlsHelper.waitForShow("Edit scenes");

        for (int i = 0; i < vz_strings.realPlayerSave.length; i++) {
            TestCase.assertTrue(vz_strings.realPlayerSave[i] + " is not found.", baseControlsHelper
                    .getCountByNameUntilElementDisplay(vz_strings.realPlayerSave[i]) != 0);
        }

    }
}

