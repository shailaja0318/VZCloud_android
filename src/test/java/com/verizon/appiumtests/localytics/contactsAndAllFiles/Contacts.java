//VZNFT-7 Step 2
package com.verizon.appiumtests.localytics.contactsAndAllFiles;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class Contacts extends BaseTestClass {

    @Test
    public void testContacts() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_contacts);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_contacts);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_contacts + " does not exist", localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_contacts) == 1);
    }
}

