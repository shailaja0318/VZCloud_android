package com.verizon.appiumtests.photosandvideos;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;
/**  @author leletsn
 * IV-2626 Live Photos : Live Photos Detailed view in Photos & Videos section
 * pre-condition: Make sure you have Live Photos before running Scripts
 */
public class LivePhotoDetailView extends BaseTestClass {
  @Test
  public void testLivePhotoDetailView() throws Exception {
	  homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
	  photosAndVideosView.selectTab(vz_strings.tab_all);
	  baseControlsHelper.clickOnLabelLike(vz_strings.name_livePhoto);
	  TestCase.assertTrue("ImageView is not open", baseControlsHelper.getCountByClassName("XCUIElementTypeScrollView") != 0);
	  }
}

