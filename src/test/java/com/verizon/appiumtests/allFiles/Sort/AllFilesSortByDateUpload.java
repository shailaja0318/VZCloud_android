//https://jira.synchronoss.net:8443/jira/browse/IV-180
package com.verizon.appiumtests.allFiles.Sort;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * Created by kram0003 on 17/01/18.
 */
public class AllFilesSortByDateUpload extends BaseTestClass {
    @Test
    public void FileSortSizeDateUpload() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_allFiles);
        baseControlsHelper.clickOn(vz_strings.navi_allFiles);
        baseControlsHelper.clickOnElementByXpath(vz_strings.mobile_file);
        baseControlsHelper.clickOnElementByXpath(vz_strings.allFiles_phone);
        //allFilesView.searchFile(".mp3",".jpg",".doc");
        allFilesView.sortBy(vz_strings.sort_dateUploaded);
        TestCase.assertTrue("Date Uploaded is not selected", allFilesView.sortValidation(vz_strings.sort_dateUploaded));
    }
}

