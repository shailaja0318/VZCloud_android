//IV-2266
package com.verizon.appiumtests.photosandvideos.filter;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class FilterByEverything extends BaseTestClass {

    @Test
    public void testFilterByEverything() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        photosAndVideosView.filterBy(vz_strings.filter_Everything);
        baseControlsHelper.openContext(vz_strings.context_sortAndFilter);
        TestCase.assertTrue("All file types are not selected.", baseControlsHelper.getCountById(vz_strings.filter_selectedRadioButton)==3); //count= 3 (photos, videos, saved stories)
    }
}
