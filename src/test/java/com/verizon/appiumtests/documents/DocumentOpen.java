/**
 * https://jira.synchronoss.net:8443/jira/browse/IV-278
 * */
package com.verizon.appiumtests.documents;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class DocumentOpen extends BaseTestClass {

    @Test
    public void testDocumentOpen() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_documents);
        listView.selectItem10("docx");
        //listView.selectItem10("pdf");

        TestCase.assertTrue("Document is not open",
                baseControlsHelper.getCountByClassName("XCUIElementTypeScrollView") != 0);
    }
}