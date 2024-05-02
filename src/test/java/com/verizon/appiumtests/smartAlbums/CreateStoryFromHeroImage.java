//IV-1144
package com.verizon.appiumtests.smartAlbums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class CreateStoryFromHeroImage extends BaseTestClass {

    @Test
    public void testCreateStoryFromHeroImage() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        precondition.createAlbum();
        photosAndVideosView.openAlbum();
        baseControlsHelper.waitForContent();
        baseControlsHelper.clickOn(vz_strings.story_HeroImage);
        baseControlsHelper.waitForDismiss(vz_strings.text_preparingStory);
        baseControlsHelper.waitForShow(vz_strings.button_saveIt);
        for(int i=0;i<vz_strings.realPlayerSave.length;i++) {
            TestCase.assertTrue(vz_strings.realPlayerSave[i] + " is not found.",
                    baseControlsHelper.getCountById(vz_strings.realPlayerSave[i]) > 0);
        }
    }
}
