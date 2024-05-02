/**
 * VZNFT-29 - Step 4
 * */
package com.verizon.appiumtests.localytics.music;
/**
 * VZNFt-29 
 *
 * @author leletsn
 */
import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsMusicSortZA extends BaseTestClass{

  @Test
  public void testLocalyticsMusicSortZA() throws Exception {

      precondition.clickMusicHeadFromHome();
      musicView.selectTab(vz_strings.tab_songs);
      baseControlsHelper.openContext(vz_strings.context_sort);
      baseControlsHelper.setPickerValue(vz_strings.sort_ZtoA);

      String logs = localyticsHelper.getLogs();
      localyticsHelper.print(logs, vz_strings.logs_tagEvent);

      TestCase.assertTrue("Localytics of " + vz_strings.logs_tagEvent + " is not 1 in logs",
              localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_sortMedia) == 1);

      TestCase.assertTrue("Localytics of " + vz_strings.logs_sortOption + " is not 1 in logs",
              localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_sortOption + "\" = " + "\"" + vz_strings.logs_sortZtoA + "\"") == 1);

  }
}
