package com.verizon.appiumtests.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class CloudMusicPlayGenre extends BaseTestClass {

    @Test
    public void testCloudMusicPlayGenre() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_music);
        playMusicFromGenres();
        Thread.sleep(3000);
        musicView.selectTab(vz_strings.tab_playlists);
        baseControlsHelper.clickOn("On-The-Go");
        //when some song is playing it hides the number of song which i am asserting
        Thread.sleep(3000);
        TestCase.assertTrue("Atleast one song should be playing ", baseControlsHelper.getCountById("1") == 0);

    }

    public void playMusicFromGenres() throws Exception {

        musicView.selectTab(vz_strings.tab_genres);
        baseControlsHelper.clickOn("Unknown Genre");
        listView.selectFirstItem10();

    }
}
