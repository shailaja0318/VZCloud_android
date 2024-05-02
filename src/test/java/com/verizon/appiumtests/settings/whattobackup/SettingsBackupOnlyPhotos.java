package com.verizon.appiumtests.settings.whattobackup;


import com.verizon.appiumtests.constants.HelperUtilities;
import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import org.testng.annotations.Test;

public class SettingsBackupOnlyPhotos extends BaseTestClass {
	@Test
	public void testBackupPhotosTest() throws Exception {

		homeScreenView.navigateTo(vz_strings.navi_settings);
		Thread.sleep(3000);
		settingsView.setWhatToBackUp(HelperUtilities.setArguments("", vz_strings.settings_whatToBackUp_Photos));
		baseControlsHelper.clickOn(vz_strings.settings_BackButton);
		settingsView.setWhatNotToBackUp(HelperUtilities.setArguments(vz_strings.settings_whatToBackUp_Contacts,"", vz_strings.settings_whatToBackUp_Videos));

	}
}
