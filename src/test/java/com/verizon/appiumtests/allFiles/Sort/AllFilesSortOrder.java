//https://jira.synchronoss.net:8443/jira/browse/IV-180

package com.verizon.appiumtests.allFiles.Sort;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by kram0003 on 13/12/17.
 */
public class AllFilesSortOrder extends BaseTestClass {

    @Test
    public void FileSort() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_allFiles);
        allFilesView.searchFile(".mp3",".jpg",".doc");
        baseControlsHelper.openContext(vz_strings.context_sort);
        List<String> actual = allFilesView.getSortOptions();
        List<String> current = allFilesView.SortView();
        TestCase.assertTrue("Missing Options: ", allFilesView.arraySort(actual, current));
        baseControlsHelper.clickOn(vz_strings.button_ok);
    }
}
