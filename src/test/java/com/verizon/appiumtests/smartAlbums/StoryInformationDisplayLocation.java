package com.verizon.appiumtests.smartAlbums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class StoryInformationDisplayLocation extends BaseTestClass {

    @Test
    public void testStoryInformationDisplayLocation() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        TestCase.assertTrue("Name and date of album missing ?", baseControlsHelper.getTextByNameContains("2021").contains("2021"));
    }
}