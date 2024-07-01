package com.verizon.appiumtests.localytics;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * @author leletsn
 *VZNFT-557 #2 Edit Photo
 */
public class ABEditPhoto extends BaseTestClass{
	@Test
	public void testABEditPhotosFullScreenDetailViewPVAll() throws Exception{

		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_all);
		baseControlsHelper.clickOnLabelLike(vz_strings.name_photo);
		baseControlsHelper.openContext(vz_strings.context_editPhoto);

		String logs = localyticsHelper.getLogs();
		localyticsHelper.print(logs, vz_strings.logs_editPhotos);
        TestCase.assertEquals("Localytics of " + vz_strings.logs_tagEvent + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_editPhotos));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_source + " does not exits", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_source + " = \"" + vz_strings.logs_photoDetailMenu + "\""));
		TestCase.assertTrue("Localytics of "+vz_strings.logs_target+" does not exits", localyticsHelper.getPatternMatch(logs, vz_strings.logs_target +" = \""+ vz_strings.logs_editPhoto+"\"")>0);	  

	}
}
