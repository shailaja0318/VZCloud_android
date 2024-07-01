package com.verizon.appiumtests.settings.whattobackup;

import com.verizon.appiumtests.constants.HelperUtilities;
import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import org.testng.annotations.Test;

public class WhatToBackup_videosOnly extends BaseTestClass {
	@Test
	public void testWhatToBackup_videosOnly() throws Exception {

		homeScreenView.navigateTo(vz_strings.navi_settings);
		baseControlsHelper.clickOnElementByXpath(vz_strings.setting_uploadSettings);
		Thread.sleep(3000);
		settingsView.setWhatToBackUp(HelperUtilities.setArguments("", "", vz_strings.settings_whatToBackUp_Videos));
		baseControlsHelper.clickOnElementByXpath(vz_strings.settings_BackButton);
		settingsView.setWhatNotToBackUp(HelperUtilities.setArguments
				("",vz_strings.settings_whatToBackUp_Contacts, vz_strings.settings_whatToBackUp_Photos, ""));

	}
}
