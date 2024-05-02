package com.verizon.appiumtests.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class SongsPlaySuccessfully extends BaseTestClass {

    @Test
    public void testSongsPlaySuccessfully() throws Exception {


        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_albums);
        //click on album 
        Thread.sleep(1000);
        listView.selectFirstItem10();
        //click on song
        listView.selectItem10("section - 1, row - 0");

        baseControlsHelper.waitForShow("pauseButton");
        TestCase.assertTrue("Previous Button missing ", baseControlsHelper.getCountById("prevButton") != 0);
        TestCase.assertTrue("Next Button ", baseControlsHelper.getCountById("nextButton") != 0);
        TestCase.assertTrue("Loop Off  ", baseControlsHelper.getCountById("loopOff") != 0);

    }
}
