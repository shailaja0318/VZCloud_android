package com.verizon.appiumtests.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MusicGenreContextMenu extends BaseTestClass {

    @Test
    public void testMusicGenreContextMenu() throws Exception {


        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_genres);

        TestCase.assertEquals("Context menu is found ", 0, baseControlsHelper.getCountById(vz_strings.context_menu));
    }
}
