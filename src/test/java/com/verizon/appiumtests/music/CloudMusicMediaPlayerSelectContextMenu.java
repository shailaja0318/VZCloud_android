package com.verizon.appiumtests.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class CloudMusicMediaPlayerSelectContextMenu extends BaseTestClass {

    @Test
    public void testCloudMusicMediaPlayer() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_albums);
        listView.selectItemInSelectMode10("MUSIC");
        baseControlsHelper.openContext(null);

        TestCase.assertTrue("Add to Playlist not present",
                baseControlsHelper.getCountById(vz_strings.context_addToPlaylist) > 0);
        System.out.println("Testing is complete");
    }
}
