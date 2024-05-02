//https://jira.synchronoss.net:8443/jira/browse/VZNFT-227
package com.verizon.appiumtests.localytics.fuji;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * Created by ssam0003 on 05/11/18.
 */
public class LocalyticsCloudPrintShopExitBackButton extends BaseTestClass {
    @Test
    public void testLocalyticsCloudPrintShopExitBackButton() throws Exception {
        homeScreenView.fromHomeClickAt(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
       // photosAndVideosView.setPickWheelFilter(vz_strings.filter_PhotosOnly);
        photosAndVideosView.removeAllProductFromCart();
        Thread.sleep(3000);
        gridView.tapItemsInMultiSelectMode(1, vz_strings.DataType.PHOTO);
        photosAndVideosView.accessPrintShopFromIcon();
        baseControlsHelper.tapOnBackButton();
        baseControlsHelper.clickOn(vz_strings.button_yes);
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_photoBucketExit);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketExit + " is not 1 in logs", localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_photoBucketExit) > 0);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketItemsPurchased + " is not 1 in logs", localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_photoBucketItemsPurchased + "\"" + " = " + "0") > 0);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketExitPoint + " is not 1 in logs", localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_photoBucketExitPoint + "\"" + " = " + "\"" + vz_strings.logs_PrintService_Options_Page + "\"") >0);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketPromoCodeUsed + " is not 1 in logs", localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_photoBucketPromoCodeUsed + "\"" + " = " + "\"" + vz_strings.logs_NotApplicable + "\"")>0);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_AddressValidationError + " is not 1 in logs", localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_AddressValidationError + "\"" + " = " + "0")>0);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketExitMethod + " is not 1 in logs", localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_photoBucketExitMethod + "\"" + " = " + "\"" + vz_strings.logs_Back_Button + "\"") >0);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketDeliveryType + " is not 1 in logs", localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_photoBucketDeliveryType + "\"" + " = " + "\"" + vz_strings.logs_photoBucketMailOrder + "\"") >0);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketPickupLocation + " is not 1 in logs", localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_photoBucketPickupLocation + "\"" + " = " + "\"" + vz_strings.logs_NotApplicable + "\"") >0);
    }
}
