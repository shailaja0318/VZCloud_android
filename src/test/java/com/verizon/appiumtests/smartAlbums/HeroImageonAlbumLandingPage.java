//IV-168
package com.verizon.appiumtests.smartAlbums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class HeroImageonAlbumLandingPage extends BaseTestClass {

    @Test
    public void testHeroImageonAlbumLandingPage() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        baseControlsHelper.clickOnLabelBeginswith("Story-0");
        TestCase.assertTrue("Hero Image, Icon. Missing ?", baseControlsHelper.getCountById("bt stories white") > 0);
    }
}