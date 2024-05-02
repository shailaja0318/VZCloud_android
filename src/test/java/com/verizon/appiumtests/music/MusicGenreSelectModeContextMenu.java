//IV-723
package com.verizon.appiumtests.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MusicGenreSelectModeContextMenu extends BaseTestClass {

    @Test
    public void testMusicGenreSelectModeContextMenu() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_genres);
        listView.selectFirstItem10();
        listView.selectItemInSelectMode10("section - 0, row - 0");
        baseControlsHelper.openContext(null);

        TestCase.assertTrue("Options missing ", contextualMenu.verifyOptions(vz_strings.DataType.MUSIC,
                vz_strings.view_insideMusicGenres, false));
    }
}
