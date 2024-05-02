//https://jira.synchronoss.net:8443/jira/browse/VZNFT-496
package com.verizon.appiumtests.localytics.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * Created by ssam0003 on 02/11/18.
 */
public class LocalyticsDeleteMyAccount extends BaseTestClass {
    @Test
    public void testLocalyticsDeleteMyAccount() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_settings);
        baseControlsHelper.clickOn(vz_strings.my_Account);
        baseControlsHelper.clickOn(vz_strings.delete_My_Account);
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagScreen + ": " + vz_strings.delete_My_Account);
        TestCase.assertTrue("Localytics of " + vz_strings.delete_My_Account + "does not exists", localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.delete_My_Account + "") == 1);
    }
}
