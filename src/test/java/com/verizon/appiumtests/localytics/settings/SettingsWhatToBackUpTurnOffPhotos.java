//https://jira.synchronoss.net:8443/jira/browse/VZNFT-39 step 3
package com.verizon.appiumtests.localytics.settings;

import com.verizon.appiumtests.constants.HelperUtilities;
import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * Created by ssam0003 on 31/10/2018.
 */
public class SettingsWhatToBackUpTurnOffPhotos extends BaseTestClass {
    @Test
    public void testSettingsWhatToBackUpTurnOffPhotos() throws Exception {
        try {
            homeScreenView.navigateTo(vz_strings.navi_settings);
            baseControlsHelper.clickOn(vz_strings.settings_whatToBackUp);
            settingsView.setWhatNotToBackUp(HelperUtilities.setArguments("", vz_strings.settings_whatToBackUp_Photos));
            String logs = localyticsHelper.getLogs();
            localyticsHelper.print(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_whatToBackupModification);
            TestCase.assertTrue("Localytics of " + vz_strings.logs_whatToBackupModification + " does not exist", localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_whatToBackupModification) == 1);
            TestCase.assertTrue(vz_strings.logs_whatToBackupPhotos + " does not exist", localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_whatToBackupPhotos + "\"" + " = " + vz_strings.logs_no) == 1);
        } finally {
            settingsView.setWhatToBackUp(HelperUtilities.setArguments(vz_strings.settings_whatToBackUp_Contacts, vz_strings.settings_whatToBackUp_Photos, vz_strings.settings_whatToBackUp_Videos));
        }
    }
}
