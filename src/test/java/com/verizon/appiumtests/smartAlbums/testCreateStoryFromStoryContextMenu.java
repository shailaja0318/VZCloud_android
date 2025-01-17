package com.verizon.appiumtests.smartAlbums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class testCreateStoryFromStoryContextMenu extends  BaseTestClass {
    @Test
    public void testCreateStoryFromStoryContextMenu () throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        photosAndVideosView.openStory10();
        baseControlsHelper.waitForContent();
        baseControlsHelper.clickOn(vz_strings.context_menu);
        baseControlsHelper.clickOn(vz_strings.context_select);
        baseControlsHelper.waitForContent();
        baseControlsHelper.clickOnLabelLike(vz_strings.name_photo);
        baseControlsHelper.openContext(vz_strings.context_createStory);
        baseControlsHelper.waitForShow(vz_strings.button_saveIt);
        baseControlsHelper.clickOn(vz_strings.button_saveIt);
        baseControlsHelper.waitForShow(vz_strings.button_save);
        baseControlsHelper.clickOn(vz_strings.button_save);
        //baseControlsHelper.clickOn(vz_strings.button_ok);
        TestCase.assertTrue("test story not found", baseControlsHelper.getCountByNameContains("Renamed Story") > 0);
        baseControlsHelper.tapOnBackButton();
    }



}
