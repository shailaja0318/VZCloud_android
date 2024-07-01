//IV-2111
package com.verizon.appiumtests.smartAlbums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class SavedSystemGeneratedStoryToAnAlbum extends BaseTestClass {

    private void preCondition_albums() throws Exception {


        System.out.println("--Start Preconditions fav--");
        if (photosAndVideosView.ifAnyAlbumExists()) {
            gridView.selectAllAlbums();
            baseControlsHelper.openContext(vz_strings.context_delete);
            baseControlsHelper.clickOn(vz_strings.button_yes);
        }
        System.out.println("--End Preconditions--");
    }

    @Test
    public void testSavedSystemGeneratedStoryToAnAlbum() throws Exception {


        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        preCondition_albums();
        baseControlsHelper.waitForShow(vz_strings.tab_stories);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        gridView.tapFolderInSelectMode10("Story-0");
        baseControlsHelper.openContext(vz_strings.context_saveAsAlbum);
        baseControlsHelper.waitForShow(vz_strings.toast_storySavesToAlbums);
        photosAndVideosView.selectTab(vz_strings.tab_albums);

        TestCase.assertTrue("No items", baseControlsHelper.elementIsVisible(vz_strings.photos_albumFolder));
    }
}