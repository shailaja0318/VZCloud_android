//https://jira.synchronoss.net:8443/jira/browse/VZNFT-241
package com.verizon.appiumtests.localytics.fuji;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * Created by kram0003 on 05/02/18.
 */
public class PrintsAndGiftsHamburgerMenu extends BaseTestClass {
    @Test
    public void printsAndGift() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_printshop);
        baseControlsHelper.waitForDismiss(vz_strings.spinner);
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_photoBucketEntry);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketEntry + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_photoBucketEntry));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_tagEvent + " is not 1 in logs", 1, localyticsHelper.getCountOf(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_photoBucketEntry));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketEntryPoint + " does not exist", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_photoBucketEntryPoint + "\" = \"" + vz_strings.logs_menu_view + "\""));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketNumber + " does not exist", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_photoBucketNumber + "\" = 0"));
    }

}
