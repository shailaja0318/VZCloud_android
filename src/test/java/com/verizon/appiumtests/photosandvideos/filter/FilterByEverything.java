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
       // baseControlsHelper.waitForShowByXpath(vz_strings.filter_selectAllText);
        TestCase.assertEquals("All file types are not selected.", 6,
                baseControlsHelper.getListByType(vz_strings.filter_selectedRadioButton));
        //count= 3 (photos, videos, saved stories)
    }
}
