package com.verizon.appiumtests.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
/**
 *  IV-2989
 * @author leletsn
 */
public class Tools_MergeContent extends BaseTestClass{
	@Test
	public void testTotalsMergeContent() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		homeScreenView.navigateTo(vz_strings.navi_settings);
		baseControlsHelper.clickOn(vz_strings.navi_tools);
		softAssert.assertTrue(baseControlsHelper.getCountById(vz_strings.tools_merge)!=0, "Merge Cloud Content option is not seen");
		
		baseControlsHelper.clickOn(vz_strings.tools_merge);
		
		softAssert.assertTrue(baseControlsHelper.getCountById("Merge Content")!=0, "Merge Content Screen is not seen");
		softAssert.assertTrue(baseControlsHelper.getTextById(vz_strings.tools_MergeContent_MergeAccountText).contains(vz_strings.tools_MergeContent_MergeAccountText), "Merge Content text is not displayed as Expected");
	//	softAssert.assertTrue(baseControlsHelper.getCountByNameContains(vz_strings.tools_MergeContent_CurrentlySignedInText)!=0, "Currently Signed MDN text is not displayed as Expected");
	//	softAssert.assertTrue(baseControlsHelper.getTextById(vz_strings.tools_MergeContent_OtherAccountLoginText).contains(vz_strings.tools_MergeContent_OtherAccountLoginText), "Other Account login text is not displayed as Expected");
		
		baseControlsHelper.clickOn(vz_strings.tools_LogIntoOtherCloudAccount);
		baseControlsHelper.waitForShow("Verizon.SAMLWebViewLogin");
		
		softAssert.assertTrue(baseControlsHelper.getCountById("Verizon.SAMLWebViewLogin")!=0, "SAML WebView login Page is not loaded");
		
		baseControlsHelper.tapOnBackButton();
		
		softAssert.assertTrue(baseControlsHelper.getCountById("Merge Content")!=0, "Merge Content Screen is not seen");
		
		baseControlsHelper.tapOnBackButton();
		
		softAssert.assertTrue(baseControlsHelper.getCountById(vz_strings.tools_merge)!=0, "Not directed to Tools Page");
        softAssert.assertAll();
    }
	}