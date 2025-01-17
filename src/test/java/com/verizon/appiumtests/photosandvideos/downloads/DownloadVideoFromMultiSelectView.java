/**
 * IV-864
 * */
package com.verizon.appiumtests.photosandvideos.downloads;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DownloadVideoFromMultiSelectView extends BaseTestClass {

    private final SoftAssert softAssert = new SoftAssert();

    @Test
    public void testDownloadPhotoFromMultiSelectView() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        baseControlsHelper.clickOn(vz_strings.context_menu);
        baseControlsHelper.clickOn(vz_strings.context_select);
        baseControlsHelper.waitForContent();
        baseControlsHelper.clickOnLabelLike(vz_strings.name_video);
        softAssert.assertEquals("Downloading 1 of 1","Downloading 1 of 1");

        photosAndVideosView.checkDownload();
        softAssert.assertAll();
    }
}
