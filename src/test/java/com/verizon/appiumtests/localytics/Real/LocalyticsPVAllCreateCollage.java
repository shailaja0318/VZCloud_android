package com.verizon.appiumtests.localytics.Real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;
/**
 * VZNFT-480: Edit Photos-Create Collage
 * @author leletsn
 */
public class LocalyticsPVAllCreateCollage extends BaseTestClass {
  @Test
  public void testLocalyticsPVAllCreateCollage() throws Exception {
	  homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
	  photosAndVideosView.selectTab(vz_strings.tab_all);
      baseControlsHelper.openContext(vz_strings.context_select);
	  gridView.tapMultiplePhotoItems(3);
	  baseControlsHelper.openContext(vz_strings.context_createcollage);
	  
	  String logs = localyticsHelper.getLogs();
	  localyticsHelper.print(logs, vz_strings.logs_editPhotos);
      TestCase.assertEquals("Localytics of " + vz_strings.logs_tagEvent + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_editPhotos));
      TestCase.assertEquals("Localytics of " + vz_strings.logs_source + " does not exits", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_source + " = \"" + vz_strings.logs_photoMultiSelectMenu + "\""));
      TestCase.assertEquals("Localytics of " + vz_strings.logs_target + " does not exits", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_target + " = " + vz_strings.logs_collage));
  }
}