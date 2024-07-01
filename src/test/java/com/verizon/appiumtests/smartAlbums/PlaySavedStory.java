//IV-125
package com.verizon.appiumtests.smartAlbums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseControlsHelper;
import com.verizon.appiumtests.controls.BaseTestClass;
import org.testng.annotations.Test;

public class PlaySavedStory extends BaseTestClass {

    @Test
    public void testPlaySavedStory() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        baseControlsHelper.clickOn(vz_strings.tab_all);
        if (baseControlsHelper.getCountByNameLike("Saved Story") < 1) {
            preCond();
            homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
            baseControlsHelper.clickOn(vz_strings.tab_all);
        }
        baseControlsHelper.clickOnNameLike(vz_strings.name_savedStory);
        baseControlsHelper.waitForShowByTypeAndLabel("XCUIElementTypeButton", "Play");
        photosAndVideosView.playVideo();
    }

    public void preCond() throws Exception {
        createStory();
        uploadSavedStory();
    }

    public void createStory() throws Exception {
        baseControlsHelper.openContext(vz_strings.context_select);
        gridView.tapItem(vz_strings.DataType.PHOTO);
        baseControlsHelper.openContext(vz_strings.context_createStory);
        baseControlsHelper.waitForShow("Edit scenes");
        baseControlsHelper.clickOn(vz_strings.button_saveIt);
        baseControlsHelper.clearValueOnTextfieldByName("rpai_first_text_field");
        baseControlsHelper.setValuetoTextFieldByName("Temporary", "rpai_first_text_field");
        baseControlsHelper.clickOn(vz_strings.button_save);
        baseControlsHelper.waitForContent();
        baseControlsHelper.waitForDismiss(vz_strings.progressbar);
        baseControlsHelper.clickOn(vz_strings.navi_back);
    }

    public void uploadSavedStory() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_settings);
        baseControlsHelper.clickOn(vz_strings.settings_whatToBackUp);
        //if (baseControlsHelper.isSelectedByTypeAndName("XCUIElementTypeSwitch", "videosToggleButton"))
        //{
         //   baseControlsHelper.clickOnNameBeginswithAndType("videosToggleButton", "XCUIElementTypeSwitch");
        //}
        baseControlsHelper.tapOnBackButton();
        baseControlsHelper.clickOnElementByXpath(vz_strings.settings_closeBtn);
        homeScreenView.navigateTo(vz_strings.navi_home);
        baseControlsHelper.clickOn(vz_strings.button_backUp_icon);
       // baseControlsHelper.clickOn(vz_strings.navi_backUpNow);
        photosAndVideosView.checkDownload();
    }
}
