package com.verizon.appiumtests.fileInfo;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MusicInfo extends BaseTestClass {

    @Test
    public void testMusicInfo() throws Exception {


        homeScreenView.navigateTo(vz_strings.navi_music);

        playMusicFromAlbum();

        baseControlsHelper.openContext(vz_strings.context_info);

        TestCase.assertTrue("Name missing!", baseControlsHelper.getCountById("Name") != 0);
        TestCase.assertTrue("Artist missing!", baseControlsHelper.getCountById("Artist") != 0);
        TestCase.assertTrue("Album missing!", baseControlsHelper.getCountById("Album") != 0);
        TestCase.assertTrue("Genre missing!", baseControlsHelper.getCountById("Genre") != 0);
        TestCase.assertTrue("Year missing!", baseControlsHelper.getCountById("Year") != 0);
        TestCase.assertTrue("Size missing!", baseControlsHelper.getCountById("Size") != 0);
        TestCase.assertTrue("Extension missing!", baseControlsHelper.getCountById("Extension") != 0);
        TestCase.assertTrue("Date Uploaded missing!", baseControlsHelper.getCountById("Date Uploaded") != 0);
    }

    public void playMusicFromAlbum() throws Exception {

        musicView.selectTab(vz_strings.tab_albums);
        //click on album 
        listView.selectItem10("section - 0, row - 0");
        //click on song
        listView.selectItem10("section - 1, row - 0");
    }
}