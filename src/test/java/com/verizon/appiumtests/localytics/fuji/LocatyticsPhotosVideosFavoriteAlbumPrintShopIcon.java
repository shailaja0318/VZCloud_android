package com.verizon.appiumtests.localytics.fuji;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;
/** 
 * @author leletsn
 *VZNFT-228 Localytics: tag event - Cloud Print Shop Entry - Photo Video Favorite
 */

public class LocatyticsPhotosVideosFavoriteAlbumPrintShopIcon extends BaseTestClass {

	    @Test
	    public void testVZNFT228LocatyticsPhotosVodeosFavoriteAlbumPrintShopIcon() throws Exception {

	        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
	        photosAndVideosView.selectTab(vz_strings.tab_albums);
	        precondition.removeFavoritesAlbum();
	        precondition.AddToFavoriteAlbum();
	        photosAndVideosView.selectFavoriteAlbum();
	        Thread.sleep(3000);
	        photosAndVideosView.accessPrintShopFromIcon();
	        
	        String logs = localyticsHelper.getLogs();
	        localyticsHelper.print(logs, vz_strings.logs_photoBucketEntry);
	        TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketEntry + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_photoBucketEntry));
            TestCase.assertEquals("Localytics of " + vz_strings.logs_photoBucketEntry + " is not 1 in logs", 1, localyticsHelper.getCountOf(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_photoBucketEntry));
	        TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketEntryPoint + " does not exist", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_photoBucketEntryPoint + "\" = \"" + vz_strings.logs_photosVideosFavorite + "\""));
	        TestCase.assertTrue("Localytics of " + vz_strings.logs_photoBucketNumber + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_photoBucketNumber));
	       
    

    }
}
