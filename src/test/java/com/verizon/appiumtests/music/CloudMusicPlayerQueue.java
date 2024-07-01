package com.verizon.appiumtests.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class CloudMusicPlayerQueue extends BaseTestClass {

    @Test
    public void testCloudMusicPlayerQueue() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_playlists);
        preConditionPl();
        Thread.sleep(2000);
        baseControlsHelper.clickOn(vz_strings.view_musicPlaylists);
        preCondition();
        baseControlsHelper.openContext(vz_strings.context_playPlaylist);
        Thread.sleep(3000);
        musicView.openPlaylist("Music Playlists");
        Thread.sleep(3000);
        TestCase.assertTrue("Song 1 is not being played ? ", baseControlsHelper.getCountByXpath(vz_strings.music_firstRow_playICON) >0);
        		
    }

    private void preConditionPl() throws Exception {

        System.out.println("--Start Preconditions Pl--");
        if (baseControlsHelper.getCountById(vz_strings.view_musicPlaylists) < 1) {
            musicView.newPl(vz_strings.view_musicPlaylists);
        }
        System.out.println("--End Preconditions Pl--");
    }

    private void preCondition() throws Exception {

        System.out.println("--Start Preconditions--");
        if (baseControlsHelper.getCountById(vz_strings.view_emptyPlaylist) != 0) {
            musicView.addSongToPlaylist();
        }
        System.out.println("--End Preconditions--");
    }

}