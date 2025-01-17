//IV-295
package com.verizon.appiumtests.photosandvideos;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.constants.vz_strings.DataType;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class AllPhotosVideosSelectContextMenu extends BaseTestClass {

    @Test
    public void testAllPhotosVideosSelectContextMenu() throws Exception {


        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        gridView.tapItemInSelectMode(vz_strings.DataType.PHOTO);
        baseControlsHelper.openContext(null);

        TestCase.assertTrue("Options missing ", baseControlsHelper.isVisible(vz_strings.context_editPhoto));
        TestCase.assertTrue("Options missing ", baseControlsHelper.isVisible(vz_strings.context_printAndGifts));
        TestCase.assertTrue("Options missing ", baseControlsHelper.isVisible(vz_strings.context_createStory));
        TestCase.assertTrue("Options missing ", baseControlsHelper.isVisible(vz_strings.context_addToPrintAlbum));
        TestCase.assertTrue("Options missing ", baseControlsHelper.isVisible(vz_strings.context_makePrivate));
    }
}
