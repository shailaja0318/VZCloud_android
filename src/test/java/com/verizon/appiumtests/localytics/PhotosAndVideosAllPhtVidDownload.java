//https://jira.synchronoss.net:8443/jira/browse/VZNFT-69/step-6
package com.verizon.appiumtests.localytics;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by kram0003
 * updated by leletsn
 */
public class PhotosAndVideosAllPhtVidDownload extends BaseTestClass {
    @Test
    public void photosandVideosPhtVidDwnld() throws Exception {
    	homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        gridView.tapItemsInSelectMode();
        baseControlsHelper.waitForShow(vz_strings.actionBar_selectView_download);
        baseControlsHelper.clickOn(vz_strings.actionBar_selectView_download);
        photosAndVideosView.checkDownload();

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent);

        List<String> mediaType = localyticsHelper.dynamicCount(logs, vz_strings.logs_mediaType);
        TestCase.assertEquals("Localytics of " + vz_strings.logs_mediaDownload + " is not 1 in logs", 0, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaDownloadComplete));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_count + "  is not 2 in logs", localyticsHelper.getPatternMatch(logs, vz_strings.logs_count + " = 1")>=1);
        for (String mediatypes : mediaType) {
            if ((mediatypes.contains("Video")) || (mediatypes.contains("Photo"))) {
                TestCase.assertEquals("Localytics of " + vz_strings.logs_mediaType + "is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\" " + mediatypes));
            }
            else TestCase.fail("Localytics of " + vz_strings.logs_mediaType + " not matches");
        }
    }
}
