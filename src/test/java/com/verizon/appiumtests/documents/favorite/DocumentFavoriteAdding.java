//IV-2184 - Part1
package com.verizon.appiumtests.documents.favorite;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class DocumentFavoriteAdding extends BaseTestClass {

    private void preCondition() throws Exception {

        System.out.println("--Start Preconditions--");
        if (baseControlsHelper.getCountById(vz_strings.group_favorites) != 0) {
            precondition.removeAllFavorites(vz_strings.DataType.DOCUMENT);
        }
        System.out.println("--End Preconditions--");
    }

    @Test
    public void testDocumentFavoriteAdding() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_documents);
        preCondition();
        baseControlsHelper.openContext(vz_strings.context_select);
        listView.selectFirstItem10();
        baseControlsHelper.openContext(vz_strings.context_addFavorite);
        baseControlsHelper.waitForShow(vz_strings.group_favorites);
        TestCase.assertTrue("Missing Favorites group",
                baseControlsHelper.getCountById(vz_strings.group_favorites) != 0);
    }
}

