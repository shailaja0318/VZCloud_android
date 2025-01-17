package com.verizon.appiumtests.photosandvideos.actionBars;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
/**
 * IV-2573
 * @author leletsn
 *
 */
public class StoryFromHomeScreenPhotoFullView_depricated extends BaseTestClass {

   // @Test
    public void testStoryFromHomeScreenPhotoFullView() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_home);
        homeScreenView.clickOnStory(vz_strings.carousel_story);
        baseControlsHelper.clickOnLabelLike(vz_strings.name_photo);
        TestCase.assertTrue("Add to Album option is not present in Action Bar", baseControlsHelper.isVisible(vz_strings.actionBar_AddToAlbum));
        TestCase.assertTrue("Share option is not present in Action Bar", baseControlsHelper.isVisible(vz_strings.actionBar_share));
        TestCase.assertTrue("Download option is not present in Action Bar", baseControlsHelper.isVisible(vz_strings.actionBar_download));
        backToStories();
        TestCase.assertTrue("", baseControlsHelper.getCountById(vz_strings.view_photoStories) > 0);
        TestCase.assertTrue("", baseControlsHelper.getCountByClassName("XCUIElementTypeCollectionView") > 0);
    }

    public void backToStories() throws Exception {
            baseControlsHelper.tapOnBackButton();
            baseControlsHelper.tapOnBackButton();
    }

}
