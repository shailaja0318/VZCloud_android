package com.verizon.appiumtests.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class Settings extends BaseTestClass {

	@Test
	public void testSettings() throws Exception {

		homeScreenView.navigateTo(vz_strings.navi_settings);
		TestCase.assertTrue(baseControlsHelper.getCountByXpath(vz_strings.settings_editProfile) != 0);

		TestCase.assertTrue("What to Back Up missing? ",
				baseControlsHelper.getCountByXpath(vz_strings.navi_connectedApps) != 0);
		TestCase.assertTrue("Manage Storage missing? ",

				baseControlsHelper.getCountByXpath(vz_strings.settings_tagAndSeacrh) != 0);
		TestCase.assertTrue("How to Back Up missing? ",
				baseControlsHelper.getCountByXpath(vz_strings.setting_uploadSettings) != 0);
	}
}
