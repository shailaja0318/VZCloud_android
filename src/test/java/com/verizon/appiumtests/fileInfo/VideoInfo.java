//IV-280
package com.verizon.appiumtests.fileInfo;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.constants.vz_strings.DataType;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class VideoInfo extends BaseTestClass {

    @Test
    public void testVideoInfo() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        baseControlsHelper.clickOn(vz_strings.tab_all);
        baseControlsHelper.clickOnElementByXpath(vz_strings.name_video); //locator value not working
        baseControlsHelper.openContext(vz_strings.context_info);

        TestCase.assertTrue("Name not found", baseControlsHelper.getCountById("filenameLabel") != 0);
        TestCase.assertTrue("Date Taken not found", baseControlsHelper.getCountById("dateBackedUpLabel") != 0);
        TestCase.assertTrue("Date Uploaded not found", baseControlsHelper.getCountById("dateTakenLabel") != 0);
        TestCase.assertTrue("Resolution not found", baseControlsHelper.getCountById("resolutionLabel") != 0);
        TestCase.assertTrue("Size not found", baseControlsHelper.getCountById("sizeLabel") != 0);
        //TestCase.assertTrue("Extension not found", baseControlsHelper.getCountById("format") != 0);
    }
}