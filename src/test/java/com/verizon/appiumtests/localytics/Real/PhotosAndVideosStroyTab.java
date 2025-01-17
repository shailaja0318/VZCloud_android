//https://jira.synchronoss.net:8443/jira/browse/VZNFT-73/step-1
package com.verizon.appiumtests.localytics.Real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * Created by kram0003 on 06/03/18.
 */
public class PhotosAndVideosStroyTab extends BaseTestClass {
    @Test
    public void PhotosAndVideosStoryTab() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        Thread.sleep(3000);
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagScreen);
        localyticsHelper.print(logs, vz_strings.logs_tagScreen);
        TestCase.assertEquals("Localytics of " + vz_strings.logs_photosVideosAll + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_photosVideosStories));
    }
}
