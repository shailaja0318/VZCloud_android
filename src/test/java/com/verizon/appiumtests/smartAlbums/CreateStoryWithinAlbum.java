//IV-142
package com.verizon.appiumtests.smartAlbums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class CreateStoryWithinAlbum extends BaseTestClass {

    private void preCondition_Album() throws Exception {
        System.out.println("--Start Preconditions--");
        if (!photosAndVideosView.ifAnyAlbumExists()) {
            photosAndVideosView.createAlbumWithMultipleItems(vz_strings.create_newAlbumName);
        }
        System.out.println("--End Preconditions--");
    }

    private void preCondition_Photos() throws Exception {
        System.out.println("--Start Preconditions--");
        if (baseControlsHelper.getCountById(vz_strings.empty_albumTitle) != 0) {
            photosAndVideosView.addItemsFromAlbum();
        }
        System.out.println("--End Preconditions--");
    }

    @Test
    public void testCreateStoryWithinAlbum() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        preCondition_Album();
        photosAndVideosView.openAlbum();
        preCondition_Photos();
        gridView.clickAllElements();
        baseControlsHelper.openContext(vz_strings.context_createStory);
        baseControlsHelper.waitForShow("Edit scenes");

        for (int i = 0; i < vz_strings.realPlayerSave.length; i++) {
            TestCase.assertTrue(vz_strings.realPlayerSave[i] + " is not found.",
                    baseControlsHelper.getCountById(vz_strings.realPlayerSave[i]) != 0);
        }
    }
}
