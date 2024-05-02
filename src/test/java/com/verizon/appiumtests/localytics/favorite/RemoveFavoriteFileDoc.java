//https://jira.synchronoss.net:8443/jira/browse/VZNFT-174/step-10
package com.verizon.appiumtests.localytics.favorite;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * Created by kram0003 on 11/04/18.
 */
public class RemoveFavoriteFileDoc extends BaseTestClass {
    @Test
    public void removeFavoriteFileDoc() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_allFiles);
        allFilesView.searchFile(".doc", ".xls", ".xlsx");
        listView.removeFavorites();
        listView.multiFavorite(2);
        listView.SelectMultiItem(2);
        baseControlsHelper.openContext(vz_strings.context_removeFavorite);
        baseControlsHelper.waitForDismiss(vz_strings.toast_removeFromFavorite);
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_tagEvent + " is not 1 in logs",
                localyticsHelper.isExisted(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_favItemRemoved));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaType + " is not 1 in logs",
                localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_mediaType + "\" = Documents"));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_count + "  is not 1 in logs",
                localyticsHelper.isExisted(logs, vz_strings.logs_count + " = 2"));
    }
}
