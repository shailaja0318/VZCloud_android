package com.verizon.appiumtests.photosandvideos;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class FullScreenPhotoContextMenu extends BaseTestClass {
//IV-296
	
    @Test
    public void testFullScreenPhotoContextMenu() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        baseControlsHelper.clickOnLabelLike(vz_strings.name_photo);
        baseControlsHelper.openContext(null);

        TestCase.assertTrue("Options missing ",
                baseControlsHelper.isVisible(vz_strings.context_createStory) );
    }
}