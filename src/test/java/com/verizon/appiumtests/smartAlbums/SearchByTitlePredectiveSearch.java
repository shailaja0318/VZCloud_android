//IV-1116
package com.verizon.appiumtests.smartAlbums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class SearchByTitlePredectiveSearch extends BaseTestClass {

    @Test
    public void testSearchByTitlePredectiveSearch() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        baseControlsHelper.clickOn(vz_strings.view_searchStoriesBar);

        baseControlsHelper.setValuetoTextFieldByName("o", vz_strings.view_searchStoriesBar);

        TestCase.assertTrue("Story not present ?", baseControlsHelper.getCountById("Photos stories") > 0);

    }
}