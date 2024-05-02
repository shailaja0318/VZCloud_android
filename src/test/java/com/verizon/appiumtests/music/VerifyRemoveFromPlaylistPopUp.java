package com.verizon.appiumtests.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class VerifyRemoveFromPlaylistPopUp extends BaseTestClass {

    @Test
    public void testVerifyRemoveFromPlaylistPopUp() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_playlists);
        precondition.addNewPL();
        precondition.addSongToEmptyPlaylist();
        musicView.openPlaylist(vz_strings.view_musicPlaylists);
        musicView.removeSongFromPlaylist();

        TestCase.assertTrue("Remove song(s)? ",
                baseControlsHelper.getCountById("Remove song(s)?") != 0);
        TestCase.assertTrue("Are you sure ... missing",
                baseControlsHelper.getCountById("Are you sure you want to remove the " +
                        "selected song(s) from the playlist?") != 0);

    }
}
