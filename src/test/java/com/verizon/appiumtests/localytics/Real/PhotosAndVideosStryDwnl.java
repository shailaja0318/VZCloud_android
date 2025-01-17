//https://jira.synchronoss.net:8443/jira/browse/VZNFT-73/step-9
package com.verizon.appiumtests.localytics.Real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * Created by kram0003 on 06/03/18.
 */
public class PhotosAndVideosStryDwnl extends BaseTestClass {
    @Test
    public void photosAndVideosSelectStoryAndDownload() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        baseControlsHelper.openContext(vz_strings.context_select);
        photosAndVideosView.openStory10();
        baseControlsHelper.openContext(vz_strings.context_download);
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent);
        TestCase.assertEquals("Localytics of " + vz_strings.logs_iCloudClounts + " is not 1 in logs", 0, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_iCloudClounts));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_iCloudVideosCount + "  is not 1 in logs", 0, localyticsHelper.getPatternMatch(logs, vz_strings.logs_iCloudVideosCount + " = 1"));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_iCloudPhotosCount + "is not 1 in logs", 0, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_iCloudPhotosCount + "\" = Story"));
    }
}
