//IV-2266
package com.verizon.appiumtests.photosandvideos.filter;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class FilterByPhotos extends BaseTestClass {
    @Test
    public void testFilterByPhotos() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        photosAndVideosView.filterBy(vz_strings.filterByPhotos);

        TestCase.assertTrue("Didn't find Filter header", baseControlsHelper.getCountById(vz_strings.filter_FilteredByPhotos)>0);
        TestCase.assertEquals("Clear filter is not available", 1, baseControlsHelper.getCountById(vz_strings.filter_clear));
        TestCase.assertTrue("Video inside album ? ", baseControlsHelper.getCountByNameLike("Video") < 1);
    }
}
