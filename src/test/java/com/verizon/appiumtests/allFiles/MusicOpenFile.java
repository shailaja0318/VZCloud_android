//IV-64
package com.verizon.appiumtests.allFiles;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MusicOpenFile extends BaseTestClass {

    @Test
    public void testMusicOpenFile() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_allFiles);
        allFilesView.search(".mp3");
        listView.selectFirstItem10();
        baseControlsHelper.waitForShow("pauseButton");

        TestCase.assertTrue("Music is not playing", baseControlsHelper.getCountById("pauseButton") != 0);
        musicView.selectTab(vz_strings.tab_artists);
        musicView.selectTab(vz_strings.tab_songs);
        musicView.selectTab(vz_strings.tab_nowPlaying);
        TestCase.assertTrue("Music is not playing", baseControlsHelper.getCountById("pauseButton") != 0);

    }
}