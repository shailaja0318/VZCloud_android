/**
 * VZNFT-140 Step/Scenario 2
 * */
package com.verizon.appiumtests.localytics.Real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class RealTimesViewCarousel extends BaseTestClass{

    @Test
    public void testRealTimesViewCarousel() throws Exception {

        homeScreenView.clickOnStory(vz_strings.carousel_story);
        baseControlsHelper.waitForShow(vz_strings.button_smartAlbumPlay);
        baseControlsHelper.clickOn(vz_strings.button_smartAlbumPlay);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagScreen);

        TestCase.assertTrue(vz_strings.logs_mediaOpen + " is not 1 in logs",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_realtimeView) == 1);
    }
}
