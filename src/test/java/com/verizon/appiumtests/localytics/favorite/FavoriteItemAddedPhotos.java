//https://jira.synchronoss.net:8443/jira/browse/VZNFT-173 #2
package com.verizon.appiumtests.localytics.favorite;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;


public class FavoriteItemAddedPhotos extends BaseTestClass {
    @Test
    public void testFavoriteItemAddedPhotos() throws Exception {


        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        precondition.removeFavoritesAlbum();
        photosAndVideosView.selectTab(vz_strings.tab_all);
        gridView.tapItemInSelectMode(vz_strings.DataType.PHOTO);
        baseControlsHelper.waitForShow(vz_strings.actionBar_selectView_addToFavorite);
		baseControlsHelper.clickOn(vz_strings.actionBar_selectView_addToFavorite);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_favItemAdded);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_favItemAdded + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_favItemAdded));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_count + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_count + " = " + "1"));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaType + " does not exist", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + vz_strings.logs_mediaTypePhotos));


    }
}