package com.verizon.appiumtests.localytics.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MusicQueue extends BaseTestClass {

    @Test
    public void testMusicQueue() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_playlists);
        precondition.addNewPL();
        precondition.addSongToEmptyPlaylist();
        precondition.addSongToFavoriteFromSongs();
        baseControlsHelper.clickOn("Favorites");
        listView.clickOnAllElementsInMusicList(vz_strings.MusicView.Favorites);
        baseControlsHelper.openContext(vz_strings.context_playSelected);
        baseControlsHelper.openContext(vz_strings.context_showQueue);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_musicQueue);

        TestCase.assertEquals("Localytics of " + vz_strings.logs_tagEvent + " is not 1 in logs", 1, localyticsHelper.getCountOf(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_musicQueue));
    }
}
