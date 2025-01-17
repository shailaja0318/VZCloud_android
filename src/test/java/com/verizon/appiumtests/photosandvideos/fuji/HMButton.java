//https://jira.synchronoss.net:8443/jira/browse/IV-2455
package com.verizon.appiumtests.photosandvideos.fuji;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class HMButton extends BaseTestClass {

    @Test
    public void testHMButton() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        baseControlsHelper.waitForShow(vz_strings.context_menu);
        baseControlsHelper.clickOn(vz_strings.context_menu);
        baseControlsHelper.waitForShow(vz_strings.context_printAndGifts);
        baseControlsHelper.clickOn(vz_strings.context_printAndGifts);
        Thread.sleep(3000);
        //baseControlsHelper.clickOnElementByXpath(vz_strings.button_exit);
        baseControlsHelper.clickOnElementByXpath(vz_strings.button_exit_1);
        baseControlsHelper.clickOn(vz_strings.button_yes);
        baseControlsHelper.clickOn(vz_strings.navi_back);
        baseControlsHelper.clickOn(vz_strings.navi_home);
        TestCase.assertTrue("We not back to HM ",
                baseControlsHelper.isVisible(vz_strings.navi_home));
    }
