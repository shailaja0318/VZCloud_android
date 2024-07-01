package com.verizon.appiumtests.localytics.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/** 
 * @author leletsn
 */
public class LocalyticsSettingsManageStorageView extends BaseTestClass {
  @Test
  public void testLocalyticsSettingsManageStorageVie() throws Exception {
	  homeScreenView.navigateTo(vz_strings.navi_settings);
	  baseControlsHelper.clickOnNameContainsAndVisibile(vz_strings.settings_manageStorage);
	  
	  String logs = localyticsHelper.getLogs();
	  localyticsHelper.print(logs, vz_strings.logs_ManageStorage);

      TestCase.assertEquals("Localytics of " + vz_strings.settings_manageStorage + " is not 1 in logs", 1, localyticsHelper.getCountOf(logs, vz_strings.logs_tagEvent + ": " + "Storage Upgrade Step"));

      TestCase.assertEquals("Localytics of " + vz_strings.logs_settingsView
              + " is not 1 in logs", 1, localyticsHelper.getCountOf(logs, vz_strings.logs_step
              + " = " + "\"" + vz_strings.logs_settingsView + "\""));
  }
}
