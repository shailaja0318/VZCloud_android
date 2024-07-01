//IV-4818
package com.verizon.appiumtests.photosandvideos;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

import static com.verizon.appiumtests.constants.vz_strings.tab_all;

public class DefaultNavPV extends BaseTestClass {

    @Test
    public void testDefaultNavPV() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
       // homeScreenView.fromHomeClickAt(vz_strings.home_photsAndVideos);
        homeScreenView.navigateTo(tab_all);
        TestCase.assertTrue("Are we not at PV All tab?", (baseControlsHelper.isSelected(tab_all)));

        homeScreenView.navigateTo(vz_strings.navi_home);
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        TestCase.assertTrue("Are we not at PV All tab?", (baseControlsHelper.isSelected(tab_all)));

    }
}
