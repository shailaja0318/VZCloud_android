/**
 * Test URL: https://jira.synchronoss.net:8443/jira/browse/IV-179
 *
 * @author Alen Kalac
 */
package com.verizon.appiumtests.documents.sort;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

import java.util.List;

public class DocumentsVerifySortValues extends BaseTestClass {

	@Test
	public void testDocumentSortValues() throws Exception {  

		homeScreenView.navigateTo(vz_strings.navi_documents);

		List<String> actual = documentsView.getSortOptions();
		List<String> current = documentsView.getTypePickerTextList();

		TestCase.assertTrue("Missing Options: ", documentsView.compareCollection(actual, current));
	}
}
