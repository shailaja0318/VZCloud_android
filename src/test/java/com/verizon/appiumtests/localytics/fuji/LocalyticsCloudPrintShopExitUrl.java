package com.verizon.appiumtests.localytics.fuji;
/*//https://jira.synchronoss.net:8443/jira/browse/VZNFT-337
package com.sncr.verizon.appiumtests.localytics;

import com.sncr.verizon.appiumtests.constants.vz_strings;
import com.sncr.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

*//**
 * Created by ssam0003 on 07/11/18.
 *//*
public class LocalyticsCloudPrintShopExitUrl extends BaseTestClass {
    @Test
    public void testLocalyticsCloudPrintShopExitUrl() throws Exception {
        nativeIosAppsView.navigateToFujiCanvasFromMail();
        baseControlsHelper.waitForShow(vz_strings.button_SeeMoreProducts);
        baseControlsHelper.clickOn(vz_strings.button_exit);
        baseControlsHelper.clickOn(vz_strings.button_yes);
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketExit + " is not 1 in logs", localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_photoBucketExit) == 1);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_AddressValidationError + " is not 1 in logs", localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_AddressValidationError + "\"" + " = " + "0") == 1);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketDeliveryType + " is not 1 in logs", localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_photoBucketDeliveryType + "\"" + " = " + "\"" + vz_strings.logs_photoBucketMailOrder + "\"") == 1);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketEntryPoint + " does not exist", localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_photoBucketEntryPoint + "\"" + " = " + vz_strings.logs_URL) == 2);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketExitMethod + " is not 1 in logs", localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_photoBucketExitMethod + "\"" + " = " + "\"" + vz_strings.logs_photoBucketCancelButton + "\"") == 1);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketExitPoint + " is not 1 in logs", localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_photoBucketExitPoint + "\"" + " = " + "\"" + vz_strings.logs_PhotoBucketProductsPage + "\"") == 1);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketItemsPurchased + " is not 1 in logs", localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_photoBucketItemsPurchased + "\"" + " = " + "0") == 1);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketPickupLocation + " is not 1 in logs", localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_photoBucketPickupLocation + "\"" + " = " + "\"" + vz_strings.logs_NotApplicable + "\"") == 1);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketPromoCodeUsed + " is not 1 in logs", localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_photoBucketPromoCodeUsed + "\"" + " = " + "\"" + vz_strings.logs_NotApplicable + "\"") == 1);
    }
}
*/