/**
e * https://jira.synchronoss.net:8443/jira/browse/IV-274
 * We are verifying some steps i.e size ,date & time in sort test cases.
 * */
package com.verizon.appiumtests.documents;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class Documents extends BaseTestClass {

    @Test
    public void testDocuments() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_documents);
        baseControlsHelper.waitForShow("DOCUMENTS: TableView");

        TestCase.assertTrue("Documents tab is not found ",
                baseControlsHelper.getCountById(vz_strings.group_documents) != 0);
    }
}
