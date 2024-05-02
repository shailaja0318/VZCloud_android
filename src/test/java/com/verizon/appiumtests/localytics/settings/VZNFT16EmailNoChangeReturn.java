// VZNFT-16 Step 4 ER
//TODO Obsolete please remove
package com.verizon.appiumtests.localytics.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;

public class VZNFT16EmailNoChangeReturn extends BaseTestClass {

    public void testLocalyticsEmailNoChangeReturn() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_settings);
        baseControlsHelper.clickOn(vz_strings.settings_email);
        baseControlsHelper.clickOn("Return");

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_whatToBackupModification);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_whatToBackupModification + " is not 1 in logs", localyticsHelper.isExisted(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_whatToBackupModification));
        TestCase.assertTrue(vz_strings.logs_whatToBackupContacts + " does not exist", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_whatToBackupContacts + "\"" + " = " + "\"" + vz_strings.logs_no_change + "\""));
        TestCase.assertTrue(vz_strings.logs_whatToBackupPhotos + " does not exist", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_whatToBackupPhotos + "\"" + " = " + "\"" + vz_strings.logs_no_change + "\""));
        TestCase.assertTrue(vz_strings.logs_whatToBackupPhotosBackground + " does not exist", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_whatToBackupPhotosBackground + "\"" + " = " + "\"" + vz_strings.logs_no_change + "\""));
        TestCase.assertTrue(vz_strings.logs_whatToBackupVideos + " does not exist", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_whatToBackupVideos + "\"" + " = " + "\"" + vz_strings.logs_no_change + "\""));
        TestCase.assertTrue(vz_strings.logs_whatToBackupEmail + " does not exist", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_whatToBackupEmail + "\"" + " = " + "\"" + vz_strings.logs_no_change + "\""));
        TestCase.assertTrue(vz_strings.logs_whatToBackupHowToBackup + " does not exist", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_whatToBackupHowToBackup + "\"" + " = " + "\"" + vz_strings.logs_no_change + "\""));
    }
}
