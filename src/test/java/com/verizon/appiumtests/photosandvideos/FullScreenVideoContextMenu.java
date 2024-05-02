package com.verizon.appiumtests.photosandvideos;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;
//IV-297
public class FullScreenVideoContextMenu extends BaseTestClass {

    @Test
    public void testFullScreenVideoContextMenu() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        baseControlsHelper.clickOnNameLike(vz_strings.name_video);
        baseControlsHelper.openContext(null);

        TestCase.assertTrue("Options missing ", contextualMenu.verifyOptions(vz_strings.DataType.VIDEO,
                vz_strings.view_videoFull, false));
    }
}
