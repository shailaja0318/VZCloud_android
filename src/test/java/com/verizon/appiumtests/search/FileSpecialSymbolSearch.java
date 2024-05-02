package com.verizon.appiumtests.search;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class FileSpecialSymbolSearch extends BaseTestClass {

    @Test
    public void testFileSpecialSymbolSearch() throws Exception {


        homeScreenView.navigateTo(vz_strings.navi_allFiles);

        boolean isEmpty = true;
        int i = 0;

        while (isEmpty) {
            allFilesView.search(vz_strings.special_char[i]);
            if (baseControlsHelper.getCountById(vz_strings.allFiles_TableView) != 0 &&
                    baseControlsHelper.getCountById(vz_strings.emptyText_AllFiles) == 0) {
                isEmpty = false;
                break;
            }
            i++;
            baseControlsHelper.clickOn(vz_strings.clear_text);
        }
        TestCase.assertFalse("No Results", isEmpty);
    }
}
