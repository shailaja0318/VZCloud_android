/**
 * VZNFT-30 - Step 1
 * */
package com.verizon.appiumtests.localytics.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsMusicGenres extends BaseTestClass{

        @Test
        public void testLocalyticsMusicGenres() throws Exception {

        	homeScreenView.navigateTo(vz_strings.navi_music);
            baseControlsHelper.scrollUtillAnElement(vz_strings.tab_genres, "left");
            baseControlsHelper.clickOn(vz_strings.tab_genres);

            String logs = localyticsHelper.getLogs();
            localyticsHelper.print(logs, vz_strings.logs_tagScreen);

            TestCase.assertEquals("Localytics of " + vz_strings.logs_tagScreen + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_musicGenres));
        }
}
