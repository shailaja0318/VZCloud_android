package com.verizon.appiumtests.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NotificationManager extends BaseTestClass {
	@Test
	public void testNotificationManager() throws Exception {
		homeScreenView.navigateTo(vz_strings.navi_settings);
		baseControlsHelper.clickOnElementByXpath(vz_strings.settings_navi_notificationManager);

		TestCase.assertTrue(baseControlsHelper.getCountById(vz_strings.settings_NM_FlashBacks) != 0);

		TestCase.assertTrue(baseControlsHelper.getCountById(vz_strings.settings_NM_printsANdGifts) != 0);

		TestCase.assertTrue(baseControlsHelper.getCountById(vz_strings.settings_NM_Stories) != 0);



	}
}
