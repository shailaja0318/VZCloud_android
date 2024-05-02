package com.verizon.appiumtests.photosandvideos.actionBars;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;
/**
 * IV-2431
 * @author leletsn
 *
 */
public class PhotoFullViewCreateNewAlbum extends BaseTestClass {
  @Test
  public void testPhotoFullViewCreateNewAlbum() throws Exception {
	  homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
      photosAndVideosView.selectTab(vz_strings.tab_albums);
      precondition.deleteAllAlbums();
      photosAndVideosView.selectTab(vz_strings.tab_all);
      baseControlsHelper.clickOnLabelLike(vz_strings.name_photo);
      baseControlsHelper.clickOn(vz_strings.actionBar_AddToAlbum);
      photosAndVideosView.createAlbumFromAllView(vz_strings.create_newAlbumName);
      baseControlsHelper.tapOnBackButton();
      photosAndVideosView.selectTab(vz_strings.tab_albums);
      baseControlsHelper.waitForContent();
      photosAndVideosView.openAlbum();

      int count1 = gridView.getAlbumContentCount();
      TestCase.assertTrue("PV count not increasing, before count: " + 1 + ", after count:" + count1, count1 == 1);

  }
}
