//https://jira.synchronoss.net:8443/jira/browse/IV-2442
package com.verizon.appiumtests.photosandvideos.fuji;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class PhotosDetailView extends BaseTestClass {

    @Test
    public void testPhotosDetailView() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        gridView.tapItem(vz_strings.DataType.PHOTO);
        baseControlsHelper.waitForShow(vz_strings.context_menu);
        baseControlsHelper.clickOn(vz_strings.context_menu);
        baseControlsHelper.waitForShow(vz_strings.context_printAndGifts);
        baseControlsHelper.clickOn(vz_strings.context_printAndGifts);
        Thread.sleep(3000);
        //baseControlsHelper.clickOnElementByXpath(vz_strings.button_exit);
        baseControlsHelper.clickOnElementByXpath(vz_strings.button_exit);
        baseControlsHelper.clickOn(vz_strings.button_yes);
        baseControlsHelper.tapOnBackButton();
        baseControlsHelper.waitForShow(vz_strings.tab_all);
        TestCase.assertTrue("Photos and Videos screen missing ", baseControlsHelper.getCountByClassName("XCUIElementTypeCell") > 0);
    }
}

