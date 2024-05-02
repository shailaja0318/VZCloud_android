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
        photosAndVideosView.selectTab(vz_strings.tab_all);
        gridView.tapItem(DataType.VIDEO);
        baseControlsHelper.openContext(vz_strings.context_info);

        TestCase.assertTrue("Name not found", baseControlsHelper.getCountById("Name") != 0);
        TestCase.assertTrue("Date Taken not found", baseControlsHelper.getCountById("Date Taken") != 0);
        TestCase.assertTrue("Date Uploaded not found", baseControlsHelper.getCountById("Date Uploaded") != 0);
        TestCase.assertTrue("Resolution not found", baseControlsHelper.getCountById("Resolution") != 0);
        TestCase.assertTrue("Size not found", baseControlsHelper.getCountById("Size") != 0);
        TestCase.assertTrue("Extension not found", baseControlsHelper.getCountById("Extension") != 0);
    }
}
