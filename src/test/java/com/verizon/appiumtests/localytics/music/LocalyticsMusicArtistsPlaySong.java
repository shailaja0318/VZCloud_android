//VZNFT-23 - Step 4
package com.verizon.appiumtests.localytics.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsMusicArtistsPlaySong extends BaseTestClass {

    @Test
    public void testLocalyticsMusicArtistsPlaySong() throws Exception {

    	homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_artists);
        listView.selectFirstItem10();
        baseControlsHelper.waitForShow(vz_strings.tab_songs);
        baseControlsHelper.clickOn(vz_strings.tab_songs);
        listView.selectNumberOfItems(2);
        baseControlsHelper.openContext(vz_strings.context_playSelected);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_mediaType);
        localyticsHelper.print(logs, vz_strings.logs_tagScreen);

        TestCase.assertTrue(vz_strings.logs_mediaTypeSong + " is not 1 in logs",
                localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\" = " + vz_strings.logs_mediaTypeSong) == 1);

        TestCase.assertTrue(vz_strings.logs_musicArtistSongs + " is not 1 in logs",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_musicArtistSongs) == 1);
    }
}
