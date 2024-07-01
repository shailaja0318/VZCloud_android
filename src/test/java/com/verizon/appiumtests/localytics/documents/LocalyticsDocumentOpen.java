//VZNFT-3 #Step 2,3 //VZNFT-109 Step2
package com.verizon.appiumtests.localytics.documents;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsDocumentOpen extends BaseTestClass {

    @Test
    public void testLocalyticsDocumentOpen() throws Exception {

    	homeScreenView.navigateTo(vz_strings.navi_documents);
        listView.selectFirstItem10();

        String logs = localyticsHelper.getLogs();
        System.out.println(logs);
        localyticsHelper.print(logs, vz_strings.logs_mediaOpen);

        TestCase.assertEquals("Localytics of " + vz_strings.logs_mediaOpen + " is not in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaOpen));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_mediaType + " is not in logs", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + vz_strings.logs_mediaTypeDocument));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_page + " is not in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_page + " = " + "\"" + vz_strings.logs_allDocuments + "\""));
    }
}
