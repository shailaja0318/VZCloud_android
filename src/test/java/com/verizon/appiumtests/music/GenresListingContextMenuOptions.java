package com.verizon.appiumtests.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class GenresListingContextMenuOptions extends BaseTestClass {

    @Test
    public void testGenresListingContextMenuOptions() throws Exception {


        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_genres);
        listView.selectItem10("Unknown Genre");
        baseControlsHelper.openContext(null);

        TestCase.assertTrue("Options missing ", contextualMenu.verifyOptions(null, vz_strings.view_musicGenres, true));

    }
}
