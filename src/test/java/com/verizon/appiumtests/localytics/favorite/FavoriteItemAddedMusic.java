//https://jira.synchronoss.net:8443/jira/browse/VZNFT-173 #3,4
package com.verizon.appiumtests.localytics.favorite;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class FavoriteItemAddedMusic extends BaseTestClass {

    @Test
    public void testFavoriteItemAddedMusic() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_music);
        musicView.selectTab(vz_strings.tab_playlists);
        musicView.removeSongFromFavorites();
        musicView.addSongToFavoritesFromSongs();

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_favItemAdded);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_favItemAdded + " does not exist",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_favItemAdded)==1);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_count + " does not exist",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_count + " = " + "1")>0);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaType + " does not exist",
                localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + vz_strings.logs_mediaTypeMusic)==1);

    }

}
