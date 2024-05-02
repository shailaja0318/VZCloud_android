//VZNFT-15
package com.verizon.appiumtests.localytics.settings;

import com.verizon.appiumtests.constants.HelperUtilities;
import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;

public class LocalyticsSettingsWhatToBackUp extends BaseTestClass {

  //  @Test
    public void testLocalyticsSettingsWhatToBackUp() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_settings);
        settingsView.disableAllOptions();
        settingsView.setWhatToBackUp(HelperUtilities.setArguments(vz_strings.settings_whatToBackUp_Contacts,vz_strings.settings_whatToBackUp_Photos, vz_strings.settings_whatToBackUp_Videos));

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_whatToBackupModification);

        TestCase.assertTrue(vz_strings.logs_whatToBackupModification + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_whatToBackupModification));
        TestCase.assertTrue(vz_strings.logs_whatToBackupContacts + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_whatToBackupContacts));
        TestCase.assertTrue(vz_strings.logs_whatToBackupPhotos + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_whatToBackupPhotos));
        TestCase.assertTrue(vz_strings.logs_whatToBackupVideos + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_whatToBackupVideos));
        TestCase.assertTrue(vz_strings.logs_whatToBackupEmail + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_whatToBackupEmail));
        TestCase.assertTrue(vz_strings.logs_whatToBackupHowToBackup + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_whatToBackupHowToBackup));
        TestCase.assertTrue(vz_strings.logs_whatToBackupReminder + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_whatToBackupReminder));
        TestCase.assertTrue(vz_strings.logs_whatToBackupPhotosBackground + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_whatToBackupPhotosBackground));
        //TestCase.assertTrue(vz_strings.logs_whatToBackupVideosBackground +" does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_whatToBackupVideosBackground));
    }
}
