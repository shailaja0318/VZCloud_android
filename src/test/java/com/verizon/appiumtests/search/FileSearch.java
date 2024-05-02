package com.verizon.appiumtests.search;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class FileSearch extends BaseTestClass {

    @Test
    public void testFileSearch() throws Exception {


        homeScreenView.navigateTo(vz_strings.navi_allFiles);
        allFilesView.search("a");

        TestCase.assertTrue("No Results", baseControlsHelper.getCountById(vz_strings.allFiles_TableView) != 0 &&
                baseControlsHelper.getCountById(vz_strings.emptyText_AllFiles) == 0);
    }
}
