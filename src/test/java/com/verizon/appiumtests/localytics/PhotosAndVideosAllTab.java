//https://jira.synchronoss.net:8443/jira/browse/VZNFT-69/step-1
package com.verizon.appiumtests.localytics;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * Created by kram0003 on 26/02/18
 * updated by leletsn.
 */
public class PhotosAndVideosAllTab extends BaseTestClass {
    @Test
    public void photosAndVideosAllTab() throws Exception {
    	homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagScreen);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_photosVideosAll + " is not 1 in logs", localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_photosVideosAll) == 1);
    }
}
