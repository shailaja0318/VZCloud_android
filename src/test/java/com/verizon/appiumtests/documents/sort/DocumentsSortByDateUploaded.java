/**
 * Test URL: https://jira.synchronoss.net:8443/jira/browse/IV-2186
 *
 * @author Alen Kalac
 */

package com.verizon.appiumtests.documents.sort;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class DocumentsSortByDateUploaded extends BaseTestClass {
	private List<WebElement> allElements;
	private List<String> unsortedData;
	private List<String> sortedData;

	@Test
	public void testDocumentsSortByDateUploaded() throws Exception {

		String sort_option = vz_strings.sort_dateUploaded;

		homeScreenView.navigateTo(vz_strings.navi_documents);

		// Sort by Date Uploaded
		documentsView.sortBy(sort_option);

		allElements = listView.getAllElements(vz_strings.view_documents);

		unsortedData = documentsView.getData(allElements, sort_option);
		sortedData = documentsView.cloneList(unsortedData);

		// sort in reverse order so newest file is on top
		sortedData.sort(Comparator.reverseOrder());

		TestCase.assertTrue(sort_option + " sorting doesn't match",
                documentsView.compareCollection(unsortedData, sortedData));
    }

}
