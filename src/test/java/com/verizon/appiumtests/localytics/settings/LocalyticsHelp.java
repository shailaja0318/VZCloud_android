package com.verizon.appiumtests.localytics.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;

/**
 * Created by anlin.tang on 08/02/16.
 */
public class LocalyticsHelp extends BaseTestClass {

 //   @Test    // deprecated
    public void testLocalyticsHelp() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_helpAndFeedback);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_helpAccess);
        localyticsHelper.print(logs, vz_strings.logs_helpScreen);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_helpAccess + " does not exist",
                localyticsHelper.isExisted(logs, vz_strings.logs_helpAccess));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_helpScreen + " does not exist",
                localyticsHelper.isExisted(logs, vz_strings.logs_helpScreen));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_helpAccess + " does not exist",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_helpAccess) == 1);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_helpScreen + " does not exist",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_helpScreen) == 1);
    }
}
