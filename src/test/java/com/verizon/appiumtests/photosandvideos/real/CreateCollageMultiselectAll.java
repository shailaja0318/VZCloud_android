//IV-4276 2/5
package com.verizon.appiumtests.photosandvideos.real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class CreateCollageMultiselectAll extends BaseTestClass {

    @Test
    public void testCreateCollageMultiselectAll() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        gridView.tapItemsInMultiSelectModeUniversal(3, vz_strings.DataType.PHOTO);
        baseControlsHelper.openContext(vz_strings.context_createcollage);
        baseControlsHelper.waitForShowByPredicate("Collage", "XCUIElementTypeNavigationBar");
        String pageTitle = baseControlsHelper.getNameByIndexfromClassName(0, "XCUIElementTypeNavigationBar");
        TestCase.assertEquals("Create Collage view is not open", "Collage", pageTitle);
    }
}
