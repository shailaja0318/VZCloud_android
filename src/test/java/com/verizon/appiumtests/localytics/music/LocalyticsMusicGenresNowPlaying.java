/**
 * VZNFT-30 - Step 3
 * */
package com.verizon.appiumtests.localytics.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsMusicGenresNowPlaying extends BaseTestClass {

        @Test
        public void testLocalyticsMusicGenresNowPlaying() throws Exception {

        	homeScreenView.navigateTo(vz_strings.navi_music);
            musicView.selectTab(vz_strings.tab_genres);
            listView.selectFirstItem10();
            listView.selectFirstItem10();
            baseControlsHelper.waitForShow(vz_strings.tab_nowPlaying);

            String logs = localyticsHelper.getLogs();
            localyticsHelper.print(logs, vz_strings.logs_tagScreen);

            TestCase.assertEquals("Localytics of " + vz_strings.logs_tagScreen + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_musicGenres));
            TestCase.assertEquals("Localytics of " + vz_strings.logs_tagEvent + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaPlay));
            TestCase.assertEquals("Localytics of " + vz_strings.logs_mediaType + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\" = " + vz_strings.logs_mediaTypeSong));
        }
}
