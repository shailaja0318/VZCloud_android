//IV-702
package com.verizon.appiumtests.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MediaPlayerQueueSelectContextualMenuOptions extends BaseTestClass {

    @Test
    public void testMeidaPlayerQueueSelectContextualMenuOptions() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_playlists);
        preConditionFav();
      //  baseControlsHelper.clickOn("On-The-Go");
        preCondition();
        baseControlsHelper.clickOnElementByXpath(vz_strings.availableSongs);
        baseControlsHelper.openContext(vz_strings.context_select);
        listView.selectFirstItem10();
        baseControlsHelper.openContext(null);


    }

    private void preCondition() throws Exception {

        System.out.println("--Start Preconditions--");
        if (baseControlsHelper.getCountById(vz_strings.view_emptyPlaylist) != 0) {
            musicView.addSongToPlaylist();
        }
        System.out.println("--End Preconditions--");
    }

    private void preConditionFav() throws Exception {

        System.out.println("--Start Preconditions Fav--");
        if (baseControlsHelper.getCountById(vz_strings.view_musicFavorites) > 0) {
            musicView.removeSongFromFavorites();
        }
        System.out.println("--End Preconditions Fav--");
    }
}
