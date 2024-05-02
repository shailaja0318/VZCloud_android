package com.verizon.appiumtests.photosandvideos;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.Test;

public class PhotoOrientation extends BaseTestClass {

    @Test
    public void testPhotoOrientation() throws Exception {


        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        Thread.sleep(2000);
        baseControlsHelper.clickOnLabelLike(vz_strings.name_photo);
        Thread.sleep(2000);
        baseControlsHelper.setOrientation(ScreenOrientation.LANDSCAPE);
        Thread.sleep(2000);
        baseControlsHelper.setOrientation(ScreenOrientation.PORTRAIT);

        TestCase.assertTrue("Photo is not open", baseControlsHelper.getCountByClassName("XCUIElementTypeScrollView") != 0);
    }
}