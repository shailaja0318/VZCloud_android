//IV-67
package com.verizon.appiumtests.allFiles;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class AllFileOpenDocument extends BaseTestClass {

    @Test
    public void testAllFileOpenDocument() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_allFiles);

        boolean noResults = true;
        int index = 0;
        String[] ext = {".pdf", ".doc", ".docx", ".xls", ".xlsx"};

        while (noResults) {
            allFilesView.search(ext[index]);
            if (baseControlsHelper.getCountById(vz_strings.emptyText_AllFiles) != 0) {
                baseControlsHelper.clickOn(vz_strings.clear_text);
                index++;
            } else {
                noResults = false;
            }
        }
        listView.selectFirstItem10();
        baseControlsHelper.waitForDismiss(vz_strings.progressbar);
        TestCase.assertTrue("Document is not open", baseControlsHelper.getCountByClassName("XCUIElementTypeWebView") != 0);

    }
}
