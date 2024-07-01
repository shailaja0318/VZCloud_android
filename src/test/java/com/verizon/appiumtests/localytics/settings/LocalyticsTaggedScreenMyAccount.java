//https://jira.synchronoss.net:8443/jira/browse/VZNFT-495
package com.verizon.appiumtests.localytics.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * Created by ssam0003 on 31/10/2018.
 */
public class LocalyticsTaggedScreenMyAccount extends BaseTestClass {
    @Test
    public void testLocalyticsTaggedScreenMyAccount() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_settings);
        baseControlsHelper.clickOn(vz_strings.my_Account);
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagScreen + ": " + vz_strings.my_Account);
        TestCase.assertEquals("Localytics of " + vz_strings.my_Account + " not exists", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.my_Account));
    }
}
