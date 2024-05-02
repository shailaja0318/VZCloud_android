//IV-724
package com.verizon.appiumtests.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MusicPlaylistsSelectModeContextMenu extends BaseTestClass {

    @Test
    public void testMusicPlaylistsSelectModeContextMenu() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_playlists);
        precondition.addNewPL();
        precondition.addSongFromWithinMusicPlaylist();
        baseControlsHelper.openContext(vz_strings.context_select);
        listView.selectFirstItem10();
        baseControlsHelper.openContext(null);

        TestCase.assertTrue("Options missing ", contextualMenu.verifyOptions(vz_strings.DataType.MUSIC,
                vz_strings.view_musicPlaylists, false));
    }

}
