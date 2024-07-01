/*
 * Step 2 VZNFT-10
 * Step 4 VZNFT-26
*/
package com.verizon.appiumtests.cta;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsHomeContactsCTA extends BaseTestClass {

    @Test
    public void testLocalyticsHomeContactsCTA() throws Exception {

        homeScreenView.fromHomeClickAt(vz_strings.home_cta_contacts);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagScreen);

        TestCase.assertEquals("Localytics of " + vz_strings.logs_contacts + " does not exist", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_contacts + " " + vz_strings.logs_CTA));
    }

}
