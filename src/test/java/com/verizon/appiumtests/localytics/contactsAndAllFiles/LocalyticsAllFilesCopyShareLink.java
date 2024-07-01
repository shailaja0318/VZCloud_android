package com.verizon.appiumtests.localytics.contactsAndAllFiles;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;
/**
 * 
 * @author leletsn
 * VZNFT-57 All Files - tagEvent: Share Send Content
 *
 */

public class LocalyticsAllFilesCopyShareLink extends BaseTestClass { 

	    @Test
	    public void testLocalyticsAllFilesCopyShareLink() throws Exception {

	        homeScreenView.navigateTo(vz_strings.navi_allFiles);

	        String[] ext = {".HEIC", ".PNG", ".JPG"};

	        for (int i = 0; i <= ext.length; i++) {
				allFilesView.search(ext[i]);
	            if (baseControlsHelper.getCountById(vz_strings.emptyText_AllFiles) > 0) {
	                baseControlsHelper.clickOn(vz_strings.clear_text);
	            } else
	                break;
	        }

			listView.selectNumberOfItems(3);
            baseControlsHelper.openContext(vz_strings.context_copyShareLink);
	        baseControlsHelper.clickOn(vz_strings.button_yesRemindMeNextTime);
	        baseControlsHelper.waitForDismiss(vz_strings.toast_shareLinkCopied);

	        String logs = localyticsHelper.getLogs();
	        localyticsHelper.print(logs, vz_strings.LOGS_SHARE_SEND_CONTENT);

	        TestCase.assertTrue("Localytics of " + vz_strings.LOGS_SHARE_SEND_CONTENT + " is not 1 in logs", localyticsHelper.isExisted(logs, vz_strings.logs_tagEvent + ": " + vz_strings.LOGS_SHARE_SEND_CONTENT));
	        TestCase.assertTrue("Localytics of " + vz_strings.logs_shareContentSize + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_shareContentSize));
	        TestCase.assertTrue("Localytics of " + vz_strings.logs_shareContentType + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_shareContentType));
	        TestCase.assertTrue("Localytics of " + vz_strings.logs_shareItemShared + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_shareItemShared));

	        TestCase.assertTrue("Localytics of " + vz_strings.LOGS_SHARE_SEND + " is not 1 in logs", localyticsHelper.isExisted(logs, vz_strings.logs_tagEvent + ": " + vz_strings.LOGS_SHARE_SEND));
            TestCase.assertEquals("Localytics of " + vz_strings.LOGS_SUCCESSFUL + " is not 1 in logs", 1, localyticsHelper.getCountOf(logs, vz_strings.LOGS_STATUS + " = " + vz_strings.LOGS_SUCCESSFUL));
	    }
}
