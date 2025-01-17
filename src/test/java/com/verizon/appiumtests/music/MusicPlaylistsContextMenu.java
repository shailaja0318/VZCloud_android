//IV-726
package com.verizon.appiumtests.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MusicPlaylistsContextMenu extends BaseTestClass {

    @Test
    public void testMusicPlaylistsContextMenu() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_playlists);
        baseControlsHelper.openContext(null);
        TestCase.assertTrue(baseControlsHelper.isVisible(vz_strings.context_select));
    }
}