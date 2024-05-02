package com.verizon.appiumtests.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class About extends BaseTestClass {

    @Test
    public void testAbout() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_settings);
        baseControlsHelper.clickOn(vz_strings.settings_about);

        TestCase.assertTrue("Terms not found", baseControlsHelper.getCountById(vz_strings.about_terms) != 0);
        TestCase.assertTrue("Policy not found", baseControlsHelper.getCountById(vz_strings.about_policy) != 0);
        TestCase.assertTrue("Licenses not found", baseControlsHelper.getCountById(vz_strings.about_licenses) != 0);
        TestCase.assertTrue("App version not found", baseControlsHelper.getCountById(vz_strings.about_version) != 0);
    }
}
