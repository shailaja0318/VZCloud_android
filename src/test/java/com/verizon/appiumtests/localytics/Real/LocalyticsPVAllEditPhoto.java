package com.verizon.appiumtests.localytics.Real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;
/**
 * @author leletsn
 *  VZNFT-481: Edit Photos: Add Stickers/step 3: In a Full view
 */
public class LocalyticsPVAllEditPhoto extends BaseTestClass{
  @Test
  public void testLocalyticsPVAllEditPhoto() throws Exception {
	  homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
	  photosAndVideosView.selectTab(vz_strings.tab_all);
	  baseControlsHelper.clickOnNameLike(vz_strings.name_photo);
      baseControlsHelper.clickOn(vz_strings.actionBar_EditPhoto);
	  
	  String logs = localyticsHelper.getLogs();
	  localyticsHelper.print(logs, vz_strings.logs_editPhotos);
      TestCase.assertEquals("Localytics of " + vz_strings.logs_tagEvent + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_editPhotos));
      TestCase.assertEquals("Localytics of " + vz_strings.logs_source + " does not exist", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_source + " = \"" + vz_strings.logs_photoDetail + "\""));
	  TestCase.assertTrue("Localytics of "+vz_strings.logs_target+" does not exits", localyticsHelper.getPatternMatch(logs, vz_strings.logs_target +" = \""+ vz_strings.logs_NotApplicable+"\"")>0);
	  }
  }