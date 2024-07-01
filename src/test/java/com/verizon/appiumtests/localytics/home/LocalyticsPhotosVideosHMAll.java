/**
 * VZNFT-41 - Step 2
 */
package com.verizon.appiumtests.localytics.home;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsPhotosVideosHMAll extends BaseTestClass {

    @Test
    public void testLocalyticsPhotosVideosHMAll() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagScreen);

        TestCase.assertEquals(vz_strings.logs_photosVideosAll + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_photosVideosAll));
    }
}
