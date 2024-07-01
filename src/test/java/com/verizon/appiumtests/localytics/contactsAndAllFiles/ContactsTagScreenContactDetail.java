//https://jira.synchronoss.net:8443/jira/browse/VZNFT-9
package com.verizon.appiumtests.localytics.contactsAndAllFiles;

import com.verizon.appiumtests.constants.HelperUtilities;
import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;

/**
 * Created by ssam0003 on 18/10/18.
 */
public class ContactsTagScreenContactDetail extends BaseTestClass {
    private void precondition() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_settings);
        settingsView.setWhatToBackUp(HelperUtilities.setArguments(vz_strings.settings_whatToBackUp_Contacts));
        settingsView.setWhatNotToBackUp(HelperUtilities.setArguments("", vz_strings.settings_whatToBackUp_Photos, vz_strings.settings_whatToBackUp_Videos));
        baseControlsHelper.tapOnBackButton();
    }

 //   @Test
    public void testContactsTagScreenContactDetail() throws Exception {
        try {
           // precondition();
           // contactsView.addRequiredNumberOfContacts(10);
            contactsView.clickOncontactsListView();
            String logs = localyticsHelper.getLogs();
            localyticsHelper.print(logs, vz_strings.logs_tagScreen);
            TestCase.assertEquals("Localytics of " + vz_strings.logs_contacts + " exists", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_contacts));
            TestCase.assertEquals("Localytics of " + vz_strings.logs_Contact_Detail + " exists", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_Contact_Detail));
        } finally {
            settingsView.tapOnBackButtonAndSetWhatToBackup(true, 1);
        }
    }
}
