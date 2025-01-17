package com.verizon.appiumtests.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class OnTheGoPlaylist extends BaseTestClass {

    //@Test
        public void testOnTheGoPlaylist() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_playlists);
        baseControlsHelper.clickOn("On-The-Go");
        precondition.addSongToOnTheGo();

        TestCase.assertTrue("Song is not added ", baseControlsHelper.getCountInViewByPredicate("MusicView") > 0);
    }
}
