package com.verizon.appiumtests.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MusicAlbumsContextMenu extends BaseTestClass {

    @Test
    public void testMusicAlbumsContextMenu() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_albums);
        baseControlsHelper.openContext(null);
        TestCase.assertTrue("sort not present",
                baseControlsHelper.getCountById(vz_strings.context_sort) > 0);
        TestCase.assertTrue("select not present",
                baseControlsHelper.getCountById(vz_strings.context_select) > 0);
    }
}
