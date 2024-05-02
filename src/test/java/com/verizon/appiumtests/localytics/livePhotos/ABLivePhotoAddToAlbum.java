package com.verizon.appiumtests.localytics.livePhotos;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;
/**
 * @author leletsn
 *VZNFT-560 #3 Add To Album
 */
public class ABLivePhotoAddToAlbum extends BaseTestClass{
  @Test   
  public void testABLivePhotoAddToAlbum() throws Exception {

		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_all);
		baseControlsHelper.clickOnLabelLike(vz_strings.name_livePhoto);
		baseControlsHelper.clickOn(vz_strings.actionBar_AddToAlbum);

		String logs = localyticsHelper.getLogs();
		localyticsHelper.print(logs, vz_strings.logs_albumItemAdded );
		TestCase.assertTrue("Localytics of "+vz_strings.logs_tagEvent+" is not 1 in logs", localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent +": "+ vz_strings.logs_albumItemAdded )==1);
		TestCase.assertTrue("Localytics of "+vz_strings.logs_source+" does not exits", localyticsHelper.getPatternMatch(logs, vz_strings.logs_source +" = \"" + vz_strings.logs_photoDetail+ "\"")==1);
		TestCase.assertTrue("Localytics of "+vz_strings.logs_target+" does not exits", localyticsHelper.getPatternMatch(logs, vz_strings.logs_target +" = \""+ vz_strings.logs_NotApplicable+"\"")>0);	  


  }
}
