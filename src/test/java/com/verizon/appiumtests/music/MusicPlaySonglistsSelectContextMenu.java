//IV-696
package com.verizon.appiumtests.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MusicPlaySonglistsSelectContextMenu extends BaseTestClass {

    @Test
    public void testMusicPlaySonglistsSelectContextMenu() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_playlists);
        precondition.addNewPL();
        precondition.addSongToEmptyPlaylist();
        precondition.addSongToFavoriteFromSongs();
        precondition.removeAllFavorites(vz_strings.DataType.MUSIC);
        musicView.openPlaylist(vz_strings.view_musicPlaylist);
        baseControlsHelper.openContext(vz_strings.context_select);
        listView.selectFirstItem10();
        baseControlsHelper.openContext(null);

        TestCase.assertTrue(baseControlsHelper.isVisible(vz_strings.context_share));
        TestCase.assertTrue(baseControlsHelper.isVisible(vz_strings.context_addToPlaylist));
        TestCase.assertTrue(baseControlsHelper.isVisible(vz_strings.context_delete));
        TestCase.assertTrue(baseControlsHelper.isVisible(vz_strings.context_info));
        TestCase.assertTrue(baseControlsHelper.isVisible(vz_strings.context_playSelected));
    }
}
