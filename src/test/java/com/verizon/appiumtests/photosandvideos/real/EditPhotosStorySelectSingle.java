///IV-4708 steps 1,2,3 part 4/5, 4
package com.verizon.appiumtests.photosandvideos.real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class EditPhotosStorySelectSingle extends BaseTestClass {
    @Test
    public void testEditPhotosStorySelectSingle() throws Exception{

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        photosAndVideosView.openStory10();
        baseControlsHelper.waitForContent();
        baseControlsHelper.openContext(vz_strings.context_select);
        gridView.tapItem(vz_strings.DataType.PHOTO);
        baseControlsHelper.openContext(vz_strings.context_editPhoto);
        baseControlsHelper.waitForShowByPredicate("Edit Photo", "XCUIElementTypeNavigationBar");
        String pageTitle = baseControlsHelper.getNameByIndexfromClassName(0, "XCUIElementTypeNavigationBar");
        TestCase.assertEquals("Edit photo view is not open", "Edit Photo", pageTitle);
    }
}
