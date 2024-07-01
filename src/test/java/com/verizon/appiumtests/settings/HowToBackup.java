package com.verizon.appiumtests.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HowToBackup extends BaseTestClass{
	@Test
	public void testHowToBackup() throws Exception {
		homeScreenView.navigateTo(vz_strings.navi_settings);
		baseControlsHelper.clickOn(vz_strings.settings_whatToBackUp);
		TestCase.assertTrue(baseControlsHelper.isVisible(vz_strings.settings_HowToBackUp_Wifi_Mobile_accessibility));
		TestCase.assertTrue(baseControlsHelper.isVisible(vz_strings.settings_HowToBackUp_Wifi_accessibility));

	}
}
