package com.verizon.appiumtests.localytics.Real;

/**
 * VZNFT-111 Step 2
*/

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MediaPlayPlayStoryAll extends BaseTestClass {

    @Test
    public void testMediaPlayPlayStoryAll() throws Exception {

        homeScreenView.fromHomeClickAt(vz_strings.home_photsAndVideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        gridView.tapItem(vz_strings.DataType.STORY);
        photosAndVideosView.playVideo();

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent);

        TestCase.assertEquals("Localytics of " + vz_strings.logs_mediaPlay + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaPlay));

        TestCase.assertEquals(vz_strings.logs_mediaType + " more than 2", 2, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\" = " + vz_strings.logs_mediaTypeStory));
    }
}
