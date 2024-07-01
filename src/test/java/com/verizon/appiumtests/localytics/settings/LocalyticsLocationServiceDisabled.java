//https://jira.synchronoss.net:8443/jira/browse/VZNFT-351 #Step 2 & 3
package com.verizon.appiumtests.localytics.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import com.verizon.appiumtests.driver.BaseDriver;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

/**
 * Created by ssam0003 on 18/09/18.
 */
public class LocalyticsLocationServiceDisabled extends BaseTestClass {
    private final static Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void testLocalyticsLocationServiceDisabled() throws Exception {
        try {
            if (nativeIosAppsView.isLocationServiceEnabled() != 0) nativeIosAppsView.toggleLocationServices("off");
            else logger.info("Location services already in disabled state");
           // BaseDriver.getDriver().launchApp();
            BaseDriver.launchApp();
            BaseDriver.runAppInBackground(5);
            String logs = localyticsHelper.getLogs();
            localyticsHelper.print(logs, "attr" + " = " + "\"" + vz_strings.logs_location_services + "\"");
            localyticsHelper.print(logs, "value" + " = " + vz_strings.logs_disbled);
            TestCase.assertEquals("Localytics of " + vz_strings.logs_location_services + " does not exist", 1, localyticsHelper.getPatternMatch(logs, "attr" + " = " + "\"" + vz_strings.logs_location_services + "\""));
            TestCase.assertEquals("Localytics of " + vz_strings.logs_disbled + " does not exist", 1, localyticsHelper.getPatternMatch(logs, "value" + " = " + vz_strings.logs_disbled));
        } finally {
          //  BaseDriver.getDriver().terminateApp(vz_strings.BundleIds.VZ_ID);
            BaseDriver.terminateApp(vz_strings.BundleIds.VZ_ID);
            if (nativeIosAppsView.isLocationServiceEnabled() != 1) nativeIosAppsView.toggleLocationServices("On");
        }
    }
}
