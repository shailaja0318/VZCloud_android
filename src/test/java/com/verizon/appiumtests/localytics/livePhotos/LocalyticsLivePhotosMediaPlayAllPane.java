//https://jira.synchronoss.net:8443/jira/browse/VZNFT-335 - Step-1
package com.verizon.appiumtests.localytics.livePhotos;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * Created by ssam0003 on 05/10/2018.
 */
public class LocalyticsLivePhotosMediaPlayAllPane extends BaseTestClass {
    boolean flag = false;

    @Test
    public void testLocalyticsLivePhotosMediaPlayAllPane() throws Exception {
        try {
           // flag = photosAndVideosView.uploadAndFilterLivePhotos(1);
            baseControlsHelper.clickOnLabelLike(vz_strings.name_livePhoto_index);
            Thread.sleep(1000);
            baseControlsHelper.touchAndHoldOnElement(baseControlsHelper.getLivePhotoElement());
            String logs = localyticsHelper.getLogs();
            localyticsHelper.print(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaPlay);
            TestCase.assertEquals("Localytics of " + vz_strings.logs_mediaPlay + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaPlay));
            TestCase.assertTrue(vz_strings.logs_mediaType + " does not exist", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + "\"" + vz_strings.logs_mediaTypeLivePhoto + "\""));
        } finally {
            settingsView.tapOnBackButtonAndSetWhatToBackup(flag, 1);
        }
    }
}
