/**
 * VZNFT-29 - Step 5
 * */
package com.verizon.appiumtests.localytics.music;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * VZNFt-29 Music - tagScreen: Music Songs
 *
 * @author leletsn
 */

public class LocalyticsMusicSortAZ extends BaseTestClass{

  @Test
  public void testLocalyticsMusicSortAZ() throws Exception {
      homeScreenView.navigateTo(vz_strings.navi_music);
      musicView.selectTab(vz_strings.tab_songs);
      baseControlsHelper.openContext(vz_strings.context_sort);
      baseControlsHelper.setPickerValue(vz_strings.sort_AtoZ);

      String logs = localyticsHelper.getLogs();
      localyticsHelper.print(logs, vz_strings.logs_sortMedia);

      TestCase.assertEquals("Localytics of " + vz_strings.logs_tagEvent + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_sortMedia));

      TestCase.assertEquals("Localytics of " + vz_strings.logs_sortOption + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_sortOption + "\" = " + "\"" + vz_strings.logs_sortAtoZ + "\""));


  }
}
