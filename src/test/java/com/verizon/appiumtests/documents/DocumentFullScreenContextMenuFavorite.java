/**
 * https://jira.synchronoss.net:8443/jira/browse/IV-276 - Part 2
 * */
package com.verizon.appiumtests.documents;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class DocumentFullScreenContextMenuFavorite extends BaseTestClass {

    private void pre_Condition() throws Exception {

        System.out.println("--Start Preconditions--");
        if (baseControlsHelper.getCountById(vz_strings.group_favorites) == 0) {
            baseControlsHelper.openContext(vz_strings.context_select);
            listView.selectFirstItem10();
            baseControlsHelper.openContext(vz_strings.context_addFavorite);
        }
        System.out.println("--End Preconditions--");
    }

    @Test
    public void testDocumentFullScreenContextMenu() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_documents);
        pre_Condition();
        listView.selectItem10("section - 0, row - 0");
        baseControlsHelper.waitForShow(vz_strings.context_menu);
        baseControlsHelper.openContext(null);

        TestCase.assertTrue("Options missing ", contextualMenu.verifyOptions(vz_strings.DataType.DOCUMENT,
                vz_strings.view_documentsFavorite, false));
    }
}