//Iv-708
package com.verizon.appiumtests.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MusicArtistsSelectModeContextMenu extends BaseTestClass {

    @Test
    public void testMusicArtistsSelectModeContextMenu() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_artists);
        baseControlsHelper.openContext(vz_strings.context_select);
        listView.selectFirstItem10();
        baseControlsHelper.openContext(null);

        TestCase.assertTrue("sort not present",
                baseControlsHelper.getCountById(vz_strings.context_addToPlaylist) > 0);
        TestCase.assertTrue("select not present",
                baseControlsHelper.getCountById(vz_strings.context_playSelected) > 0);
    }
}