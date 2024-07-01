//IV-313
package com.verizon.appiumtests.albums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class AlbumViewContextMenu extends BaseTestClass {

    @Test
    public void testAlbumViewContextMenu() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        precondition.createAlbum();
        baseControlsHelper.openContext(null);

        TestCase.assertTrue("Print & Gift is missing ",
                baseControlsHelper.elementIsVisible(vz_strings.context_album_print_gift));
        TestCase.assertTrue("Select is missing", baseControlsHelper.elementIsVisible(vz_strings.context_albumSelect));
        TestCase.assertTrue("New ALbum is missing", baseControlsHelper.elementIsVisible(vz_strings.context_albumNewAlbum));
        TestCase.assertTrue("Sort is missing", baseControlsHelper.elementIsVisible(vz_strings.context_albumSort));
    }
}
