package com.verizon.appiumtests.smartAlbums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class CreateStroyOptionShouldNotBeSeen extends BaseTestClass {

    @Test
    public void testCreateStroyOptionShouldNotBeSeen() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_allFiles);
        baseControlsHelper.clickOn(vz_strings.folder_mobile);
        Thread.sleep(3000);
        baseControlsHelper.clickOn(vz_strings.Vz_configs.DEVICE_NAME);
        baseControlsHelper.waitForContent();
        listView.selectFirstItemInSelectMode10();
        baseControlsHelper.openContext(null);

        TestCase.assertTrue("Create Story present ?", baseControlsHelper.getCountById(vz_strings.context_createStory) == 0);
    }
}