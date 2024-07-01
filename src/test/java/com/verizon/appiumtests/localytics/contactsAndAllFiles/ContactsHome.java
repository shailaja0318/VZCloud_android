//VZNFT-7 Step 1
package com.verizon.appiumtests.localytics.contactsAndAllFiles;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;

public class ContactsHome extends BaseTestClass {

//    @Test
    public void testContacts() throws Exception {
        homeScreenView.fromHomeClickAt(vz_strings.home_contact);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagScreen);
        TestCase.assertEquals("Localytics of " + vz_strings.logs_contacts + " does not exist", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_contacts));
    }
}

