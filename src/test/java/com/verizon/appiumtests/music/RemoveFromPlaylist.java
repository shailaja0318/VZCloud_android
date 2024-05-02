package com.verizon.appiumtests.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class RemoveFromPlaylist extends BaseTestClass {

    @Test
    public void testRemoveFromPlaylist() throws Exception {


        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_playlists);
        preConditionPl();
        baseControlsHelper.clickOn(vz_strings.view_musicPlaylists);
        preCondition();
        removeSongFromPlaylist(vz_strings.view_musicPlaylists);
        Thread.sleep(5000);
        TestCase.assertTrue("Remove song(s)? ", baseControlsHelper.getCountById(vz_strings.view_emptyPlaylist) > 0);
    }

    private void preCondition() throws Exception {

        System.out.println("--Start Preconditions--");
        if (baseControlsHelper.getCountById(vz_strings.view_emptyPlaylist) > 0) {
            musicView.addSongToPlaylist();
        }
        System.out.println("--End Preconditions--");
    }

    public void removeSongFromPlaylist(String playlistName) throws Exception {

        System.out.println("--Start Postconditions R--");
        if (baseControlsHelper.getCountById(vz_strings.view_emptyPlaylist) < 1) {
            listView.clickOnAllElementsInMusicList(vz_strings.MusicView.Any_Playlist);
            baseControlsHelper.openContext(vz_strings.context_removeFromPlaylist);
            baseControlsHelper.clickOn(vz_strings.button_yes);
        }
        System.out.println("--End Postconditions R--");

    }

    private void preConditionPl() throws Exception {


        System.out.println("--Start Preconditions Pl--");
        if (baseControlsHelper.getCountById(vz_strings.view_musicPlaylists) < 1) {
            musicView.newPl(vz_strings.view_musicPlaylists);
        }
        System.out.println("--End Preconditions Fav--");
    }
}
