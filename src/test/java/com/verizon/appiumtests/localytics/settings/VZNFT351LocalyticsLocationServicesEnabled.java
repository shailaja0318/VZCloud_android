package com.verizon.appiumtests.localytics.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import com.verizon.appiumtests.driver.BaseDriver;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/*IOSVZ-12753
 * Story - Localytics: Add new Profile Attribute for "Location Services"
 * Test  - VZNF351: Profile Attribute - Locations Services
 * https://jira.synchronoss.net:8443/jira/browse/VZNFT-351 #Step 1
 * */

public class VZNFT351LocalyticsLocationServicesEnabled extends BaseTestClass {

    @Test
    public void testVZNFT351LocalyticsLocationServicesEnabled() throws Exception {

        BaseDriver.runAppInBackground(5);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, "attr" + " = " + "\"" + vz_strings.logs_location_services + "\"");
        localyticsHelper.print(logs, "value" + " = " + vz_strings.logs_enabled);

        TestCase.assertEquals("Localytics of " + vz_strings.logs_location_services + " does not exist", 1, localyticsHelper.getCountOf(logs, "attr" + " = " + "\"" + vz_strings.logs_location_services + "\""));

        TestCase.assertEquals("Localytics of " + vz_strings.logs_enabled + " does not exist", 1, localyticsHelper.getCountOf(logs, "value" + " = " + vz_strings.logs_enabled));
    }
}
