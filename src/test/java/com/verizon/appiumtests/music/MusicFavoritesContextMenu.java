//IV-714
package com.verizon.appiumtests.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MusicFavoritesContextMenu extends BaseTestClass {

    @Test
    public void testMusicFavoritesContextMenu() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_playlists);
        preConditionFav();
        baseControlsHelper.clickOn("Favorites");
        baseControlsHelper.openContext(null);
        TestCase.assertTrue("Options missing ", contextualMenu.verifyOptions(null,
                vz_strings.view_insideMusicPlaylist, true));
    }

    private void preConditionFav() throws Exception {

        System.out.println("--Start Preconditions Fav--");
        if (baseControlsHelper.getCountById(vz_strings.view_musicFavorites) < 1) {
            musicView.addSongToFavorites();
        }
        System.out.println("--End Preconditions Fav--");
    }
}
