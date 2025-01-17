package com.verizon.appiumtests.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MusicMoreOptions extends BaseTestClass {

    //@Test
    public void testMusicMoreOptions() throws Exception {


        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_more);

        TestCase.assertTrue("Genres not found", baseControlsHelper.getCountById(vz_strings.tab_genres) != 0);
        TestCase.assertTrue("Playlists not found", baseControlsHelper.getCountById(vz_strings.tab_playlists) != 0);
    }
}
