///IV-4708 steps 1,2,3 part 5/5, 4
package com.verizon.appiumtests.photosandvideos.real;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class EditPhotosAlbumSelectSingle extends BaseTestClass {
    @Test
    public void testEditPhotosAlbumSelectSingle() throws Exception{

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        precondition.createAlbum();
        photosAndVideosView.openAlbum();
        baseControlsHelper.waitForContent();
        baseControlsHelper.openContext(vz_strings.context_select);
        gridView.tapItem(vz_strings.DataType.PHOTO);
        baseControlsHelper.openContext(vz_strings.context_editPhoto);
        String pageTitle = baseControlsHelper.getNameByIndexfromClassName(0, "XCUIElementTypeNavigationBar");
        TestCase.assertEquals("Edit photo view is not open", "Edit Photo", pageTitle);
    }
}
