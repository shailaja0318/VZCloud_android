package com.verizon.appiumtests.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class NamingUserCreatedPlaylistInvalid extends BaseTestClass {

    @Test
    public void testNamingUserCreatedPlaylist() throws Exception {


        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_playlists);
        baseControlsHelper.openContext(vz_strings.context_newPlaylist);
        baseControlsHelper.setValuetoTextFieldByName("NEW_.*&", vz_strings.alertTextField);
        baseControlsHelper.clickOn(vz_strings.context_addPlaylist);

        TestCase.assertTrue("Invalid character pop up not present ? ", baseControlsHelper.getCountById(vz_strings.playlistName_req) > 0);

    }
}