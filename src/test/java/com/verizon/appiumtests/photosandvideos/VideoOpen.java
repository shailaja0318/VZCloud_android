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
        baseControlsHelper.clickOnLabelLike(vz_strings.name_video);
        photosAndVideosView.playVideo();
        baseControlsHelper.waitForShow("Play/Pause");
        TestCase.assertTrue("Video is not open", baseControlsHelper.getCountById(vz_strings.name_video) != 0);
    }
}