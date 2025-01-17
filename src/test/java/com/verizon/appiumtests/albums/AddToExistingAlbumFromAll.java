/**
 * Test case https://jira.synchronoss.net:8443/jira/browse/IV-331
 */
package com.verizon.appiumtests.albums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class AddToExistingAlbumFromAll extends BaseTestClass {

    @Test
        public void testAddToExistingAlbumFromAll() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        precondition.deleteAllAlbums();
        precondition.createAlbum();
        baseControlsHelper.waitForShow(vz_strings.tab_all);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        baseControlsHelper.clickOnElementByXpath(vz_strings.name_photo);
        photosAndVideosView.addToAlbum10(vz_strings.DataType.PHOTO);
        baseControlsHelper.clickOnNameBeginswith(vz_strings.navi_Photosandvideos);
        baseControlsHelper.waitForContent();
        photosAndVideosView.openAlbum();
        baseControlsHelper.waitForContent();

        int count1 = gridView.getAlbumContentCount();

        if (count1 > 0) {
            TestCase.assertTrue("Photo count not increasing ", count1 >= 1);
        } else {
            TestCase.assertTrue("Album still empty", count1 != 0);
        }
    }
}
