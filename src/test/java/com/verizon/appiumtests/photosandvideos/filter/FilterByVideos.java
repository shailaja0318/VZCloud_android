//IV-2266
package com.verizon.appiumtests.photosandvideos.filter;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class FilterByVideos extends BaseTestClass {
    @Test
    public void testFilterByVideos() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        photosAndVideosView.filterBy(vz_strings.filterByVideos);

        TestCase.assertTrue("Didn't find Filter header", baseControlsHelper.getCountById(vz_strings.filter_FilteredByVideos)>0);
        TestCase.assertEquals("Clear filter is not available", 1, baseControlsHelper.getCountById(vz_strings.filter_clear));
        TestCase.assertTrue("Photo inside album ? ", baseControlsHelper.getCountByNameLike("Photo") < 1);
    }
}
