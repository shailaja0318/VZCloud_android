package com.verizon.appiumtests.home;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ValidateFav_ViewAll extends BaseTestClass{
  @Test
  public void testValidateFav_ViewALL() throws Exception {
	  SoftAssert softAssert = new SoftAssert();
	  
	  homeScreenView.navigateTo(vz_strings.navi_home);
	  baseControlsHelper.waitForShow(vz_strings.home_favoritesLabel);
	  softAssert.assertTrue(baseControlsHelper.getCountById(vz_strings.home_fav_viewAll)!=0, "View all is not present in the Home Screen");
	  baseControlsHelper.clickOn(vz_strings.home_fav_viewAll);
	  softAssert.assertTrue(baseControlsHelper.getCountById(vz_strings.view_favorite)!=0, "Not taken to favorite Album Page");
	  baseControlsHelper.tapOnBackButton_PhotosAndVideos();
	  softAssert.assertTrue(baseControlsHelper.getCountById(vz_strings.view_photosAndVideos)!=0, "Back button from Favorites is not taken to Photos and Videos View");
	  softAssert.assertAll();
	  
  }
}
