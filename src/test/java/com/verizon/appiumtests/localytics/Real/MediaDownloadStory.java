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
        photosAndVideosView.openStory10();
        baseControlsHelper.waitForShow(vz_strings.story_HeroImage);
        baseControlsHelper.openContext(vz_strings.context_select);
        gridView.tapItems();
        baseControlsHelper.openContext(vz_strings.context_download);
        baseControlsHelper.waitForDismiss(vz_strings.progressbar);
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagScreen);
        localyticsHelper.print(logs, vz_strings.logs_tagEvent);

        //TestCase.assertEquals("Localytics of " + vz_strings.logs_mediaOpen + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaDownload));

        //TestCase.assertEquals("Localytics of " + vz_strings.logs_mediaTypePhotos + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + vz_strings.logs_mediaTypeStory));
    }
}
