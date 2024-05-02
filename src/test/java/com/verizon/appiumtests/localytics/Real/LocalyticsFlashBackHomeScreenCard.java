package com.verizon.appiumtests.localytics.Real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;

/**
 * 
 * @author leletsn
 * VZNFT-218 FlashBack-HomeScreenCard
 * PreCondition- Make Sure you have FlashBacks on your Device
 *
 */
public class LocalyticsFlashBackHomeScreenCard extends BaseTestClass {
  //@Test
  public void testVZNFT218LocalyticsFlashBackHomeScreenCard() throws Exception {
	  homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
	  homeScreenView.navigateTo(vz_strings.navi_home);
	  baseControlsHelper.waitForShow(vz_strings.carousel_flashbacks);
	  homeScreenView.clickOnStory(vz_strings.carousel_flashbacks);
	  
      String logs = localyticsHelper.getLogs();
      localyticsHelper.print(logs, vz_strings.logs_flashBackTab);

      TestCase.assertTrue("Localytics of " + vz_strings.logs_flashBackTab
              + " is not 1 in logs", localyticsHelper.getCountOf(logs, vz_strings.logs_tagEvent
              + ": " + vz_strings.logs_flashBackTab) == 1);

      TestCase.assertTrue("Localytics of " + vz_strings.logs_HomeScreenCard 
              + " is not 1 in logs", localyticsHelper.getCountOf(logs, vz_strings.logs_source
              + " = " + "\"" + vz_strings.logs_HomeScreenCard  + "\"") == 1);
	  
  }
}

