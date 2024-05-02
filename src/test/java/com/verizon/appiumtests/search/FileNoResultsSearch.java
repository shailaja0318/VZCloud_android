package com.verizon.appiumtests.search;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class FileNoResultsSearch extends BaseTestClass {

    @Test
    public void testFileNoResultsSearch() throws Exception {


        homeScreenView.navigateTo(vz_strings.navi_allFiles);

        boolean isEmpty = true;
        String name = "azx";
        int i = 0;

        while (isEmpty) {
            allFilesView.search(name);
            if (baseControlsHelper.getCountById(vz_strings.emptyText_AllFiles) != 0 || i > 5) {
                isEmpty = false;
                break;
            }
            i++;
            name = name.concat("a");
        }
        TestCase.assertFalse("No Results", isEmpty);
    }
}
