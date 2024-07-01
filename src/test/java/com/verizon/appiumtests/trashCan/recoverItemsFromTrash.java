package com.verizon.appiumtests.trashCan;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.constants.vz_strings.DataType;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class recoverItemsFromTrash extends BaseTestClass {
  @Test
  public void f() throws Exception {
	  homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
      photosAndVideosView.selectTab(vz_strings.tab_albums);
      precondition.deleteAllAlbums();
      baseControlsHelper.waitForShow(vz_strings.button_newAlbum);
      photosAndVideosView.createAlbumWithMultipleItems(vz_strings.create_newAlbumName);
      baseControlsHelper.tapOnBackButton();
      photosAndVideosView.openAlbum();
      int count = gridView.getAlbumContentCount();
      System.out.println(count);
      gridView.tapItemInSelectMode(DataType.PHOTO);
      baseControlsHelper.del_moveToTrash();
      baseControlsHelper.waitForContent();
      int count1 = gridView.getAlbumContentCount();
      if(count1==count-1) {
    	  System.out.println("Moved an item to trash can");
      }
      baseControlsHelper.tapOnBackButton();
      recoveItemFromTrash();
      homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
      photosAndVideosView.selectTab(vz_strings.tab_albums);
      photosAndVideosView.openAlbum();
      int count2 = gridView.getAlbumContentCount();
      
      if (count2==count1) {
          TestCase.assertEquals("Photo is not revovered back to ALbums from Trashcan, before count: " + count + ", after recover count:" + count2, count2, count);
      } else {
          TestCase.assertTrue("Album still empty", gridView.getAlbumContentCount() != 0);
      }
      
  }
  
  public void recoveItemFromTrash() throws Exception {
	  homeScreenView.navigateTo(vz_strings.navi_trash);
	  Thread.sleep(2000);
      gridView.tapItemInSelectMode(DataType.PHOTO);
      baseControlsHelper.openContext(vz_strings.context_recoverItems);
      baseControlsHelper.waitForShow(vz_strings.alert_recoverItems);
      baseControlsHelper.clickOn(vz_strings.button_recover);
      Thread.sleep(2000);
  }
}
