/*
* VZNFT-19 - Step 4
* */
package com.verizon.appiumtests.cta;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsHomeMusicCTA extends BaseTestClass {

    @Test
    public void testLocalyticsHomeMusicCTA() throws Exception {

        homeScreenView.fromHomeClickAt(vz_strings.home_cta_music);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagScreen);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaTypeMusic + " does not exists",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_mediaTypeMusic + " " + vz_strings.logs_CTA) == 1);
    }
}
