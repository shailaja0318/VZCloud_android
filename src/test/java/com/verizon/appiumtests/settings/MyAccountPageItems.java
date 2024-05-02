//https://jira.synchronoss.net:8443/jira/browse/IV-4758
package com.verizon.appiumtests.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class MyAccountPageItems extends BaseTestClass {
    @Test
    public void myAccountPageItems() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_settings);
        baseControlsHelper.clickOn(vz_strings.my_Account);

        TestCase.assertTrue("My Profile missing ", baseControlsHelper.getCountById(vz_strings.settings_My_Profile) != 0);
        TestCase.assertTrue("Complete not found ", baseControlsHelper.getCountById(vz_strings.settings_complete) != 0);
        TestCase.assertTrue("Delete my account not found ", baseControlsHelper.getCountById(vz_strings.delete_My_Account) != 0);
    }
}
