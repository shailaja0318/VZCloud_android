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
      baseControlsHelper.clickOnElementByXpath(vz_strings.name_photo);

      TestCase.assertTrue("Add to Album option is not present in Action Bar", baseControlsHelper.isVisible(vz_strings.actionBar_AddToAlbum) );
      TestCase.assertTrue("Share option is not present in Action Bar", baseControlsHelper.isVisible(vz_strings.actionBar_Delete));
      TestCase.assertTrue("Download option is not present in Action Bar", baseControlsHelper.isVisible(vz_strings.actionBar_download));
      TestCase.assertTrue("Share option is not present in Action Bar", baseControlsHelper.isVisible(vz_strings.actionBar_share));

  }
}
