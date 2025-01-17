package com.verizon.appiumtests.home;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import org.testng.annotations.Test;

public class Scroll_RecentFileList extends BaseTestClass{
  @Test
  public void test_ScrollRecentFilesListFromeHomeSCreen() throws Exception {
	  homeScreenView.navigateTo(vz_strings.navi_home);
	  baseControlsHelper.waitForShow(vz_strings.home_recentLabel);
	  baseControlsHelper.swipe( "left");
	  Thread.sleep(2000);
	  
  }
}
