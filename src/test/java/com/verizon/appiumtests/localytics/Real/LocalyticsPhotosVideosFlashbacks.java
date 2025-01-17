//https://jira.synchronoss.net:8443/jira/browse/VZNFT-220

package com.verizon.appiumtests.localytics.Real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;


public class LocalyticsPhotosVideosFlashbacks extends BaseTestClass {

    @Test
    public void testLocalyticsPhotosVideosFlashbacks() throws Exception {


        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_flashbacks);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_flashBackTab);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_photosVideosFlashBacks + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_photosVideosFlashBacks));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_photosVideosFlashBacks + " is not 1 in logs", 1, localyticsHelper.getCountOf(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_photosVideosFlashBacks));
        localyticsHelper.print(logs, vz_strings.logs_photosVideosFlashBacks);

    }
}
