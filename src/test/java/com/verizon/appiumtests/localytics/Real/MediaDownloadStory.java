/**
 * VZNFT-143 Scenario 1 - Step 3
 * */
package com.verizon.appiumtests.localytics.Real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MediaDownloadStory extends BaseTestClass {

    @Test
    public void MediaDownloadStory() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        gridView.tapFolderInSelectMode10("Story-0");
        baseControlsHelper.openContext(vz_strings.context_download);
        Thread.sleep(5000);

        if(baseControlsHelper.isVisible(vz_strings.progressbar)){
            baseControlsHelper.clickOn("dismiss notification icon");
            baseControlsHelper.clickOn(vz_strings.button_yes);
            baseControlsHelper.waitForDismiss(vz_strings.progressbar);
        }

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaOpen + " is not 1 in logs",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaDownload) == 1);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaTypePhotos + " is not 1 in logs",
                localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + vz_strings.logs_mediaTypeStory) == 1);
    }
}
