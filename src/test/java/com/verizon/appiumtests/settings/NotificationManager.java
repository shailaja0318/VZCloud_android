package com.verizon.appiumtests.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NotificationManager extends BaseTestClass {
	@Test
	public void testNotificationManager() throws Exception {
		homeScreenView.navigateTo(vz_strings.navi_settings);
		baseControlsHelper.clickOn(vz_strings.settings_NotificationManager);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(
				baseControlsHelper.getCountByClassChain(vz_strings.settings_navi_notificationManager) != 0,
				"Notification Manager is not shown in the Navigation Bar");
		softAssert.assertTrue(baseControlsHelper.getCountById(vz_strings.settings_NM_FlashBacks) != 0,
				"Flashback switch is not present");
		softAssert.assertTrue(baseControlsHelper.getCountById(vz_strings.settings_NM_printsANdGifts) != 0,
				"Prints AND Gifts switch is not present");
		softAssert.assertTrue(baseControlsHelper.getCountById(vz_strings.settings_NM_Stories) != 0,
				"Stories switch is not present");
		softAssert.assertAll();

	}
}
