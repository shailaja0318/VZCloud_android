package com.verizon.appiumtests.localytics.Real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;
/**
 * VZNFT-481: Edit Photos: Add Stickers/step 4: In Multi-Select Mode
 * @author leletsn
 */
public class LocalyticsPVAllEditPhotoInMultiSelectMode extends BaseTestClass{
  @Test
  public void testLocalyticsPVAllEditPhotoInMultiSelectMode() throws Exception {
	  homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
	  photosAndVideosView.selectTab(vz_strings.tab_all);
	  baseControlsHelper.openContext(vz_strings.context_select);
	  baseControlsHelper.clickOnNameLike(vz_strings.name_photo);
	  baseControlsHelper.openContext(vz_strings.context_editPhoto);
	  
	  String logs = localyticsHelper.getLogs();
	  localyticsHelper.print(logs, vz_strings.logs_editPhotos);
	  TestCase.assertTrue("Localytics of "+vz_strings.logs_tagEvent+" is not 1 in logs ", localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent +": "+ vz_strings.logs_editPhotos)==1);
	  TestCase.assertTrue("Localytics of "+vz_strings.logs_source+" does not exists", localyticsHelper.getPatternMatch(logs, vz_strings.logs_source +" = \"" +vz_strings.logs_photoMultiSelectMenu+ "\"")==1);
	  TestCase.assertTrue("Localytics of "+vz_strings.logs_target+" does not exists ", localyticsHelper.getPatternMatch(logs, vz_strings.logs_target +" = \""+vz_strings.logs_editPhoto+ "\"")==1);
  }
}
