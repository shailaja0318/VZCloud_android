package com.verizon.appiumtests.deeplinks;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import com.verizon.appiumtests.driver.BaseDriver;
import junit.framework.TestCase;
import org.testng.annotations.Test;
/**
 * @author leletsn
 * This deeplink is sent end of 30 day trial period
 */
public class DeeplinkSMS_EndOFTrial extends BaseTestClass {
  @Test
  public void test() throws Exception {
	  BaseDriver.terminateApp(vz_strings.BundleIds.VZ_ID);
      nativeIosAppsView.generateSMS(vz_strings.Deeplinks.ENDOFTrial);
      baseControlsHelper.clickOnNameContains(vz_strings.Deeplinks.ENDOFTrial);
      baseControlsHelper.clickOnType(vz_strings.XCUITypes.XCUI_LINK);
      baseControlsHelper.waitForShow(vz_strings.button_open);
      baseControlsHelper.clickOn(vz_strings.button_open);
      TestCase.assertTrue("Not taken to My Account page", baseControlsHelper.getCountByNameContains(vz_strings.my_Account)!=0);
  }
}
