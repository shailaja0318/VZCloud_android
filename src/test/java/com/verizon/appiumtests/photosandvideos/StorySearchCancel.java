//https://jira.synchronoss.net:8443/jira/browse/IV-2385
package com.verizon.appiumtests.photosandvideos;


import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;

import java.text.DateFormatSymbols;

/**
 * Created by kram0003 on 29/01/18.
 */
public class StorySearchCancel extends BaseTestClass {
  //  @Test
    public void storySearchCancel_IV_2385() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_stories);
        if (baseControlsHelper.getCountById(vz_strings.emptyPhotosViewIcon) == 0) {
            String current = baseControlsHelper.getAttrByContainsLabelAndType("Story");
            TestCase.assertTrue("Cancel is not working", current != condition());
        } else
            TestCase.assertTrue("No Stories are avaliable", baseControlsHelper.getCountById(vz_strings.emptyPhotosViewIcon) != 0);
    }

    private String condition() throws Exception {
        String current = null;
        String[] months = new DateFormatSymbols().getMonths();
        for (String month : months) {
            photosAndVideosView.storySearch(month);
            if (baseControlsHelper.getCountById(vz_strings.emptyText_AllFiles) == 0) {
                current = baseControlsHelper.getAttrByContainsLabelAndType("Story");
                baseControlsHelper.clickOn(vz_strings.button_cancel);
                break;
            }
            baseControlsHelper.clickOn(vz_strings.clear_text);
            baseControlsHelper.clickOn(vz_strings.button_cancel);

        }
        return current;

    }
}
