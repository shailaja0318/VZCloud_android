//IV-4276 4/5
package com.verizon.appiumtests.photosandvideos.real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class CreateCollageMultiselectStory extends BaseTestClass {

    @Test
    public void testCreateCollageMultiselectStory() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        photosAndVideosView.openStory10();
        baseControlsHelper.waitForContent();
        baseControlsHelper.openContext(vz_strings.context_select);
        gridView.tapMultiplePhotoItems(2);
        baseControlsHelper.openContext(vz_strings.context_createcollage);
        baseControlsHelper.waitForShowByPredicate("Collage", "XCUIElementTypeNavigationBar");
        String pageTitle = baseControlsHelper.getNameByIndexfromClassName(0, "XCUIElementTypeNavigationBar");
        TestCase.assertEquals("Create Collage view is not open", "Collage", pageTitle);
    }
}
