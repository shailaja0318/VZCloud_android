package com.verizon.appiumtests.localytics.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MusicFavoritesSelectAllPlayPlaylist extends BaseTestClass {

    @Test
    public void testMusicFavoritesSelectAllPlayPlaylist() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_playlists);
        musicView.addSongToFavorites();
        baseControlsHelper.clickOn("Favorites");
        listView.clickOnAllElementsInMusicList(vz_strings.MusicView.Favorites);
        baseControlsHelper.openContext(vz_strings.context_playSelected);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_mediaPlay);

        TestCase.assertEquals("Localytics of " + vz_strings.logs_tagEvent + " is not 1 in logs", 1, localyticsHelper.getCountOf(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaPlay));
        //here we can check for exists becuase checking for 1 wont work with when pre cond runs
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaType + " is not 1 in logs", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + "Song"));
    }
}

