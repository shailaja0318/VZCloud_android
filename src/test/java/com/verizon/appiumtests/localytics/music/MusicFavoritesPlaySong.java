package com.verizon.appiumtests.localytics.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MusicFavoritesPlaySong extends BaseTestClass {

    @Test
    public void testMusicFavoritesPlaySong() throws Exception {


        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_playlists);
        musicView.addSongToFavorites();
        baseControlsHelper.clickOn("Favorites");
        listView.selectFirstItem10();

        String logs = localyticsHelper.getLogs();
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaPlay + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_mediaPlay));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaPlay + " is not 1 in logs", localyticsHelper.getCountOf(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaPlay) == 1);
        localyticsHelper.print(logs, vz_strings.logs_mediaPlay);
    }

}
