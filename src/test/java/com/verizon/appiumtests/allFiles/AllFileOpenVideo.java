//IV-66
package com.verizon.appiumtests.allFiles;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class AllFileOpenVideo extends BaseTestClass {

    @Test
    public void testAllFileOpenVideo() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_allFiles);
        String[] ext = {".MOV", ".MP4"};

        for (int i = 0; i <= ext.length; i++) {
            allFilesView.search(ext[i]);
            if (baseControlsHelper.getCountById(vz_strings.emptyText_AllFiles) > 0) {
                baseControlsHelper.clickOn(vz_strings.clear_text);
            } else
                break;
        }

        listView.selectFirstItem10();
        photosAndVideosView.playVideo();

        TestCase.assertTrue("Video is not open", baseControlsHelper.getCountById(vz_strings.button_done) != 0);
    }
}