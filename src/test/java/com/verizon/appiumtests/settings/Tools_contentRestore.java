package com.verizon.appiumtests.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Tools_contentRestore extends BaseTestClass {
	@Test
	public void test_Tools_contentRestore() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		homeScreenView.navigateTo(vz_strings.navi__more);
		baseControlsHelper.waitForShow(vz_strings.more_accountContentTools);
		baseControlsHelper.clickOn(vz_strings.more_accountContentTools);
		baseControlsHelper.waitForShow(vz_strings.navi_contentTransfer);
		baseControlsHelper.clickOn(vz_strings.navi_contentTransfer);
		softAssert.assertTrue(baseControlsHelper.getCountById(vz_strings.tools_restore) != 0,
				" Content Restore option is not seen");

		baseControlsHelper.clickOn(vz_strings.tools_restore);

		softAssert.assertTrue(baseControlsHelper.getCountById("Select media to restore") != 0,
				"'Select media to restore' incorrect verbaige");
		softAssert.assertTrue(baseControlsHelper.getCountById("Selected content size") != 0,
				"'Selected content size' incorrect verbaige");
		softAssert.assertTrue(baseControlsHelper.getCountByNameContains("Photos") != 0,
				"'Photos' switch is not present");
		softAssert.assertTrue(baseControlsHelper.getCountByNameContains("Videos") != 0,
				"'Videos' switch is not present");
		softAssert.assertTrue(baseControlsHelper.getCountByNameContains("Select the network") != 0,
				"'Select the network' verbaige not present");
		softAssert.assertTrue(baseControlsHelper.getCountById(vz_strings.settings_HowToBackUp_Wifi) != 0,
				"'Wi-Fi Only' opyion is not present");
		softAssert.assertTrue(baseControlsHelper.getCountById(vz_strings.settings_Wifi_Mobile) != 0,
				"'Wifi and cellular Data usage may apply' option is not present");
		softAssert.assertTrue(baseControlsHelper.getCountByNameContains(vz_strings.button_cancel) != 0,
				"Cancel button is not present");
		softAssert.assertTrue(baseControlsHelper.getCountByNameContains(vz_strings.button_restore) != 0,
				"'Restore button verbaige not present");
		softAssert.assertAll();
	}
}
