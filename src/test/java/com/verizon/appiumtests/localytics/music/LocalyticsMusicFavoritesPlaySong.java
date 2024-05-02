/**
 * VZNFT-32 - Step 3
 * */
package com.verizon.appiumtests.localytics.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsMusicFavoritesPlaySong extends BaseTestClass {

    @Test
    public void testLocalyticsMusicFavoritesPlaySong() throws Exception {

    	homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_playlists);
        precondition.addSongToFavoriteFromSongs();
        baseControlsHelper.clickOn("Favorites");
        listView.selectFirstItem10();

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagScreen);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_tagScreen + " is not 1 in logs",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_musicNowPlaying) >=1);

    }
}
