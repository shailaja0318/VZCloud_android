//IV-70
package com.verizon.appiumtests.allFiles;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class AllFilesFolderContextMenu extends BaseTestClass {

    @Test
    public void testAllFilesFolderContextMenu() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_allFiles);
        String[] names = {"Mobile", "Tablet", "Web"};

        for (String name : names)
            if (baseControlsHelper.getCountById(name) > 0) {
                baseControlsHelper.clickOn(name);
                break;
            }
        baseControlsHelper.openContext(null);

        TestCase.assertTrue("Options missing ", contextualMenu.verifyOptions(null, vz_strings.view_allFiles, false));
    }
}
