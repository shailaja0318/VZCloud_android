package com.verizon.appiumtests.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class CloudMusicPlayArtist extends BaseTestClass {

    @Test
    public void testCloudMusicPlayArtist() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_music);
        playMusicFromArtists();
      //  musicView.openPlaylist("On-The-Go");
        Thread.sleep(3000);
        int count = baseControlsHelper.getCountById("MUSIC: AlbumArtImage");
        System.out.println(count);
        TestCase.assertTrue("Number of song after adding up from songs", count != 0);

    }

    private void playMusicFromArtists() throws Exception {

        musicView.selectTab(vz_strings.tab_artists);
        //click on artist
        listView.selectFirstItem10();
        //click on album 
        listView.selectFirstItem10();
        //click on song
        baseControlsHelper.waitForShow("MUSIC: View - Album, CellClass - SongDetailCell, section - 1, row - 0");
        listView.selectItem10("MUSIC: View - Album, CellClass - SongDetailCell, section - 1, row - 0");
    }
}
