/**
 * VZNFT-140 Step/Scenario 3
 * */
package com.verizon.appiumtests.localytics.Real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class RealTimeViewHome extends BaseTestClass{

    @Test
    public void testRealTimeViewHome() throws Exception {

        homeScreenView.fromHomeClickAt(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        photosAndVideosView.openStory10();
        baseControlsHelper.waitForShow(vz_strings.story_HeroImage);
        baseControlsHelper.clickOn(vz_strings.button_smartAlbumPlay);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagScreen);

        TestCase.assertEquals(vz_strings.logs_mediaOpen + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_realtimeView));
    }
}
