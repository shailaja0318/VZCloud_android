//https://jira.synchronoss.net:8443/jira/browse/VZNFT-39 step 1 & 2
package com.verizon.appiumtests.localytics.settings;

import com.verizon.appiumtests.constants.HelperUtilities;
import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * Created by ssam0003 on 31/10/2018.
 */
public class SettingsWhatToBackUpSettingsModification extends BaseTestClass {
    @Test
    public void testSettingsWhatToBackUpSettingsModification() throws Exception {
        try {
            homeScreenView.navigateTo(vz_strings.navi_settings);
            baseControlsHelper.clickOn(vz_strings.settings_whatToBackUp);
            settingsView.setWhatNotToBackUp(HelperUtilities.setArguments(vz_strings.settings_whatToBackUp_Contacts));
            String logs = localyticsHelper.getLogs();
            TestCase.assertTrue("Localytics of " + vz_strings.navi_settings + " does not exists",
                    localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.navi_settings + "") == 1);
            TestCase.assertTrue("Localytics of " + vz_strings.logs_whatToBackupModification + " does not exist", localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_whatToBackupModification) == 1);
            TestCase.assertTrue(vz_strings.logs_whatToBackupContacts + " does not exist", localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_whatToBackupContacts + "\"" + " = " + vz_strings.logs_no) == 1);
        } finally {
            settingsView.setWhatToBackUp(HelperUtilities.setArguments(vz_strings.settings_whatToBackUp_Contacts, vz_strings.settings_whatToBackUp_Photos, vz_strings.settings_whatToBackUp_Videos));
        }
    }
}
