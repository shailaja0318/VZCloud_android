//https://jira.synchronoss.net:8443/jira/browse/VZNFT-335 - Step-4
package com.verizon.appiumtests.localytics.contactsAndAllFiles;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;

/**
 * Created by ssam0003 on 30/10/2018.
 */
public class LocalyticsLivePhotosMediaPlayAllFiles extends BaseTestClass {

    //@Test
    public void testLocalyticsLivePhotosMediaPlayAllFiles() throws Exception {
        try {
            precondition.uploadLivePhotos(1);
            homeScreenView.navigateTo(vz_strings.navi_allFiles);
            allFilesView.clickOnFirstElementOfMobileRepo();
            String logs = localyticsHelper.getLogs();
            localyticsHelper.print(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaPlay);
            TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaPlay + " is not 1 in logs", localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaPlay) == 1);
            TestCase.assertTrue(vz_strings.logs_mediaType + " does not exist", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + "\"" + vz_strings.logs_mediaTypeLivePhoto + "\""));
        } finally {
            settingsView.tapOnBackButtonAndSetWhatToBackup(true, 3);
        }
    }
}
