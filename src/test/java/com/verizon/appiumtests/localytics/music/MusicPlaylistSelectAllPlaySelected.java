package com.verizon.appiumtests.localytics.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MusicPlaylistSelectAllPlaySelected extends BaseTestClass {

    @Test
    public void testMusicPlaylistSelectAllPlaySelected() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_playlists);
        precondition.addNewPL();
        precondition.addSongToEmptyPlaylist();
        musicView.openPlaylist(vz_strings.view_musicPlaylists);
        listView.clickOnAllElementsInMusicList(vz_strings.MusicView.Any_Playlist);
        baseControlsHelper.openContext(vz_strings.context_playSelected);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_musicPlaylists);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_musicPlaylists + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_musicPlaylists));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_musicPlaylists + " is not 1 in logs", localyticsHelper.getCountOf(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_musicPlaylists) == 1);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_tagEvent + " is not 1 in logs", localyticsHelper.getCountOf(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaPlay) == 1);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaType + " is not 1 in logs", localyticsHelper.getCountOf(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + "Song") == 1);
    }
}
