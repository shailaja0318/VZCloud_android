/*
 * Step 3 VZNFT-10
 * Step 5 VZNFT-26
*/
package com.verizon.appiumtests.cta;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsHMContactsCTA extends BaseTestClass {

    @Test
    public void testLocalyticsHMContactsCTA() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_contacts);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagScreen);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaTypeDocument + " exists",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_contacts + " " + vz_strings.logs_CTA) == 1);
    }
}
