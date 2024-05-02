//IV-735
package com.verizon.appiumtests.publicshare;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;

public class MusicCopyShareLink extends BaseTestClass{

    //@Test
    public void testMusicCopyShareLink() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_music);
        photosAndVideosView.selectTab(vz_strings.tab_nowPlaying);
        baseControlsHelper.waitForShow(vz_strings.tab_songs);
        baseControlsHelper.clickOn(vz_strings.tab_songs);
        listView.selectFirstItemInSelectMode10();
        baseControlsHelper.openContext(vz_strings.context_copyShareLink);
        baseControlsHelper.waitForDismiss(vz_strings.toast_shareLinkCopied);

    }
}
