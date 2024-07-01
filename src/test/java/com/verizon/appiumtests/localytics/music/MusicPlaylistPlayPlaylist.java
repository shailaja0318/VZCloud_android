package com.verizon.appiumtests.localytics.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MusicPlaylistPlayPlaylist extends BaseTestClass {

    @Test
    public void testMusicPlaylistPlayPlaylist() throws Exception {


        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_playlists);
        precondition.addNewPL();
        precondition.addSongToEmptyPlaylist();
        musicView.selectTab(vz_strings.tab_playlists);
        baseControlsHelper.clickOn(vz_strings.view_musicPlaylists);
        baseControlsHelper.openContext(vz_strings.context_playPlaylist);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_mediaPlay);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_musicPlaylists + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_musicPlaylists));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_musicPlaylists + " is not 1 in logs", 1, localyticsHelper.getCountOf(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_musicPlaylists));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_tagEvent + " is not 1 in logs", 1, localyticsHelper.getCountOf(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaPlay));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_mediaType + " is not 1 in logs", 1, localyticsHelper.getCountOf(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + "Song"));
    }

}
