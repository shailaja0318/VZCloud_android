package com.verizon.appiumtests.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class Settings extends BaseTestClass {

	@Test
	public void testSettings() throws Exception {

		homeScreenView.navigateTo(vz_strings.navi_settings);

		TestCase.assertTrue("What to Back Up missing? ",
				baseControlsHelper.getCountById(vz_strings.settings_whatToBackUp) != 0);
		TestCase.assertTrue("How to Back Up missing? ",
				baseControlsHelper.getCountById(vz_strings.settings_HowToBackUp) != 0);
		TestCase.assertTrue("Email Address missing? ", baseControlsHelper.getCountById(vz_strings.my_Account) != 0);
		TestCase.assertTrue("Manage Storage missing? ",
				baseControlsHelper.getCountById(vz_strings.settings_manageStorage) != 0);
		TestCase.assertTrue("Notification Manager missing? ",
				baseControlsHelper.getCountById(vz_strings.settings_NotificationManager) != 0);
		TestCase.assertTrue("Apps Using Cloud missing? ",
				baseControlsHelper.getCountById(vz_strings.settings_appsUsingCloud) != 0);
		TestCase.assertTrue("TagAndSeacrh missing? ",
				baseControlsHelper.getCountById(vz_strings.settings_tagAndSeacrh) != 0);
		TestCase.assertTrue("Tools missing? ", baseControlsHelper.getCountById(vz_strings.navi_tools) != 0);
		TestCase.assertTrue("About missing? ", baseControlsHelper.getCountById(vz_strings.settings_about) != 0);
	}
}
