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
        homeScreenView.navigateTo(vz_strings.navi_printshop);
        baseControlsHelper.waitForDismiss(vz_strings.spinner);
        if(baseControlsHelper.getCountById(vz_strings.button_acceptContinue) > 0)
            baseControlsHelper.clickOn(vz_strings.button_acceptContinue);
        String pageTitle = baseControlsHelper.getNameByIndexfromClassName(0, "XCUIElementTypeNavigationBar");
        TestCase.assertTrue("Fuji view is not open", pageTitle.equals("Prints & Gifts"));
    }
}
