package com.verizon.appiumtests.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Tools_BusinessLogin extends BaseTestClass {
	@Test
	public void testTBusinessAndResidentialLogin() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		homeScreenView.navigateTo(vz_strings.navi_settings);
		baseControlsHelper.clickOn(vz_strings.navi_tools);
		softAssert.assertTrue(baseControlsHelper.getCountById(vz_strings.tools_signIn) != 0,
				"'Business or Residential Sign In' option is not seen");

		baseControlsHelper.clickOn(vz_strings.tools_signIn);

		baseControlsHelper.waitForShow("Verizon.SAMLWebViewLogin");

		softAssert.assertTrue(baseControlsHelper.getCountById("Verizon.SAMLWebViewLogin") != 0,
				"SAML WebView login Page is not loaded");

		baseControlsHelper.tapOnBackButton();

		softAssert.assertTrue(baseControlsHelper.getCountById(vz_strings.tools_signIn) != 0,
				"Not directed to Tools Page");

		softAssert.assertAll();
	}
}