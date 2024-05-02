/**
 * Test URL: https://jira.synchronoss.net:8443/jira/browse/IV-2256
 *
 * @author Alen Kalac
 */

package com.verizon.appiumtests.documents.sort;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class DocumentsSortByFileName extends BaseTestClass {
	private List<WebElement> allElements;
	private List<String> unsortedData;
	private List<String> sortedData;

	@Test
	public void testDocumentsSortByFileName() throws Exception {

		String sort_option = vz_strings.sort_fileName;

		homeScreenView.navigateTo(vz_strings.navi_documents);
		documentsView.sortBy(sort_option);

		allElements = listView.getAllElements(vz_strings.view_documents);

		unsortedData = documentsView.getData(allElements, sort_option);
		sortedData = documentsView.cloneList(unsortedData);
		sortedData.sort(String.CASE_INSENSITIVE_ORDER);

		TestCase.assertTrue(sort_option + " sorting doesn't match",
				documentsView.compareCollection(unsortedData, sortedData));
    }

}
