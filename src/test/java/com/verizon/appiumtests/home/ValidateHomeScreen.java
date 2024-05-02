package com.verizon.appiumtests.home;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ValidateHomeScreen extends BaseTestClass {
	@Test
	public void testValidateHomeScreen() throws Exception {
		homeScreenView.navigateTo(vz_strings.navi_home);

		SoftAssert softAssert = new SoftAssert(); 

		// Bottom Navigation Bar
		
		softAssert.assertTrue(baseControlsHelper.getCountByClassChain(vz_strings.navi_ClassChain_home)!=0, "Home label is not present in the Homescreen bottom navigation bar");
		softAssert.assertTrue(baseControlsHelper.getCountByClassChain(vz_strings.navi_ClassChain_search)!=0, "Search label is not present in the Homescreen bottom navigation bar");
		softAssert.assertTrue(baseControlsHelper.getCountByClassChain(vz_strings.navi_ClassChain_library)!=0, "Library label is not present in the Homescreen bottom navigation bar");
		softAssert.assertTrue(baseControlsHelper.getCountByClassChain(vz_strings.navi_ClassChain_more)!=0, "More label is not present in the Homescreen bottom navigation bar");
		
	
		softAssert.assertTrue(baseControlsHelper.getCountByNameContains(vz_strings.home_recentLabel)!=0, "Recent label is not present in the Homescreen");
		softAssert.assertTrue(baseControlsHelper.getCountByNameContains(vz_strings.home_flashBacksAndStoriestLabel)!=0, " FlashBacks And Stories Label is not present in the Homescreen");
		
		//Top Navigation Bar
		
		softAssert.assertTrue(baseControlsHelper.getCountByNameContains(vz_strings.navi_settings)!=0, " Settings is not present in the Homescreen");
		softAssert.assertTrue(baseControlsHelper.getCountByNameContains(vz_strings.navi_messageCenter)!=0, " Message Center is not present in the Homescreen");

		
		softAssert.assertAll();


	}
}
