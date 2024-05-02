/*
* VZNFT-19 - Step 3
* */
package com.verizon.appiumtests.cta;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsHMMusicCTA extends BaseTestClass {

    @Test
    public void testLocalyticsHMMusicCTA() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_music);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagScreen);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaTypeMusic + " exists",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_mediaTypeMusic + " " + vz_strings.logs_CTA) == 1);
    }
}
