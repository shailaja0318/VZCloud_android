package com.verizon.appiumtests.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HowToBackup extends BaseTestClass{
	@Test
	public void testHowToBackup() throws Exception {
		homeScreenView.navigateTo(vz_strings.navi_settings);
		baseControlsHelper.clickOn(vz_strings.settings_HowToBackUp);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(baseControlsHelper.getCountByClassChain(vz_strings.settings_navi_HowToBackUp) != 0,
				"How To Backp is not shown in the Navigation Bar");
		softAssert.assertTrue(baseControlsHelper.getCountById(vz_strings.settings_HowToBackUp_Wifi) != 0,
				"'Wifi Only' option is not available");
		softAssert.assertTrue(baseControlsHelper.getCountById(vz_strings.settings_HowToBackUp_Wifi_Mobile) != 0,
				"'Wifi+Mobile Network' option is not available");
		softAssert.assertAll();
		
	}
}
