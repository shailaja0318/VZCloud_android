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
        baseControlsHelper.openContext(null);
        TestCase.assertTrue("Options missing ", contextualMenu.verifyOptions(null,
                vz_strings.view_musicPlayerFav, false));

    }
}
