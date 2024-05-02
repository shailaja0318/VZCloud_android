//VZNFT-2 #1
package com.verizon.appiumtests.localytics.documents;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsDocumentsAllHome extends BaseTestClass {
    @Test
    public void testLocalyticsDocumentsAll() throws Exception {
    	homeScreenView.navigateTo(vz_strings.navi_documents);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_allDocuments);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_allDocuments + " does not exist",
                localyticsHelper.isExisted(logs, vz_strings.logs_allDocuments));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_allDocuments + " is not 1 in logs",
                localyticsHelper.getCountOf(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_allDocuments) == 1);
    }
}