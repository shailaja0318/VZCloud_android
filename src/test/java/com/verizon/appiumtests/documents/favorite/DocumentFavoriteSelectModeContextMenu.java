/**
 * https://jira.synchronoss.net:8443/jira/browse/IV-277
 * Its duplicate but makes sure we are adding and removing fav and testing it.
 * */
package com.verizon.appiumtests.documents.favorite;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class DocumentFavoriteSelectModeContextMenu extends BaseTestClass {

    private void preCondition() throws Exception {

        System.out.println("--Start Preconditions--");
        if (baseControlsHelper.getCountById(vz_strings.group_favorites) == 0) {
            baseControlsHelper.openContext(vz_strings.context_select);
            listView.selectFirstItem10();
            baseControlsHelper.openContext(vz_strings.context_addFavorite);
        }
        System.out.println("--End Preconditions--");
    }

    @Test
    public void testDocumentFavoriteSelectModeContextMenu() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_documents);
        preCondition();

        baseControlsHelper.openContext(vz_strings.context_select);
        listView.selectFirstItem10();
        baseControlsHelper.openContext(null);

        TestCase.assertTrue("Options missing ", contextualMenu.verifyOptions(vz_strings.DataType.DOCUMENT, vz_strings.view_documentsFavorite, false));
    }
}
