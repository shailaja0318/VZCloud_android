//IV-697
package com.verizon.appiumtests.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;

public class MediaPlayerContextMenuNotFav extends BaseTestClass {

 //   @Test
    public void testMediaPlayerContextMenuNotFav() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_playlists);
        preConditionPl();
        baseControlsHelper.clickOn(vz_strings.view_musicPlaylists);
        preCondition();
        preConditionFav();
        baseControlsHelper.clickOn(vz_strings.view_musicFavorites);
        listView.selectFirstItem10();
        baseControlsHelper.openContext(null);
        TestCase.assertTrue("Options missing ", contextualMenu.verifyOptions(null,
                vz_strings.view_musicPlayer, true));

    }

    private void preCondition() throws Exception {

        System.out.println("--Start Preconditions--");
        if (baseControlsHelper.getCountById(vz_strings.view_emptyPlaylist) != 0) {
            musicView.addSongToPlaylist();
        }
        baseControlsHelper.tapOnBackButton();
        System.out.println("--End Preconditions--");
    }


    private void preConditionFav() throws Exception {

        System.out.println("--Start Preconditions Fav--");
        if (baseControlsHelper.getCountById(vz_strings.view_musicFavorites) < 1) {
            musicView.addSongToFavorites();
        }
        System.out.println("--End Preconditions Fav--");
    }

    private void preConditionPl() throws Exception {

        System.out.println("--Start Preconditions Pl--");
        if (baseControlsHelper.getCountById(vz_strings.view_musicPlaylists) < 1) {
            musicView.newPl(vz_strings.view_musicPlaylists);
        }
        System.out.println("--End Preconditions Pl--");
    }
}
