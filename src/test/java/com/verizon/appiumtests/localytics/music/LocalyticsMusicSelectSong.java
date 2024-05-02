/**
 * VZNFT-29 - Step 2
 * */
package com.verizon.appiumtests.localytics.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsMusicSelectSong extends BaseTestClass{

  @Test
  public void testLocalyticsMusicSelectSong() throws Exception {

      precondition.clickMusicHeadFromHome();
      musicView.selectTab(vz_strings.tab_songs);
      listView.selectFirstItem10();

      String logs = localyticsHelper.getLogs();
      localyticsHelper.print(logs, vz_strings.logs_tagScreen);

      TestCase.assertTrue("Localytics of " + vz_strings.logs_tagScreen + " is not 1 in logs",
              localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_musicSongs) == 1);
      TestCase.assertTrue("Localytics of " + vz_strings.logs_tagEvent + " is not 1 in logs",
              localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_mediaPlay) == 1);
      TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaType + " is not 1 in logs",
              localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_mediaType + "\" = " + vz_strings.logs_mediaTypeSong) == 1);

  }
}