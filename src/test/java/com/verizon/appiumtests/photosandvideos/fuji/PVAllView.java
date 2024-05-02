//https://jira.synchronoss.net:8443/jira/browse/VPCIOS-4273
package com.verizon.appiumtests.photosandvideos.fuji;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class PVAllView extends BaseTestClass {

    @Test
    public void testPVAllView() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        gridView.tapItemInSelectMode(vz_strings.DataType.PHOTO);
        photosAndVideosView.clickPrintsAndGift(vz_strings.context_printAndGifts, vz_strings.context_icon_printShop);
        baseControlsHelper.waitForDismiss(vz_strings.spinner);
        baseControlsHelper.clickOn(vz_strings.button_exit);
        baseControlsHelper.clickOn(vz_strings.button_yes);
        baseControlsHelper.waitForShow(vz_strings.tab_all);
        TestCase.assertTrue("Photos and Videos view missing ", baseControlsHelper.isVisible(vz_strings.view_photoAll));
    }
}
