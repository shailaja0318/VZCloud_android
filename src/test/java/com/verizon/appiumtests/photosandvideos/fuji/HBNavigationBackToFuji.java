//IV-2463
package com.verizon.appiumtests.photosandvideos.fuji;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class HBNavigationBackToFuji extends BaseTestClass {

    @Test
    public void testHBNavigationBackToFuji() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        baseControlsHelper.waitForShow(vz_strings.context_menu);
        baseControlsHelper.clickOn(vz_strings.context_menu);
        baseControlsHelper.waitForShow(vz_strings.context_printAndGifts);
        baseControlsHelper.clickOn(vz_strings.context_printAndGifts);
        if(baseControlsHelper.getCountById(vz_strings.button_acceptContinue) > 0)
            baseControlsHelper.clickOn(vz_strings.button_acceptContinue);
        String pageTitle = baseControlsHelper.getNameByIndexfromClassName(0, "XCUIElementTypeNavigationBar");
        TestCase.assertEquals("Fuji view is not open", "Prints & Gifts", pageTitle);
    }
}
