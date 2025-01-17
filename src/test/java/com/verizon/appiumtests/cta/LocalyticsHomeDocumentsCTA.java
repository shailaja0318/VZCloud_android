/*
 * Step 2 VZNFT-6
*/
package com.verizon.appiumtests.cta;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsHomeDocumentsCTA extends BaseTestClass {

    @Test
    public void testLocalyticsHomeDocumentsCTA() throws Exception {

        homeScreenView.fromHomeClickAt(vz_strings.home_cta_documents);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagScreen);

        TestCase.assertEquals("Localytics of " + vz_strings.logs_mediaTypeDocument + " does not exist", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_mediaTypeDocument + " " + vz_strings.logs_CTA));
    }

}
