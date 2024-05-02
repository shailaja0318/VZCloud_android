package com.verizon.appiumtests.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TagAndSearch extends BaseTestClass {
	@Test
	public void testTagAndSearch() throws Exception {
		homeScreenView.navigateTo(vz_strings.navi_settings);
		baseControlsHelper.clickOn(vz_strings.settings_tagAndSeacrh);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(baseControlsHelper.getCountByClassChain(vz_strings.settings_Navi_TagAndSearch) != 0,
				"Tag and Search is not shown in the Navigation Bar");
		/*
		 * softAssert.assertTrue(baseControlsHelper.getCountByClassChain(vz_strings.
		 * settings_TS_Veribage1) != 0, "Incorrect Tag and Search veribage");
		 */
		softAssert.assertTrue(baseControlsHelper.getCountByClassChain(vz_strings.settings_TagAndSearchSwitchtext) != 0,
				"Tag and search switch text is incorrect");
		softAssert.assertTrue(baseControlsHelper.getCountByClassChain(vz_strings.settings_tagAndSearch_Switch) != 0,
				"Tag and search switch is not present");
		softAssert.assertTrue(baseControlsHelper.getCountByClassChain(vz_strings.settings_TS_veribage2) != 0,
				"'24hours scan time' Incorrect veribage");

		softAssert.assertAll();
	}
}
