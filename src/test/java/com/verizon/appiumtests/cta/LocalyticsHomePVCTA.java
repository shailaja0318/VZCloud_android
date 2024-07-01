/*
* VZNFT-75 - Step 2
* */
package com.verizon.appiumtests.cta;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsHomePVCTA extends BaseTestClass {

    @Test
    public void testLocalyticsHMPVCTA() throws Exception {

        homeScreenView.fromHomeClickAt(vz_strings.home_cta_pv);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagScreen);

        TestCase.assertEquals("Localytics of " + vz_strings.navi_Photosandvideos + " exists", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.navi_Photosandvideos + " " + vz_strings.logs_CTA));
    }
}
