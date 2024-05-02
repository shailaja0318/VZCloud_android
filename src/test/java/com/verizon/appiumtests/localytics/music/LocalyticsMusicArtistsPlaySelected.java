//VZNFT-23 - Step 3
package com.verizon.appiumtests.localytics.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsMusicArtistsPlaySelected extends BaseTestClass {

    @Test
    public void testLocalyticsMusicArtistsAllPlaySelected() throws Exception {

    	homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_artists);
        listView.selectFirstItem10();
        listView.selectFirstItemInSelectMode10();
        baseControlsHelper.openContext(vz_strings.context_playSelected);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent);
        localyticsHelper.print(logs, vz_strings.logs_tagScreen);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaPlay + " is not 1 in logs",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaPlay) == 1);

        TestCase.assertTrue(vz_strings.logs_musicArtistAlbums + " is not 1 in logs",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_musicArtistAlbums) == 1);

        TestCase.assertTrue(vz_strings.logs_mediaTypeSong + " is not 1 in logs",
                localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\" = " + vz_strings.logs_mediaTypeSong) == 1);
    }
}