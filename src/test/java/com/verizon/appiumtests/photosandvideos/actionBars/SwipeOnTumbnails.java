package com.verizon.appiumtests.photosandvideos.actionBars;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;
/**
 * IV-291
 * @author leletsn
 *
 */
public class SwipeOnTumbnails extends BaseTestClass {
  @Test
  public void testSwipeOnTumbnails() throws Exception {
	  homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
      photosAndVideosView.selectTab(vz_strings.tab_all);
      baseControlsHelper.clickOnElementByXpath("Photo");
      TestCase.assertTrue("Add to Album option is not present in Action Bar",
              baseControlsHelper.getCountById(vz_strings.actionBar_AddToAlbum) != 0);
      TestCase.assertTrue("Share option is not present in Action Bar", baseControlsHelper.getCountById(vz_strings.actionBar_share) != 0);
      TestCase.assertTrue("Download option is not present in Action Bar", baseControlsHelper.getCountById(vz_strings.actionBar_download) != 0);
     
      baseControlsHelper.swipe("left");
      TestCase.assertTrue("Share option is not present in Action Bar", baseControlsHelper.getCountById(vz_strings.actionBar_share) != 0);
      TestCase.assertTrue("Download option is not present in Action Bar", baseControlsHelper.getCountById(vz_strings.actionBar_download) != 0);

  }
}
