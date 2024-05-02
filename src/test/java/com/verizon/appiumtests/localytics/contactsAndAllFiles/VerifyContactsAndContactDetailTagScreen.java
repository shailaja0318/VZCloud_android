package com.verizon.appiumtests.localytics.contactsAndAllFiles;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;

/**
 * Created by ssam0003 on 30/07/18.
 */
public class VerifyContactsAndContactDetailTagScreen extends BaseTestClass{
   // @Test
    public void testVerifyContactsAndContactDetailTagScreen() throws Exception{
        homeScreenView.navigateTo(vz_strings.navi_contacts);
        Thread.sleep(20000);
        /*String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_contacts);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_contacts + " does not exist",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_contacts) == 1);*/
    }
}
