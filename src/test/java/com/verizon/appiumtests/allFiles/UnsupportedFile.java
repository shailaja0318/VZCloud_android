//IV-68
package com.verizon.appiumtests.allFiles;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;

public class UnsupportedFile extends BaseTestClass {

//    @Test
    public void testUnsupportedFile() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_allFiles);

        Boolean noResults = true;
        int index = 0;
        String[] ext = {".rb", ".jnt", ".exe"};

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

        TestCase.assertTrue("Unsupported File Pop Up not found", baseControlsHelper.getCountByClassName(vz_strings.class_UIAAlert) != 0);
        TestCase.assertTrue("Pop up heading missing!", baseControlsHelper.getCountById("Unsupported File") != 0);
        TestCase.assertTrue("Pop up heading missing!", baseControlsHelper.getCountById("The selected file type is not supported on your device.") != 0);
    }
}
