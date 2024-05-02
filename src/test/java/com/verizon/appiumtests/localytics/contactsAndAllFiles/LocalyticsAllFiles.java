/**
 * Created by anlin.tang on 10/02/16.
 * VZNFT-61
 */
package com.verizon.appiumtests.localytics.contactsAndAllFiles;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;


public class LocalyticsAllFiles extends BaseTestClass {

    @Test
    public void testLocalyticsAllFiles() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_allFiles);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagScreen);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_allFiles + " is not 1 in logs",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_allFiles) == 1);

    }
}
