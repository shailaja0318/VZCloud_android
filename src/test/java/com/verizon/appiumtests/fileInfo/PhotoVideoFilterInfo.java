// IV-3413 - File Info: Photos / Videos Filtering Removes Info from Menu
// IV-3415 - Removal of Info option when single file is multi-selected.
package com.verizon.appiumtests.fileInfo;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class PhotoVideoFilterInfo extends BaseTestClass {

    @Test
    public void testPhotoVideoFilterInfo() throws Exception{

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        gridView.tapItemsInMultiSelectMode(1, vz_strings.DataType.PHOTO);
        baseControlsHelper.openContext(null);

        TestCase.assertTrue("File info is displayed", baseControlsHelper.getCountById("Info") < 1);
    }

}
