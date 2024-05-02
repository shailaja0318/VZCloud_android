package com.verizon.appiumtests.photosandvideos.filter;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import org.testng.annotations.Test;

public class SortByDateTaken extends BaseTestClass{
  @Test
  public void testSortByDateTaken() throws Exception {
	  homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
      photosAndVideosView.selectTab(vz_strings.tab_all);
      photosAndVideosView.sortBy10(vz_strings.sort_dateTaken);
      
  }
}
