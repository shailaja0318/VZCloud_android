/**
 * VZNFT-31 - Step 2
 * */
package com.verizon.appiumtests.localytics.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsMusicFavoritesPlaySelected extends BaseTestClass{

        @Test
        public void testLocalyticsMusicPlaylistsPlaySelected() throws Exception {

        	homeScreenView.navigateTo(vz_strings.navi_music);
            musicView.selectTab(vz_strings.tab_playlists);
            precondition.addSongToFavoriteFromSongs();
            baseControlsHelper.clickOn("Favorites");
            listView.clickOnAllElementsInMusicList(vz_strings.MusicView.Favorites);
            baseControlsHelper.openContext(vz_strings.context_playSelected);
            String logs = localyticsHelper.getLogs();
            localyticsHelper.print(logs, vz_strings.logs_mediaPlay);

            TestCase.assertEquals(vz_strings.logs_tagEvent + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaPlay));
            TestCase.assertEquals(vz_strings.logs_mediaType + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\" = " + vz_strings.logs_mediaTypeSong));

        }
}
