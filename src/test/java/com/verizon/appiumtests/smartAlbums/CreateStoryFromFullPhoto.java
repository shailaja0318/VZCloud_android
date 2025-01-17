//IV-118
package com.verizon.appiumtests.smartAlbums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class CreateStoryFromFullPhoto extends BaseTestClass {

    @Test
    public void testCreateStoryFromFullPhoto() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        gridView.tapItem(vz_strings.DataType.PHOTO);
        baseControlsHelper.waitForShow(vz_strings.context_menu);
        baseControlsHelper.clickOn(vz_strings.context_menu);
        baseControlsHelper.waitForShow(vz_strings.context_createStory);
        baseControlsHelper.clickOn(vz_strings.context_createStory);
        baseControlsHelper.waitForShow("Edit scenes");

        for (int i = 0; i < vz_strings.realPlayerSave.length; i++) {
            TestCase.assertTrue(vz_strings.realPlayerSave[i] + " is not found.",
                    baseControlsHelper.getCountById(vz_strings.realPlayerSave[i]) != 0);
        }
    }
}
