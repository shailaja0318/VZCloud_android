//IV-66
package com.verizon.appiumtests.allFiles;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class AllFileOpenVideo extends BaseTestClass {

    @Test
    public void testAllFileOpenVideo() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_allFiles);
        baseControlsHelper.clickOnNameContains("Mobile");
        listView.selectFirstItem10();
        //baseControlsHelper.clickOn("mp4");
        photosAndVideosView.playVideo();

        TestCase.assertTrue("Video is not open", baseControlsHelper.getCountById(vz_strings.button_done) != 0);
    }
}