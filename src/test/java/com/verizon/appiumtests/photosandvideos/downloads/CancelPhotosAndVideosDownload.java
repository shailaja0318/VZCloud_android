package com.verizon.appiumtests.photosandvideos.downloads;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
/**
 * @author leletsn
 * IV847-CancelDownloading
 */
public class CancelPhotosAndVideosDownload extends BaseTestClass {
	private final SoftAssert softAssert = new SoftAssert();
    @Test
    public void testCancelPhotosAndVideosDownload() throws Exception {
         homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
         photosAndVideosView.selectTab(vz_strings.tab_all);
         gridView.tapItemsInSelectMode();
         baseControlsHelper.clickOn(vz_strings.actionBar_selectView_download);
         baseControlsHelper.clickOn(vz_strings.cancel_download);
         
         softAssert.assertTrue(baseControlsHelper.getTextById(vz_strings.dialog_cancelDownload).equals(vz_strings.dialog_cancelDownload), "There is no Cancel Download Label");
         softAssert.assertTrue(baseControlsHelper.getTextById(vz_strings.dialog_CancelDownload_message).equals(vz_strings.dialog_CancelDownload_message), "Text label does not match");
         softAssert.assertTrue(baseControlsHelper.getCountById(vz_strings.dialog_no)!=0,  "'No' button is not displayed" );
         softAssert.assertTrue(baseControlsHelper.getCountById(vz_strings.dialog_yes)!=0,  "'Yes' button is not displayed" );
         
         baseControlsHelper.clickOn(vz_strings.button_yes);
         
         softAssert.assertTrue((baseControlsHelper.getCountById(vz_strings.cancel_download))==0, "Download is still inProgress");
         softAssert.assertAll();
         }
}