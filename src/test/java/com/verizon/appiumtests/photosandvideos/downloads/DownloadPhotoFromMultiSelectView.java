/**
 * IV-836
 * */
package com.verizon.appiumtests.photosandvideos.downloads;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DownloadPhotoFromMultiSelectView extends BaseTestClass {
    private final SoftAssert softAssert = new SoftAssert();

    @Test
    public void testDownloadPhotoFromMultiSelectView() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        gridView.tapItemInSelectMode(vz_strings.DataType.PHOTO);
        baseControlsHelper.clickOn(vz_strings.actionBar_selectView_download);

        softAssert.assertEquals("Downloading 1 of 1","Downloading 1 of 1");
        baseControlsHelper.waitForDismiss("1 file downloaded.");

        photosAndVideosView.checkDownload();
        softAssert.assertAll();
    }
}
