//https://jira.synchronoss.net:8443/jira/browse/VZNFT-173 #6
package com.verizon.appiumtests.localytics.favorite;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class FavoriteItemAddedDocument extends BaseTestClass {

    private void preCondition() throws Exception {

        System.out.println("--Start Preconditions--");
        if (baseControlsHelper.getCountById(vz_strings.group_favorites) > 0) {
            listView.selectFirstItemInSelectMode10();
            baseControlsHelper.openContext(vz_strings.context_removeFavorite);
            baseControlsHelper.waitForDismiss(vz_strings.toast_removeFromFavorite);
        }
        System.out.println("--End Preconditions--");
    }

    @Test
    public void testFavItemRemovedDocument() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_documents);
        preCondition();
        listView.selectFirstItemInSelectMode10();
        baseControlsHelper.openContext(vz_strings.context_addFavorite);
        baseControlsHelper.waitForDismiss(vz_strings.toast_addtoFavorite);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_favItemAdded);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_tagEvent + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_favItemAdded));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_count + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_count + " = " + "1"));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_mediaType + " does not exist", localyticsHelper.isExisted(logs, "\"" + vz_strings.logs_mediaType + "\"" + " = " + vz_strings.logs_mediaTypeDocument));

    }

}
