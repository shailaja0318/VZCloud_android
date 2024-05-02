//https://jira.synchronoss.net:8443/jira/browse/IV-180

package com.verizon.appiumtests.allFiles.Sort;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * Created by kram0003 on 17/01/18.
 */
public class AllFilesSortByExtension extends BaseTestClass {
    @Test
    public void FileSortExtension() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_allFiles);
        allFilesView.searchFile(".mp3",".jpg",".doc");
        allFilesView.sortBy(vz_strings.sort_extension);
        TestCase.assertTrue("Extension is not in order", allFilesView.sortValidation(vz_strings.sort_extension));
    }
}
