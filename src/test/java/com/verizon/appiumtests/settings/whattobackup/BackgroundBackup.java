/**
 * Test URL: https://jira.synchronoss.net:8443/jira/browse/IV-2342
 *
 * @author Alen Kalac
 */

package com.verizon.appiumtests.settings.whattobackup;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class BackgroundBackup extends BaseTestClass {

    @Test
    public void testBackgroundBackupLabelAndText() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_settings);
        baseControlsHelper.clickOn(vz_strings.settings_whatToBackUp);

        baseControlsHelper.clickOnNameContains("learnMoreLink");

        int labelCount = baseControlsHelper.getCountById(vz_strings.text_background_backup_label);

        String textValue = baseControlsHelper.getTextByNameContains("iPhone");

        TestCase.assertTrue("Text Does't Match", textValue.contains(vz_strings.text_background_backup_text));
    }
}
