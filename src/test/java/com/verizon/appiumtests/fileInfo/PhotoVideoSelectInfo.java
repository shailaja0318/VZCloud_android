//IV-3414
package com.verizon.appiumtests.fileInfo;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class PhotoVideoSelectInfo extends BaseTestClass {

    @Test
    public void testPhotoVideoSelectInfo() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        gridView.tapItemsInSelectMode();
        baseControlsHelper.openContext(null);

        TestCase.assertTrue("Info found", baseControlsHelper.getCountById("Info") < 1);
    }

}
