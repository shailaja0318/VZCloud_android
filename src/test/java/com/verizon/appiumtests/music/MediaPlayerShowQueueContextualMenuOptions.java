//IV-722
package com.verizon.appiumtests.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MediaPlayerShowQueueContextualMenuOptions extends BaseTestClass {

    @Test
    public void testMediaPlayerShowQueueContextualMenuOptions() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_playlists);
        baseControlsHelper.clickOn("On-The-Go");
        preCondition();
        listView.selectFirstItem10();
        baseControlsHelper.openContext(vz_strings.context_showQueue);
        baseControlsHelper.openContext(null);

        TestCase.assertTrue("Options missing ", contextualMenu.verifyOptions(null, vz_strings.view_musicPlayerQueue, true));

    }

    private void preCondition() throws Exception {

        System.out.println("--Start Preconditions--");
        if (baseControlsHelper.getCountById(vz_strings.view_emptyPlaylist) != 0) {
            musicView.addSongToPlaylist();
        }
        System.out.println("--End Preconditions--");
    }

}
