package com.verizon.appiumtests.localytics.Real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * * VZNFT - 82 Step 1
 */

public class PVStorySelectRename extends BaseTestClass {

    @Test
    public void testPVStorySelectRename() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        gridView.tapFolderInSelectMode10(vz_strings.name_story);
        baseControlsHelper.openContext(vz_strings.context_renameStory);
        baseControlsHelper.setValuetoTextFieldByName("Renamed Story", vz_strings.alertTextField);
        baseControlsHelper.clickOn(vz_strings.button_ok);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_storyRename);

        TestCase.assertEquals("Localytics of " + vz_strings.logs_storyRename + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_storyRename));
    }
}