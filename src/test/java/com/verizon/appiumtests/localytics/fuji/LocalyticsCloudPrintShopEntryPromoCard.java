//https://jira.synchronoss.net:8443/jira/browse/VZNFT-346
package com.verizon.appiumtests.localytics.fuji;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;

/**
 * Created by ssam0003 on 07/11/18.
 */
public class LocalyticsCloudPrintShopEntryPromoCard extends BaseTestClass {
    //@Test //no more promo cards in Cloud
    public void testLocalyticsCloudPrintShopEntryPromoCard() throws Exception {
        homeScreenView.navigateToFuji();
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent);
        TestCase.assertEquals("Localytics of " + vz_strings.logs_photoBucketEntry + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_photoBucketEntry));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_photoBucketNumber + " does not exist", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_photoBucketNumber + "\" = 0"));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_photoBucketEntryPoint + " does not exist", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_photoBucketEntryPoint + "\"" + " = " + vz_strings.logs_PromoCard));
    }
}
