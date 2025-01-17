//IV-705
package com.verizon.appiumtests.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MusicSongsSelectModeContextMenu extends BaseTestClass {

    @Test
    public void testMusicSongsSelectModeContextMenu() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_songs);
        baseControlsHelper.openContext(vz_strings.context_select);
        listView.selectFirstItem10();
        baseControlsHelper.openContext(null);

        TestCase.assertTrue(baseControlsHelper.isVisible(vz_strings.context_info));
        TestCase.assertTrue(baseControlsHelper.isVisible(vz_strings.context_delete));
        TestCase.assertTrue(baseControlsHelper.isVisible(vz_strings.context_share));
        TestCase.assertTrue(baseControlsHelper.isVisible(vz_strings.context_addToPlaylist));



    }
}
