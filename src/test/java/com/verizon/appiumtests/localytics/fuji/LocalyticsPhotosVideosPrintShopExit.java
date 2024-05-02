package com.verizon.appiumtests.localytics.fuji;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;
/** 
 * @author leletsn
 */

public class LocalyticsPhotosVideosPrintShopExit extends BaseTestClass {
  @Test
  public void testLocalyticsPhotosVideosPrintShopExit() throws Exception {
      homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
      photosAndVideosView.selectTab(vz_strings.tab_all);
      photosAndVideosView.accessPrintShopFromIcon();
      baseControlsHelper.clickOn(vz_strings.button_exit);
      baseControlsHelper.clickOn(vz_strings.button_yes);
        
      String logs = localyticsHelper.getLogs();
      localyticsHelper.print(logs, vz_strings.logs_photoBucketExit);
      
      TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketExit + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_photoBucketExit));
      TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketExit + " is not 1 in logs", localyticsHelper.getCountOf(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_photoBucketExit) == 1);
      TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketEntryPoint + " does not exist", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_photoBucketEntryPoint + "\" = \"" + vz_strings.logs_photosVideosAll + "\""));
      TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketExitMethod + " does not exist", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_photoBucketExitMethod + "\" = \"" + vz_strings.logs_photoBucketCancelButton + "\""));
      TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketItemsPurchased + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_photoBucketItemsPurchased));
      TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketPickupLocation + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_photoBucketPickupLocation));
      TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketPromoCodeUsed + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_photoBucketPromoCodeUsed));
  }
}
