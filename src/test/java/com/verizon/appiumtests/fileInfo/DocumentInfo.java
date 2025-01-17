package com.verizon.appiumtests.fileInfo;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class DocumentInfo extends BaseTestClass {

    @Test
    public void testDocumentInfo() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_documents);
        listView.selectItemInSelectMode10("section - 0, row - 0");
        baseControlsHelper.openContext(vz_strings.context_info);

        TestCase.assertTrue("Name not found", baseControlsHelper.getCountById("filenameLabel") != 0);
        TestCase.assertTrue("Date Uploaded not found", baseControlsHelper.getCountById("dateUploadedLabel") != 0);
        TestCase.assertTrue("Size not found", baseControlsHelper.getCountById("sizeLabel") != 0);
        TestCase.assertTrue("Extension not found", baseControlsHelper.getCountById("typeLabel") != 0);
    }
}