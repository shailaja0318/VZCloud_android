package com.verizon.appiumtests.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class RecommendedApps extends BaseTestClass {

	@Test
	public void testAppsUsingCloud() throws Exception {
		homeScreenView.navigateTo(vz_strings.navi_settings);
		baseControlsHelper.clickOn(vz_strings.navi_appsUsingCloud);
		baseControlsHelper.waitForShow(vz_strings.navi_recommendedApps);
		baseControlsHelper.clickOn(vz_strings.navi_recommendedApps);
		baseControlsHelper
				.waitForShow("Explore the recommended apps below and discover new ways to use the Verizon Cloud.");
		TestCase.assertTrue("Additional Apps... ", baseControlsHelper.getCountById(
				"Explore the recommended apps below and discover new ways to use the Verizon Cloud.") > 0);

	}
}
