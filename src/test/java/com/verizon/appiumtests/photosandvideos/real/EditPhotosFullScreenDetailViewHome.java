//IV-4275 step 3 - part 1/5
package com.verizon.appiumtests.photosandvideos.real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class EditPhotosFullScreenDetailViewHome extends BaseTestClass {

    @Test
    public void testEditPhotosFullScreenDetailViewHome() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_home);
        baseControlsHelper.waitForShow(vz_strings.home_photsAndVideos);
        homeScreenView.fromHomeClickAt("PhotosGridCell 2");
        baseControlsHelper.waitForShow(vz_strings.actionBar_EditPhoto);
        baseControlsHelper.clickOn(vz_strings.actionBar_EditPhoto);
        baseControlsHelper.waitForShowByPredicate("Edit Photo", "XCUIElementTypeNavigationBar");
        String pageTitle = baseControlsHelper.getNameByIndexfromClassName(0, "XCUIElementTypeNavigationBar");
        TestCase.assertTrue("Edit Photo view is not open", pageTitle.equals("Edit Photo"));
    }
}
