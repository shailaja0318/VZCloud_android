/**
 * VZNFT-79 P/V Story Detail - tagScreens for StoryDetail Step 2
 */
package com.verizon.appiumtests.localytics.Real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsPVStoriesDetailsHome extends BaseTestClass {

    @Test
    public void testLocalyticsPVStoriesDetailsHome() throws Exception {

        homeScreenView.clickOnStory(vz_strings.carousel_story);
        baseControlsHelper.waitForShow(vz_strings.tab_storiesSavedStories);
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_storyDetail);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_storyDetail + " is not 1 in logs",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_storyDetail) == 1);
    }
}
