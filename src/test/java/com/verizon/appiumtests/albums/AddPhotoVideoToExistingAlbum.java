
package com.verizon.appiumtests.albums;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.constants.vz_strings.DataType;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * Test case https://jira.synchronoss.net:8443/jira/browse/ 
 */

public class AddPhotoVideoToExistingAlbum extends BaseTestClass {

    @Test
    public void testAddPhotoVideoToExistingAlbum() throws Exception {
    	//nativeIosAppsView.generateVideo(1);
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_albums);
        precondition.createAlbum();
        photosAndVideosView.openAlbum();
        int count = gridView.getAlbumContentCount();
        photosAndVideosView.addItemFromAlbum(DataType.PHOTO);
        photosAndVideosView.openAlbum();

        if (count != 0) {
            int count1 = gridView.getAlbumContentCount();
            TestCase.assertTrue("Photo count not increasing, before count: " + count + ", after count:" + count1, count1 == count + 1);
        } else {
            TestCase.assertTrue("Album still empty", gridView.getAlbumContentCount() != 0);
        }
    }
}