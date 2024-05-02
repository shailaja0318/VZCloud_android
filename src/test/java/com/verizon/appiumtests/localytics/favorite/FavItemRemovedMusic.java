/**
 * VZNFT-174 - Step 3-4
 */
package com.verizon.appiumtests.localytics.favorite;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class FavItemRemovedMusic extends BaseTestClass {

    @Test
    public void testFavItemRemovedMusic() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_playlists);
        precondition.addSongToFavoriteFromSongs();
        baseControlsHelper.clickOn("Favorites");
        listView.clickOnAllElementsInMusicList(vz_strings.MusicView.Favorites);
        baseControlsHelper.openContext(vz_strings.context_removeFavorite);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_favItemRemoved);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_favItemRemoved + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_favItemRemoved));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_tagEvent + " is not 1 in logs", localyticsHelper.getCountOf(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_favItemRemoved) == 1);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_count + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_count + " = " + "1"));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaType + " does not exist", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + vz_strings.logs_mediaTypeMusic));

    }
}
