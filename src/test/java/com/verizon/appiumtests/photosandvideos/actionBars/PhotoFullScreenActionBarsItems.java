package com.verizon.appiumtests.photosandvideos.actionBars;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;
//IV-296
public class PhotoFullScreenActionBarsItems extends BaseTestClass {
  @Test
  public void testPhotoFullScreenActionBarsItems() throws Exception {
	  homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
      photosAndVideosView.selectTab(vz_strings.tab_all);
      baseControlsHelper.clickOnElementByXpath(vz_strings.name_photo);
      
      TestCase.assertTrue("Share option is not present in Action Bar", baseControlsHelper.getCountById(vz_strings.actionBar_share) != 0);
      TestCase.assertTrue("Edit Photo option is not present in Action Bar", baseControlsHelper.getCountById(vz_strings.actionBar_Favorite) != 0);
      TestCase.assertTrue("Download option is not present in Action Bar",
              baseControlsHelper.getCountById(vz_strings.actionBar_download) != 0);
      TestCase.assertTrue("Add to Album option is not present in Action Bar",
              baseControlsHelper.getCountById(vz_strings.actionBar_AddToAlbum) != 0);
      TestCase.assertTrue("Delete option is not present in Action Bar", baseControlsHelper.getCountById(vz_strings.actionBar_Delete) != 0);

  }
}
