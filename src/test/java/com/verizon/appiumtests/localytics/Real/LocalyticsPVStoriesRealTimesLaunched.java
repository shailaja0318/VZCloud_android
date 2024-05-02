package com.verizon.appiumtests.localytics.Real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;
/**
 * VZNFT-485 Tagged event: RealTimes Launched
 * @author leletsn
 */
public class LocalyticsPVStoriesRealTimesLaunched extends BaseTestClass{
	@Test
	public void testLocalyticsPVStoriesRealTimesLaunched() throws Exception {
		homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_stories);
		baseControlsHelper.clickOnLabelBeginswith("Story-0");
		baseControlsHelper.waitForShow(vz_strings.story_HeroImage);
		baseControlsHelper.clickOn(vz_strings.story_HeroImage);
	  
		String logs = localyticsHelper.getLogs();
		localyticsHelper.print(logs, vz_strings.logs_realtimeView);
		TestCase.assertTrue("Locaytics for "+vz_strings.logs_tagScreen+" is not 1 in logs", localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen +": "+ vz_strings.logs_realtimeView)==1);
		
		localyticsHelper.print(logs, vz_strings.logs_realtimesLaunched);
		TestCase.assertTrue("Localytics for "+ vz_strings.logs_tagEvent +" is not 1 in logs", localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent +": "+ vz_strings.logs_realtimesLaunched)==1);	  
  }
}
