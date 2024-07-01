/**
 * VZNFT-31 - Step 3
 * */
package com.verizon.appiumtests.localytics.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsMusicPlaylistsPlayAll extends BaseTestClass{

        @Test
        public void testLocalyticsMusicGenresPlayAll() throws Exception {

            precondition.clickMusicHeadFromHome();
            musicView.selectTab(vz_strings.tab_playlists);
            //Check if PL is there if not create new one
            precondition.addNewPL();
            baseControlsHelper.clickOn(vz_strings.view_musicPlaylists);
            listView.clickOnAllElementsInMusicList(vz_strings.MusicView.Any_Playlist);
            baseControlsHelper.openContext(vz_strings.context_playSelected);

            String logs = localyticsHelper.getLogs();
            localyticsHelper.print(logs, vz_strings.logs_tagScreen);

            TestCase.assertEquals("Localytics of " + vz_strings.logs_tagEvent + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaPlay));
            TestCase.assertEquals("Localytics of " + vz_strings.logs_mediaType + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\" = " + vz_strings.logs_mediaTypeSong));
        }
}
