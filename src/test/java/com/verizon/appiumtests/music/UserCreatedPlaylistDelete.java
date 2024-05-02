package com.verizon.appiumtests.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;

public class UserCreatedPlaylistDelete extends BaseTestClass {

    //going to rewrite this again
    public void testUserCreatedPlaylistDelete() throws Exception {


        String playlist_name = "Temp";

        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_playlists);
        musicView.newPl(playlist_name);
        musicView.selectTab(vz_strings.tab_playlists);
        baseControlsHelper.openContext(vz_strings.context_select);
        baseControlsHelper.clickOn(playlist_name);
        baseControlsHelper.openContext(vz_strings.context_delete);


        TestCase.assertTrue("Delete Playlist(s)? ", baseControlsHelper.getCountById("Delete Playlist(s)?") != 0);
        TestCase.assertTrue("Are you sure you want ... ", baseControlsHelper.getCountById("Are you sure you want to delete the selected playlist(s) from the cloud? You cannot undo this action.") != 0);
        baseControlsHelper.clickOn("No");
        TestCase.assertTrue("Playlist disappeared", baseControlsHelper.getCountById(playlist_name) != 0);
        baseControlsHelper.openContext(vz_strings.context_delete);
        baseControlsHelper.clickOn("Yes");
        baseControlsHelper.waitForDismiss(vz_strings.toast_deletePlaylist);
        TestCase.assertTrue("Playlist not deleted", baseControlsHelper.getCountById(playlist_name) == 0);
    }
}