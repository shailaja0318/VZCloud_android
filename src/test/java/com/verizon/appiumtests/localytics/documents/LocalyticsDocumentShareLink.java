package com.verizon.appiumtests.localytics.documents;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsDocumentShareLink extends BaseTestClass {

    @Test
    public void testLocalyticsDocumentShareLink() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_documents);
        listView.selectFirstItemInSelectMode10();
        baseControlsHelper.openContext(vz_strings.context_share);      
		baseControlsHelper.clickOn(vz_strings.share_ShareTo);
		
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.LOGS_SHARE_SEND_CONTENT);
        TestCase.assertTrue("Localytics of " + vz_strings.LOGS_SHARE_SEND_CONTENT + " does not exist", localyticsHelper.isExisted(logs, vz_strings.LOGS_SHARE_SEND_CONTENT));
        TestCase.assertEquals("Localytics of " + vz_strings.LOGS_SHARE_SEND_CONTENT + " is not 1 in logs", 1, localyticsHelper.getCountOf(logs, vz_strings.logs_tagEvent + ": " + vz_strings.LOGS_SHARE_SEND_CONTENT));
    }
}