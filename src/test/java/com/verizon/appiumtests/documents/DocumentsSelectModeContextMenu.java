/**
 * https://jira.synchronoss.net:8443/jira/browse/IV-277
 * Its is duplicate but using different steps no harm in keeping this test case.
 * */
package com.verizon.appiumtests.documents;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class DocumentsSelectModeContextMenu extends BaseTestClass {

    private void preCondition() throws Exception {
        System.out.println("--Start Preconditions--");
        if (baseControlsHelper.getCountById(vz_strings.group_favorites) != 0) {
            precondition.removeAllFavorites(vz_strings.DataType.DOCUMENT);
        }
        System.out.println("--End Preconditions--");
    }

    @Test
    public void testDocumentsSelectModeContextMenu() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_documents);
        //preCondition();
        precondition.removeAllFavorites(vz_strings.DataType.DOCUMENT);
        listView.selectFirstItem10();
        baseControlsHelper.openContext(null);

        TestCase.assertTrue("Options missing ", contextualMenu.verifyOptions(vz_strings.DataType.DOCUMENT,
                vz_strings.view_documents, false));
    }
}