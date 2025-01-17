package com.verizon.appiumtests.localytics.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MusicArtistsAlbumsPlaySelected extends BaseTestClass {

    @Test
    public void testMusicArtistsAlbumsPlaySelected() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_artists);
        listView.selectFirstItem10();
        listView.clickOnAllElementsInMusicList(vz_strings.MusicView.Artist_albums);
        baseControlsHelper.openContext(vz_strings.context_playSelected);
        baseControlsHelper.waitForShow("pauseButton");

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagScreen);
        localyticsHelper.print(logs, vz_strings.logs_tagEvent);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaPlay + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_mediaPlay));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_tagEvent + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_mediaPlay));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaType + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_mediaTypeSong));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_tagScreen + " is not 1 in logs", localyticsHelper.getCountOf(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_musicNowPlaying) >= 1);
    }
}
