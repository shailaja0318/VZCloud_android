/**
 * VZNFT-38
 * */
package com.verizon.appiumtests.localytics.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsMusicFavoritesSongs extends BaseTestClass{

  @Test
  public void testLocalyticsMusicFavoritesSongs() throws Exception {

	  homeScreenView.navigateTo(vz_strings.navi_music);
      musicView.selectTab(vz_strings.tab_playlists);
      musicView.removeSongFromFavorites();
      musicView.selectTab(vz_strings.tab_songs);
      listView.selectFirstItem10();
      baseControlsHelper.openContext(vz_strings.context_addFavorite);

      String stringBuilder = vz_strings.logs_count + " = " + 1;

      String logs = localyticsHelper.getLogs();
      localyticsHelper.print(logs, vz_strings.logs_favItemAdded);

      TestCase.assertEquals("Localytics of " + vz_strings.logs_favItemAdded + " does not exist", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_favItemAdded));
      TestCase.assertTrue("Localytics of " + vz_strings.logs_count + " does not exist",
              localyticsHelper.isExisted(logs, stringBuilder));
      TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaType + " does not exist",
              localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + vz_strings.logs_mediaTypeMusic));
  }
}
