package com.verizon.appiumtests.localytics.Real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * Updated by leletsn 
 * VZNFT - 82 Step 3
 */

public class PVStoryClickRename extends BaseTestClass {

    @Test
    public void testPVStoryClickRename() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        photosAndVideosView.openStory10();
        baseControlsHelper.waitForShow(vz_strings.story_HeroImage);
        baseControlsHelper.openContext(vz_strings.context_renameStory);
        baseControlsHelper.setValuetoTextFieldByName("Renamed Story", vz_strings.alertTextField);
        baseControlsHelper.clickOn(vz_strings.button_ok);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_storyRename);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_storyRename + " is not 1 in logs",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_storyRename) == 1);
    }
}