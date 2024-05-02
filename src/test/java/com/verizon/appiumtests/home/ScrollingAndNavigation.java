package com.verizon.appiumtests.home;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;

public class ScrollingAndNavigation extends BaseTestClass {

  //  @Test //need to update
    public void testScrollingAndNavigation() throws Exception{

        homeScreenView.navigateTo(vz_strings.navi_home);
        baseControlsHelper.setOrientation(ScreenOrientation.LANDSCAPE);
        baseControlsHelper.clickOn(vz_strings.navi_icon);
        baseControlsHelper.scroll(vz_strings.navi_Photosandvideos, "down");
        baseControlsHelper.clickOn(vz_strings.navi_trash);
        baseControlsHelper.clickOn(vz_strings.navi_icon);
        baseControlsHelper.scroll(vz_strings.navi_Photosandvideos, "down");
        TestCase.assertTrue("Trash not present ",
                baseControlsHelper.getCountById(vz_strings.navi_trash) > 0);
        baseControlsHelper.setOrientation(ScreenOrientation.PORTRAIT);
    }
}
