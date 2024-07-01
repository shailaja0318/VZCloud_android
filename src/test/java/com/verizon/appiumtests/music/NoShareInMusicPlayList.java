//IV-257
package com.verizon.appiumtests.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class NoShareInMusicPlayList extends BaseTestClass {

    @Test
    public void testNoShareInMusicPlayList() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_playlists);
        listView.selectItemInSelectMode10("section - 0, row - 0");
        baseControlsHelper.openContext(null);

        TestCase.assertEquals("Share present in context menu", 0, baseControlsHelper.getCountById(vz_strings.context_share));
    }
}