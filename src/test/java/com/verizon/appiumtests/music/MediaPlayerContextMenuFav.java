//IV-697
package com.verizon.appiumtests.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MediaPlayerContextMenuFav extends BaseTestClass {

    @Test
    public void testMediaPlayerContextMenuFav() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_playlists);
        precondition.addNewPL();
        precondition.addSongToEmptyPlaylist();
        precondition.addSongToFavoriteFromSongs();
        baseControlsHelper.clickOn(vz_strings.view_musicPlaylists);
        baseControlsHelper.waitForShow(vz_strings.context_menu);
        baseControlsHelper.openContext(vz_strings.context_select);
        listView.selectFirstItem10();
        baseControlsHelper.waitForShow(vz_strings.context_menu);
        baseControlsHelper.clickOn(vz_strings.context_menu);
        TestCase.assertTrue(baseControlsHelper.isVisible(vz_strings.context_share));
        TestCase.assertTrue(baseControlsHelper.isVisible(vz_strings.context_addToPlaylist));
        TestCase.assertTrue(baseControlsHelper.isVisible(vz_strings.context_delete));
        TestCase.assertTrue(baseControlsHelper.isVisible(vz_strings.context_info));
        TestCase.assertTrue(baseControlsHelper.isVisible(vz_strings.context_removeFromPlaylist));
        TestCase.assertTrue(baseControlsHelper.isVisible(vz_strings.context_removeFavorite));
        TestCase.assertTrue(baseControlsHelper.isVisible(vz_strings.context_playSelected));






    }
}
