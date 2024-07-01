package com.verizon.appiumtests.localytics.Real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;
/**
 * @author leletsn
 *VZNFT-559 #6  SavedStoryDownload
 */

public class ABSavedStoryDownload extends BaseTestClass {

    @Test
    public void testABSavedStoryDownload() throws Exception {

    	homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
		photosAndVideosView.selectTab(vz_strings.tab_all);
		baseControlsHelper.clickOnNameLike(vz_strings.name_savedStory);
		baseControlsHelper.clickOn(vz_strings.actionBar_download);
        baseControlsHelper.waitForDismiss("Progress");

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_mediaDownload);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaDownload + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_mediaDownload));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaDownload + " is not 1 in logs", localyticsHelper.getCountOf(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaDownload)>0);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_count + "  is not in logs", localyticsHelper.getPatternMatch(logs, vz_strings.logs_count + " = 1")>0);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaType + " does not exist", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_mediaType + "\" = " + vz_strings.logs_mediaTypeStory));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_source + " does not exits", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_source + " = \"" + vz_strings.logs_storyDetail + "\""));
		TestCase.assertTrue("Localytics of "+vz_strings.logs_target+" does not exits", localyticsHelper.getPatternMatch(logs, vz_strings.logs_target +" = \""+ vz_strings.logs_NotApplicable+"\"")>0);	  

    }
}
