package com.verizon.appiumtests.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MusicLastViewRetained extends BaseTestClass {

    @Test
    public void testMusicLastViewRetained() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_songs);
        homeScreenView.navigateTo(vz_strings.navi_home);
        homeScreenView.navigateTo(vz_strings.navi_music);

        TestCase.assertTrue("Music view not selected ",
                baseControlsHelper.isSelectedByTypeAndName("XCUIElementTypeButton", "Songs"));
    }
}
