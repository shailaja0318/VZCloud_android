//IV-69, IV-236
package com.verizon.appiumtests.allFiles;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class AllFilesFolderSelectModeContextMenu extends BaseTestClass {

    @Test
    public void testAllFilesFolderSelectModeContextMenu() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_allFiles);
        String[] names = {"Mobile", "Tablet", "Web"};

        for (String name : names)
            if (baseControlsHelper.getCountById(name) > 0) {
                baseControlsHelper.clickOn(name);
                listView.selectFirstItem10();
                if(baseControlsHelper.getCountByNameContains("section - 0 ") > 0)
                    break;
            }
        baseControlsHelper.openContext(vz_strings.context_select);
        listView.selectFirstItem10();
        baseControlsHelper.openContext(null);

        TestCase.assertTrue("Options missing ", contextualMenu.verifyOptions(vz_strings.DataType.AllFiles, vz_strings.view_allFiles, false));

    }
}
