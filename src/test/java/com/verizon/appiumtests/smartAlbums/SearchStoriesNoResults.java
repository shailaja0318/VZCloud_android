//IV-2386
package com.verizon.appiumtests.smartAlbums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class SearchStoriesNoResults extends BaseTestClass {

    @Test
    public void testSearchStoriesNoResults() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        baseControlsHelper.setValuetoTextFieldByName("*", vz_strings.view_searchStoriesBar);

        TestCase.assertTrue("Result found fail", baseControlsHelper.getCountById("No Results to Display") > 0);
        TestCase.assertTrue((baseControlsHelper.getCountById("search_empty_screen.png") > 0));
        TestCase.assertTrue(baseControlsHelper.getCountById("No stories could be found matching your search criteria.") < 1);
    }
}
    

