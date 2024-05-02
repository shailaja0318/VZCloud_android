//260
package com.verizon.appiumtests.publicshare;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import org.testng.annotations.Test;

public class MusicShare extends BaseTestClass {

    @Test
    public void testMusicCopyShareLink() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_nowPlaying);
        musicView.selectTab(vz_strings.tab_songs);
        listView.selectFirstItemInSelectMode10();
        baseControlsHelper.openContext(vz_strings.context_share);
        baseControlsHelper.waitForDismiss(vz_strings.toast_creatingSocialShareLink);

    }
}
