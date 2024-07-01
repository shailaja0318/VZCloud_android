//IV-4275 step 3 - part 5/5
package com.verizon.appiumtests.photosandvideos.real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class EditPhotosFullScreenDetailViewAlbums extends BaseTestClass {

    @Test
    public void testEditPhotosFullScreenDetailViewAlbums() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        precondition.createAlbum();
        photosAndVideosView.openAlbum();
        baseControlsHelper.waitForContent();
        gridView.tapItem(vz_strings.DataType.PHOTO);
        baseControlsHelper.clickOn(vz_strings.context_menu);
        baseControlsHelper.clickOnElementByXpath(vz_strings.actionBar_EditPhoto);
        baseControlsHelper.waitForShowByPredicate("Edit Photo", "XCUIElementTypeNavigationBar");
        String pageTitle = baseControlsHelper.getNameByIndexfromClassName(0, "XCUIElementTypeNavigationBar");
        TestCase.assertEquals("Edit Photo view is not open", "Edit Photo", pageTitle);
    }
}
