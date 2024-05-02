package com.verizon.appiumtests.photosandvideos;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.Test;

public class VideoOrientation extends BaseTestClass {

    @Test
    public void testVideoOrientation() throws Exception {


        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        baseControlsHelper.clickOnLabelLike(vz_strings.name_video);
        photosAndVideosView.playVideo();
        Thread.sleep(2000);
        baseControlsHelper.setOrientation(ScreenOrientation.LANDSCAPE);
        Thread.sleep(2000);
        baseControlsHelper.setOrientation(ScreenOrientation.PORTRAIT);

        TestCase.assertTrue("Video is not open", baseControlsHelper.getCountById(vz_strings.name_video) != 0);
    }
}
