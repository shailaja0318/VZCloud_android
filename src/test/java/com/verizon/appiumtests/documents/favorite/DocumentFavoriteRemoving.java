//IV-2184 - Part 2
package com.verizon.appiumtests.documents.favorite;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class DocumentFavoriteRemoving extends BaseTestClass {

    private void preCondition() throws Exception {


        System.out.println("--Start Preconditions--");
        if (!listView.hasFavorites()) { // IF !FALSE == TRUE
            baseControlsHelper.openContext(vz_strings.context_select);
            listView.selectFirstItem10();
            baseControlsHelper.openContext(vz_strings.context_addFavorite);
            baseControlsHelper.waitForDismiss(vz_strings.toast_addtoFavorite);
            baseControlsHelper.waitForShow(vz_strings.group_favorites);
        }
        System.out.println("--End Preconditions--");
    }

    @Test
    public void testDocumentFavoriteRemoving() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_documents);
        preCondition();

        if (listView.hasFavorites())
            listView.removeAllFavorites();

        //Pass if hasFavoirates() returns false
        TestCase.assertFalse("Removing Favorites - Failed", listView.hasFavorites());
    }
}
