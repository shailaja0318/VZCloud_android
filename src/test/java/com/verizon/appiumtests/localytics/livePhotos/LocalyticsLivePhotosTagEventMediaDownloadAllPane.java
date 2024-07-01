//https://jira.synchronoss.net:8443/jira/browse/VZNFT-323
package com.verizon.appiumtests.localytics.livePhotos;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * leletsn
 */
public class LocalyticsLivePhotosTagEventMediaDownloadAllPane extends BaseTestClass {
    @Test
    public void testLocalyticsLivePhotosTagEventMediaDownload() throws Exception {
    	   homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		    photosAndVideosView.selectTab(vz_strings.tab_all);
            gridView.tapItemInSelectMode(vz_strings.DataType.LIVEPHOTO);
            baseControlsHelper.clickOn(vz_strings.actionBar_selectView_download);
           // baseControlsHelper.waitForShow("1 file downloaded.");
            String logs = localyticsHelper.getLogs();
            localyticsHelper.print(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaDownload);
            TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaDownload + " does not exist", localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaDownload) > 0);
            TestCase.assertTrue("Localytics of " + vz_strings.logs_count + " is not 1 in logs", localyticsHelper.getPatternMatch(logs, vz_strings.logs_count + " = " + "1") > 0);
        TestCase.assertEquals(vz_strings.logs_mediaType + " does not exist", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + "\"" + vz_strings.name_livePhoto + "\""));
       
    }
}
