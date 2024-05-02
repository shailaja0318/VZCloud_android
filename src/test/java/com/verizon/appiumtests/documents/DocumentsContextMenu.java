/**
 * https://jira.synchronoss.net:8443/jira/browse/IV-275
 * */
package com.verizon.appiumtests.documents;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class DocumentsContextMenu extends BaseTestClass {

    @Test
    public void testDocumentsContextMenu() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_documents);
        baseControlsHelper.openContext(null);

        TestCase.assertTrue("Options missing ", contextualMenu.verifyOptions(null,
                vz_strings.view_documents, false));
    }
}
