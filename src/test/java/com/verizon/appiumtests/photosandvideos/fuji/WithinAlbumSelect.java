//https://jira.synchronoss.net:8443/jira/browse/IV-2453
package com.verizon.appiumtests.photosandvideos.fuji;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import org.testng.annotations.Test;

public class WithinAlbumSelect extends BaseTestClass {

    @Test
    public void testWithinAlbumSelect() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        preCondition();
        baseControlsHelper.clickOnElementByXpath(vz_strings.photos_albumFolder);
        PreConditionData();
        gridView.tapItemInSelectModeByXpath(vz_strings.DataType.PHOTO);
        photosAndVideosView.clickPrintsAndGift(vz_strings.context_printAndGifts, vz_strings.context_createStory);
        baseControlsHelper.waitForDismiss(vz_strings.spinner);
        baseControlsHelper.clickOnElementByXpath(vz_strings.button_exit_1);
        baseControlsHelper.clickOn(vz_strings.button_yes);
        baseControlsHelper.tapOnBackButton();
        baseControlsHelper.tapOnBackButton();
        baseControlsHelper.waitForShow(vz_strings.tab_albums);
    }

    private void preCondition() throws Exception {
        System.out.println("--Start Preconditions--");
        if (!photosAndVideosView.ifAnyAlbumExists()) {
            photosAndVideosView.createAlbum(vz_strings.create_newAlbumName);
        }
        System.out.println("--End Preconditions--");
    }

    private void PreConditionData() throws Exception {
        System.out.println("--Start PreConditionData--");
        if (baseControlsHelper.getCountById(vz_strings.empty_albumTitle) > 0) {
            photosAndVideosView.addItemFromAlbum(vz_strings.DataType.PHOTO);
            baseControlsHelper.waitForShow(vz_strings.context_menu);
          //  baseControlsHelper.clickOn("Photos albums folder");
        }
        System.out.println("--End PreconditionData--");
    }
}
