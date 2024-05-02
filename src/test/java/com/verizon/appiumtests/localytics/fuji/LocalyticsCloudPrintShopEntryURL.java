package com.verizon.appiumtests.localytics.fuji;
/*//https://jira.synchronoss.net:8443/jira/browse/VZNFT-345
package com.sncr.verizon.appiumtests.localytics;

import com.sncr.verizon.appiumtests.constants.vz_strings;
import com.sncr.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

*//**
 * Created by ssam0003 on 05/11/18.
 *//*
public class LocalyticsCloudPrintShopEntryURL extends BaseTestClass {
    @Test
    public void testLocalyticsCloudPrintShopEntryURL() throws Exception {
        nativeIosAppsView.navigateToFujiCanvasFromMail();
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketEntry + " is not 1 in logs", localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_photoBucketEntry) == 1);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketNumber + " does not exist", localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_photoBucketNumber + "\" = 0") == 1);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketEntryPoint + " does not exist", localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_photoBucketEntryPoint + "\"" + " = " + vz_strings.logs_URL) == 1);
    }
}
*/