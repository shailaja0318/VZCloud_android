/**
 * VZNFT-5
 * This test case needs to run 4 times. Why, As test case wont know what Picker wheel is already selected.(Obviously
 * you can get back value). But keeping the existing value and clicking ok  wont generate Localytics Tags.
 * So these series of TC will decide what value to select and assert on that basis.
 * */
package com.verizon.appiumtests.localytics.documents;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsDocumentSort3 extends BaseTestClass {

    @Test
    public void testLocalyticsDocumentSort3() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_documents);
        baseControlsHelper.openContext(vz_strings.context_sort);
        String currentPickerValue = baseControlsHelper.getTextByType("XCUIElementTypePickerWheel");
        String newPickerValue = documentsView.selectPickerAccordingly(currentPickerValue);
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_sortMedia);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_sortMedia + " is not 1 in logs",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_sortMedia) == 1);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaType + " is not 1 in logs",
                localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + vz_strings.logs_mediaTypeDocument) == 1);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_sortOption + " is not 1 in logs",
                localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_sortOption + "\"" + " = " + newPickerValue ) == 1);
    }
}
