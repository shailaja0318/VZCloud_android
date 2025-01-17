package com.verizon.appiumtests.photosandvideos;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class PhotoOpen extends BaseTestClass {

    @Test
    public void testOpenPhoto() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        baseControlsHelper.clickOnElementByXpath(vz_strings.name_photo);

        TestCase.assertTrue("ImageView is not open", baseControlsHelper.getCountByClassName("XCUIElementTypeScrollView") != 0);
    }
}