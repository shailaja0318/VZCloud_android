/**
 * https://jira.synchronoss.net:8443/jira/browse/IV-276 - Part 1
 * */
package com.verizon.appiumtests.documents;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class DocumentFullScreenContextMenu extends BaseTestClass {

    private void preCondition() throws Exception {
        System.out.println("--Start Preconditions--");
        if (baseControlsHelper.getCountById(vz_strings.group_favorites) != 0) {
            precondition.removeAllFavorites(vz_strings.DataType.DOCUMENT);
        }
        System.out.println("--End Preconditions--");
    }

    @Test
    public void testDocumentFullScreenContextMenu() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_documents);
        preCondition();
        listView.selectItem10("section - 0, row - 0");
        baseControlsHelper.waitForShow(vz_strings.context_menu);
        baseControlsHelper.openContext(null);

        TestCase.assertTrue("Options missing ", contextualMenu.verifyOptions(vz_strings.DataType.DOCUMENT,
                vz_strings.view_documentFull, false));
    }
}