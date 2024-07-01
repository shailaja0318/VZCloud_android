package com.verizon.appiumtests.smartAlbums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class CreateStoryNotSeenFromAllFiles extends BaseTestClass {

    @Test
    public void testCreateStoryNotSeenFromAllFiles() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_allFiles);
        baseControlsHelper.clickOn(vz_strings.folder_mobile);
        baseControlsHelper.clickOn(vz_strings.folder_mobile_name);
        baseControlsHelper.openContext(vz_strings.context_select);
        listView.selectFirstItem10();
        baseControlsHelper.openContext(null);

        TestCase.assertTrue("Create Story is found", baseControlsHelper.getCountById(vz_strings.context_createStory) < 1);
    }
}