package com.verizon.appiumtests.localytics.fuji;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;
/**  VZNFT-233 Localytics: tag event - Cloud Print Shop Entry - Photo Video Detail 
 *  */

public class LocalyticsPhotosVideosAllDetailViewPrintShopIcon extends BaseTestClass{
  @Test
  public void testLocalyticsPhotosVideosAllDetailViewPrintShopIcon() throws Exception {
	  homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
      photosAndVideosView.selectTab(vz_strings.tab_all);
      baseControlsHelper.clickOnNameLike(vz_strings.name_photo);
      baseControlsHelper.clickOn(vz_strings.context_icon_printShop);
      
      String logs = localyticsHelper.getLogs();
      localyticsHelper.print(logs, vz_strings.logs_photoBucketEntry);
      
      TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketEntry + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_photoBucketEntry));
      TestCase.assertEquals("Localytics of " + vz_strings.logs_photoBucketEntry + " is not 1 in logs", 1, localyticsHelper.getCountOf(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_photoBucketEntry));
      TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketEntryPoint + " does not exist", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_photoBucketEntryPoint + "\" = \"" + vz_strings.logs_photosVideosDetail + "\""));
      TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketNumber + " does not exist", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_photoBucketNumber + "\" = 1"));     
  }
}


