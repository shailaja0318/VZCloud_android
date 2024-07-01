// VZNFT-16 Step 3 ER
//TODO Obsolete pleae remove
package com.verizon.appiumtests.localytics.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import org.testng.asserts.SoftAssert;

public class VZNFT16EmailAddressChange extends BaseTestClass {
    private final SoftAssert softAssert = new SoftAssert();

    public void testLocalyticsEmailAddressChange() throws Exception {

        String testAddress = generateRandomEmailAddress();
        String emailField = vz_strings.settings_emailField;

        // backup existing email
        navigateBackToEmailView();
        String backupEmail = baseControlsHelper.getValue(emailField);

        // Test 1: Change the the screen changed and is at the settings
        settingsView.updateEmail(testAddress);
        //TestCase.assertTrue("Not back to Settings screen", baseControlsHelper.getCountByName(vz_strings.navi_settings) != 0);
        navigateBackToEmailView();

        // Test 2: Change the email and check that the email has changed
        String updatedEmail = baseControlsHelper.getValue(emailField);
        softAssert.assertEquals(testAddress, updatedEmail);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_whatToBackupModification);

        softAssert.assertEquals(localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_whatToBackupModification),
                1,
                vz_strings.logs_whatToBackupModification + " is not 1 in logs");

        softAssert.assertEquals(localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_whatToBackupContacts + "\"" + " = " + "\"" + vz_strings.logs_no_change + "\""),
                1,
                vz_strings.logs_whatToBackupContacts + " is not 1 in logs");

        softAssert.assertEquals(localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_whatToBackupPhotos + "\"" + " = " + "\"" + vz_strings.logs_no_change + "\""),
                1,
                vz_strings.logs_whatToBackupPhotos + " is not 1 in logs");

        softAssert.assertEquals(localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_whatToBackupPhotosBackground + "\"" + " = " + "\"" + vz_strings.logs_no_change + "\""),
                1,
                vz_strings.logs_whatToBackupPhotosBackground + " is not 1 in logs");

        softAssert.assertEquals(localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_whatToBackupVideos + "\"" + " = " + "\"" + vz_strings.logs_no_change + "\""),
                1,
                vz_strings.logs_whatToBackupVideos + " is not 1 in logs");

        softAssert.assertEquals(localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_whatToBackupEmail + "\"" + " = " + vz_strings.logs_updated),
                1,
                vz_strings.logs_whatToBackupEmail + " is not 1 in logs");

        softAssert.assertEquals(localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_whatToBackupHowToBackup + "\"" + " = " + "\"" + vz_strings.logs_no_change + "\""),
                1,
                vz_strings.logs_whatToBackupHowToBackup + " is not 1 in logs");

        // Test 3: Reset the email back to original and check that it's changed
        settingsView.updateEmail(backupEmail);
        navigateBackToEmailView();
        softAssert.assertAll();

    }

    private void navigateBackToEmailView() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_settings);
        baseControlsHelper.clickOn(vz_strings.settings_email);
    }

    /**
     * Generates a new email with a random number appended to it. this is to check that email changes successfully
     * and it doesn't just keep the old value
     *
     * @return Returns an email address such as eg: <code>"atclienttest3254@gmail.com"</code>
     * @author Alen Kalac
     */
    private String generateRandomEmailAddress() {
        int random = (int) (Math.random() * 10000);
        String address = "atclienttest" + random + "@gmail.com";
        return address;
    }
}

