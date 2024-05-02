package com.verizon.appiumtests.photosandvideos.filter;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

@Test
public class SortByDateUploaded extends BaseTestClass{
  public void testSortByDateUploaded() throws Exception {
	  homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
	  photosAndVideosView.selectTab(vz_strings.tab_all);
	  photosAndVideosView.sortBy10(vz_strings.sort_dateUploaded);
	  baseControlsHelper.openContext(vz_strings.context_sortAndFilter);
	  
	  //TestCase.assertTrue("Date Uploaded is not selected ", baseControlsHelper.getCountByName(vz_strings.filter_singleSelction)==0);
	//TestCase.assertEquals("double", "Date Uploaded", baseControlsHelper.getTextFromCell(vz_strings.filter_singleSelction));
	 TestCase.assertTrue("Date Uploaded is not selected ", baseControlsHelper.isSelected(vz_strings.sort_dateUploaded));
	//TestCase.assertTrue("Date Uploaded is not selected ", baseControlsHelper.getListByLabelContainsAndType10(vz_strings.sort_dateUploaded));
  }
}
