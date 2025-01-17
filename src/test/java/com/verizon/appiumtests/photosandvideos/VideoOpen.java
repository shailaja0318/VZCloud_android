package com.verizon.appiumtests.photosandvideos;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * IV-287
 * @author leletsn
 *
 */
public class VideoOpen extends BaseTestClass {

    @Test
    public void testOpenVideo() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        baseControlsHelper.clickOnElementByXpath(vz_strings.name_video);
        TestCase.assertTrue("video" ,baseControlsHelper.isVisible(vz_strings.button_videoPlay));
        photosAndVideosView.playVideo();
    }
}