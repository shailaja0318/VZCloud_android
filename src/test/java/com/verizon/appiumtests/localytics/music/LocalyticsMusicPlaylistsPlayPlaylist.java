/**
 * VZNFT-31 - Step 1
 * */
package com.verizon.appiumtests.localytics.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsMusicPlaylistsPlayPlaylist extends BaseTestClass {

        @Test
        public void testLocalyticsMusicPlaylistsPlayPlaylist() throws Exception {

            precondition.clickMusicHeadFromHome();
            musicView.selectTab(vz_strings.tab_playlists);
            //Check if PL is there if not create new one
            precondition.addNewPL();
            baseControlsHelper.clickOn(vz_strings.view_musicPlaylists);
            baseControlsHelper.openContext(vz_strings.context_playPlaylist);

            String logs = localyticsHelper.getLogs();
            localyticsHelper.print(logs, vz_strings.logs_tagScreen);

            TestCase.assertTrue("Localytics of " + vz_strings.logs_tagEvent + " is not 1 in logs",
                    localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaPlay) == 1);
            TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaType + " is not 1 in logs",
                    localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\" = " + vz_strings.logs_mediaTypeSong) == 1);
        }
}
