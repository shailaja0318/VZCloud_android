package com.verizon.appiumtests.home;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import org.testng.annotations.Test;

public class BackFromFullPhoto extends BaseTestClass {

    @Test
    public void testBackFromFullPhoto() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_home);
        baseControlsHelper.clickOn(vz_strings.recent_file+2);
        Thread.sleep(2000);

    }

}