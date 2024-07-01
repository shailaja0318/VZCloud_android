//https://jira.synchronoss.net:8443/jira/browse/VZNFT-73/step-11

package com.verizon.appiumtests.localytics.Real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * Created by kram0003 on 07/03/18.
 */
public class PhotosAndVideosStryRename extends BaseTestClass {
    @Test
    public void photosAndVideosStoryRename() throws Exception {
        homeScreenView.fromHomeClickAt(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        gridView.tapFolderInSelectMode10("Story-0");
        baseControlsHelper.openContext(vz_strings.context_renameStory);
        baseControlsHelper.setValuetoTextFieldByName("Renamed Story", vz_strings.alertTextField);
        baseControlsHelper.clickOn(vz_strings.button_ok);
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent);
        TestCase.assertEquals("Localytics of " + vz_strings.logs_photosVideosAll + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_storyRename));
    }
}
