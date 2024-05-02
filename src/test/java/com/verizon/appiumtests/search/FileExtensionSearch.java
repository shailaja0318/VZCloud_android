package com.verizon.appiumtests.search;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class FileExtensionSearch extends BaseTestClass {

    @Test
    public void testFileExtensionSearch() throws Exception {


        homeScreenView.navigateTo(vz_strings.navi_allFiles);

        boolean isEmpty = true;
        String[] ext = {".mp3", ".jpg", ".doc"};
        int i = 0;

        while (isEmpty) {
            allFilesView.search(ext[i]);
            if (baseControlsHelper.getCountById(vz_strings.allFiles_TableView) != 0 &&
                    baseControlsHelper.getCountById(vz_strings.emptyText_AllFiles) == 0) {
                isEmpty = false;
                break;
            }
            baseControlsHelper.clickOn(vz_strings.clear_text);
            i++;
        }
        TestCase.assertFalse("No Results", isEmpty);
    }
}
