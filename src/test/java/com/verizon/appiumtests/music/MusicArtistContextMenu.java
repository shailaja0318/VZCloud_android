//IV-695
package com.verizon.appiumtests.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MusicArtistContextMenu extends BaseTestClass {

    @Test
        public void testMusicArtistContextMenu() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_artists);
        baseControlsHelper.openContext(vz_strings.context_select);
        listView.selectItem10("section - 1, row - 0");
        listView.selectFirstItem10();
        baseControlsHelper.openContext(null);


        TestCase.assertTrue("sort not present",
                baseControlsHelper.getCountById(vz_strings.context_addToPlaylist) > 0);
        TestCase.assertTrue("select not present",
                baseControlsHelper.getCountById(vz_strings.context_delete) > 0);

    }
}
