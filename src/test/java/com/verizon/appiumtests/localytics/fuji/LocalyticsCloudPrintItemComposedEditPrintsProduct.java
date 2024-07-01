//https://jira.synchronoss.net:8443/jira/browse/VZNFT-229
package com.verizon.appiumtests.localytics.fuji;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * Created by ssam0003 on 24/09/18.
 */
public class LocalyticsCloudPrintItemComposedEditPrintsProduct extends BaseTestClass {
    @Test
    public void testLocalyticsCloudPrintItemComposedEditPrintsProduct() throws Exception {
        homeScreenView.fromHomeClickAt(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        photosAndVideosView.setPickWheelFilter(vz_strings.filter_PhotosOnly);
        photosAndVideosView.removeAllProductFromCart();
        Thread.sleep(3000);
        gridView.tapItemsInMultiSelectMode(1, vz_strings.DataType.PHOTO);
        photosAndVideosView.selectAllAddToCartAndEdit();
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent);
        TestCase.assertEquals("Localytics of " + vz_strings.logs_photoBucketCloudItemComposed + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_photoBucketCloudItemComposed));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketDeliveryType + " is not 1 in logs", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_photoBucketDeliveryType + "\"" + " = " + "\"" + vz_strings.logs_photoBucketMailOrder + "\""));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketPickupLocation + " is not 1 in logs", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_photoBucketPickupLocation + "\"" + " = " + "\"" + vz_strings.logs_NotApplicable + "\""));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_photoBucketItemBrowsed + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_photoBucketItemBrowsed + "\"" + " = " + "\"" + vz_strings.logs_photoBucketItemFirstPrintSize + "\""));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_source + " is not 1 in logs", localyticsHelper.isExisted(logs, vz_strings.logs_source + " = " + "\"" + vz_strings.logs_photoBucketCartPage + "\""));
    }
}
