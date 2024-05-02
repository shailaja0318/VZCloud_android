package com.verizon.appiumtests.localytics.livePhotos;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * @author leletsn
 *VZNFT-560 #2 Edit Photo
 */
public class ABEditLivePhoto extends BaseTestClass{
	@Test
	public void testABEditLivePhotosFullScreenDetailViewPVAll() throws Exception{

		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_all);
		baseControlsHelper.clickOnLabelLike(vz_strings.name_livePhoto);
		baseControlsHelper.openContext(vz_strings.context_editPhoto);

		String logs = localyticsHelper.getLogs();
		localyticsHelper.print(logs, vz_strings.logs_editPhotos);
		TestCase.assertTrue("Localytics of "+vz_strings.logs_tagEvent+" is not 1 in logs", localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent +": "+ vz_strings.logs_editPhotos)==1);
		TestCase.assertTrue("Localytics of "+vz_strings.logs_source+" does not exits", localyticsHelper.getPatternMatch(logs, vz_strings.logs_source +" = \"" + vz_strings.logs_photoDetailMenu+ "\"")==1);
		TestCase.assertTrue("Localytics of "+vz_strings.logs_target+" does not exits", localyticsHelper.getPatternMatch(logs, vz_strings.logs_target +" = \""+ vz_strings.logs_editPhoto+"\"")>0);	  

	}
}
