/*
* VZNFT-75 - Step 1ish
* */
package com.verizon.appiumtests.cta;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsHMPVCTA extends BaseTestClass {

    @Test
    public void testLocalyticsHMPVCTA() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagScreen);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaTypeMusic + " exists",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.navi_Photosandvideos + " " + vz_strings.logs_CTA) < 1);
    }
}
