//https://jira.synchronoss.net:8443/jira/browse/VZNFT-125
package com.verizon.appiumtests.localytics;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class ShareSendContentInMultiSelectMode extends BaseTestClass {

    @Test
    public void testShareSendContentInMultiSelectMode() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        gridView.tapItemsInMultiSelectModeUniversal(2, vz_strings.DataType.PHOTO);

        baseControlsHelper.clickOn(vz_strings.actionBar_selectView_share);
		baseControlsHelper.clickOn(vz_strings.button_yesRemindMeNextTime);
		baseControlsHelper.clickOn(vz_strings.share_ShareTo);


		String logs = localyticsHelper.getLogs();
		localyticsHelper.print(logs, vz_strings.LOGS_SHARE_SEND_CONTENT);

		TestCase.assertTrue(vz_strings.LOGS_SHARE_SEND_CONTENT + " is not 1 in logs",
				localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.LOGS_SHARE_SEND_CONTENT) == 1);

		TestCase.assertTrue("Localytics of " + vz_strings.logs_shareContentSize + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_shareContentSize));
		TestCase.assertTrue("Localytics of " + vz_strings.logs_shareContentType + " does not exist", localyticsHelper.getCountOf(logs, "\"" + vz_strings.logs_shareContentType + "\"" + " = " + vz_strings.logs_mediaTypePhotos) == 1);
		TestCase.assertTrue("Localytics of " + vz_strings.logs_shareItemShared + " does not exist", localyticsHelper.getCountOf(logs, "\"" + vz_strings.logs_shareItemShared + "\"" + " = " + "2") == 1);
		TestCase.assertTrue("Localytics of "+vz_strings.logs_source+" does not exits", localyticsHelper.getPatternMatch(logs, vz_strings.logs_source +" = \"" + vz_strings.logs_NotApplicable+ "\"")==1);
		TestCase.assertTrue("Localytics of "+vz_strings.logs_target+" does not exits", localyticsHelper.getPatternMatch(logs, vz_strings.logs_target +" = \""+ vz_strings.logs_NotApplicable+"\"")>0);	  

    }
}
