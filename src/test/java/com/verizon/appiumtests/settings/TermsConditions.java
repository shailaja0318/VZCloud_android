package com.verizon.appiumtests.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class TermsConditions extends BaseTestClass {

    @Test
    public void testTermsConditions() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_settings);
        baseControlsHelper.clickOn(vz_strings.settings_about);
        baseControlsHelper.clickOn(vz_strings.about_tc);
        TestCase.assertTrue("Terms & Conditions headings not found", baseControlsHelper.getCountById(vz_strings.about_tc) != 0);

    }
}
