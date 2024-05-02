//IV-830
package com.verizon.appiumtests.allFiles;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class AddingFavoritesFromAllFilesMD extends BaseTestClass {

    @Test
    public void testAddingFavoritesFromAllFilesMD() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_allFiles);
        String[] ext = {".doc", ".mp3"};

        for (String i : ext) {
            allFilesView.search(i);
            listView.selectFirstItemInSelectMode10();
            baseControlsHelper.openContext(null);

            if (baseControlsHelper.getCountById(vz_strings.context_removeFavorite) > 0) {
                baseControlsHelper.clickOn(vz_strings.context_removeFavorite);
                listView.selectFirstItemInSelectMode10();
                baseControlsHelper.openContext(null);
            }
            baseControlsHelper.clickOn(vz_strings.context_addFavorite);
            allFilesView.search("");
            baseControlsHelper.clickOn(vz_strings.clear_text);
            allFilesView.search(i);
            TestCase.assertTrue("Favorite * not found", baseControlsHelper.getCountById("favorite") > 0);
            baseControlsHelper.clickOn(vz_strings.button_cancel);
        }

    }

}
