package com.verizon.appiumtests.localytics.fuji;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * VZNFT-240 Localytics: tag event - Cloud Print Shop Entry - Photo Video All
 */

public class LocalyticsPhotosVideosAllMultiSelectPrintShop extends BaseTestClass{
  @Test
  public void testVZNFT240PhotosVideosAllMultiSelectPrintShop() throws Exception {
	  homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
      photosAndVideosView.selectTab(vz_strings.tab_all);
      gridView.tapItemsInMultiSelectModeUniversal(3, vz_strings.DataType.PHOTO);
      baseControlsHelper.openContext(vz_strings.context_icon_printShop);

      String logs = localyticsHelper.getLogs();
      localyticsHelper.print(logs, vz_strings.logs_photoBucketEntry);
      TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketEntry + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_photoBucketEntry));
      TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketEntry + " is not 1 in logs", localyticsHelper.getCountOf(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_photoBucketEntry) == 1);
      TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketEntryPoint + " does not exist", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_photoBucketEntryPoint + "\" = \"" + vz_strings.logs_photosVideosAll + "\""));
      TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketNumber + " does not exist", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_photoBucketNumber + "\" = 3")); 
  }
}

