/**
 * Test URL: https://jira.synchronoss.net:8443/jira/browse/IV-2189
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

public class DocumentsSortBySize extends BaseTestClass {
	private List<WebElement> allElements;
	private List<String> unsortedData;
	private List<String> sortedData;

	@Test
	public void testDocumentsSortBySize() throws Exception {

		homeScreenView.navigateTo(vz_strings.navi_documents);

		String sort_option = vz_strings.sort_size;

		documentsView.sortBy(sort_option);

		allElements = listView.getAllElements(vz_strings.view_documents);

		unsortedData = documentsView.getData(allElements, sort_option);
		sortedData = documentsView.cloneList(unsortedData);

		// sort in reverse order so larger file is on top
		sortedData.sort((o1, o2) -> {
			int v1 = Integer.parseInt(o1);
			int v2 = Integer.parseInt(o2);
			return new Integer(v2).compareTo(new Integer(v1));
		});

		TestCase.assertTrue(sort_option + " sorting doesn't match",
				documentsView.compareCollection(unsortedData, sortedData));
    }

}
