package com.verizon.appiumtests.deeplinks;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import com.verizon.appiumtests.driver.BaseDriver;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class NewTest extends BaseTestClass {
  @Test
  public void f() throws Exception {
	  BaseDriver.terminateApp(vz_strings.BundleIds.VZ_ID);
      nativeIosAppsView.generateSMS(vz_strings.Deeplinks.MANAGE_STORAGE);
      baseControlsHelper.clickOnNameContains(vz_strings.Deeplinks.MANAGE_STORAGE);
      baseControlsHelper.clickOnType("XCUIElementTypeLink");
      baseControlsHelper.waitForShow(vz_strings.button_open);
      baseControlsHelper.clickOn(vz_strings.button_open);
      TestCase.assertTrue("Not taken to My Account page", baseControlsHelper.getCountByNameContains(vz_strings.my_Account)!=0);
      BaseDriver.terminateApp(vz_strings.BundleIds.APL_SMS);
  }
}
