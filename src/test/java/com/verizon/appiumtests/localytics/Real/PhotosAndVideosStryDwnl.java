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
        homeScreenView.fromHomeClickAt(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        gridView.tapFolderInSelectMode10("Story-0");
        baseControlsHelper.openContext(vz_strings.context_download);
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaDownload + " is not 1 in logs", localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaDownload) == 1);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_count + "  is not 1 in logs", localyticsHelper.getPatternMatch(logs, vz_strings.logs_count + " = 1") == 1);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaType + "is not 1 in logs", localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\" = Story") == 1);
    }
}