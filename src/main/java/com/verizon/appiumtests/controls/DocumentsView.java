package com.verizon.appiumtests.controls;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.driver.BaseDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DocumentsView {

	AppiumDriver driver = BaseDriver.getDriver();
	BaseControlsHelper baseControlsHelper = new BaseControlsHelper(driver);

    public DocumentsView(AppiumDriver driver) {
		this.driver = driver;
	}

    private final List<String> sortOptions = Arrays.asList(
            vz_strings.sort_dateUploaded,
            vz_strings.sort_fileName,
            vz_strings.sort_extension,
            vz_strings.sort_size);

    /**
     * Rewritten and removed xpath. 
	 *
	 * @param sort_options
	 * @throws Exception
	 */
    public void sortBy(String sort_options) throws Exception {
		baseControlsHelper.openContext(vz_strings.context_sort);
		baseControlsHelper.setPickerValue(sort_options);
	}

	/**
     * Uploads multiple files to the server, File name structure is File[i].txt 
     * where i is the number of file in sequence.
     * 
     * @param numFiles
     * @throws Exception
     * @author Alen Kalac
     */
/*    public void uploadMultipleFiles(int numFiles) throws Exception {
    	long time = System.currentTimeMillis();
    	for(int i = 0; i < numFiles; i++) {
    		uploadDocument("File" + i + ".txt");
    		long diff = System.currentTimeMillis() - time;
    		if(diff > 30000) {
    			System.out.println("Refreshing session");
    			driver.getContext();
    			time = System.currentTimeMillis();
    		}
    	}
    }*/
    
    /**
     * Upload a single file to the server. The file is Sample.txt 
     * @throws Exception
     */
 /*   public void uploadSingleFile() throws Exception {
    	VZServerRequests server = new VZServerRequests();
    	server.uploadFile(DataType.DOCUMENT);
    }
    */
    /**
     * Upload a file with a specific filename, File will be generated with that name and uploaded. 
     * 
     * @param fileName
     * @throws Exception
     */
 /*   public void uploadDocument(String fileName) throws Exception {

    	VZServerRequests server = new VZServerRequests();
    	server.uploadFile(DataType.DOCUMENT, fileName);
    }
    */
    /**
     * @author Alen Kalac
     * @return
     * 		Returns the private field sortOptions
     */
    public List<String> getSortOptions() {
    	return this.sortOptions;
    }
    
    /**
     * Parses the type picker and gathers the text from each element, returns it as a list
     * 
     * @return
     * 		Returns the list array of the option names.
     * @throws Exception
     */
    public List<String> getTypePickerTextList() throws Exception {
		baseControlsHelper.openContext(vz_strings.context_sort);
		List<String> list = new ArrayList<>();
		resetPickerList();
		while (baseControlsHelper.isEnabled(vz_strings.button_next)) {
			Thread.sleep(3000);
			String current = baseControlsHelper.getTextByType("XCUIElementTypePickerWheel");
			System.out.println("current is:" +current);
			list.add(current);
			baseControlsHelper.clickOn(vz_strings.button_next);
		}
		String current = baseControlsHelper.getTextByType("XCUIElementTypePickerWheel");
		list.add(current);
		
		return list;
	}
    
    /**
     * Reset the type picker to the top. 
     * @author Alen Kalac
     * @throws Exception
     */
    public void resetPickerList() throws Exception {
		if (baseControlsHelper.isEnabled(vz_strings.button_prev))
			System.out.println("Resetting PickerList To top");

		while (baseControlsHelper.isEnabled(vz_strings.button_prev)) {
			System.out.println("Resetting PickerList To top");
			baseControlsHelper.clickOn(vz_strings.button_prev);
		}
	}
    
    /**
	 * Strip the extension from the name of the file. 
	 * 
	 * @author Alen Kalac
	 * @param filename
	 * 		File name eg: "somefile.txt"
	 * @return
	 * 		Returns the actual name of the file without the extension eg: "somefile"
	 */
	public  String removeExtensionFromName(String filename) {
		String cleanName = filename.substring(0, filename.lastIndexOf("."));
		return cleanName;
	}

	/**
	 * Returns just the extension from the file name
	 * 
	 * @author Alen Kalac
	 * @param filename
	 * 		The filename eg: "somefile.txt"
	 * @return
	 * 		Returns the extension part of the file. eg: "txt"
	 */
	public String getExtensionFromFilename(String filename) {
		return filename.substring(filename.lastIndexOf(".") + 1);
	}

	/**
	 * Gets the name of the first static text field within a list view cell
	 * 
	 * @author Alen Kalac
	 * @param cell
	 * 		The MobileElement cell in the list view that contains static text fields. 
	 * @return
	 * 		Returns the name attribute of the first static text that is nested inside the cell
	 */
	public String getFileNameFromCell(WebElement cell) { // / Mobile element is changed to webelement
		WebElement elementName = getChildElement(cell, 0);
		return elementName.getAttribute("name");
	}

	/**
	 * Get the size of the files in the list view cell
	 * @author Alen Kalac
	 * @param cell
	 * 		A cell that contains static text with file size
	 * @return
	 * 		returns a string representation of the file size, this is actually an int value
	 */
	public String getFileSizeFromCell(WebElement cell) {  // Mobile element is changed to webelement
		final int CONVERT_VALUE = 1024;
		WebElement elementName = getChildElement(cell, 1);
		String data = elementName.getAttribute("name");
		//split the string
		String[] tokens = data.split(" ");
		//[value] [size,] [mm/dd/yy,] [hh:mm] [AM/PM]
		int value = Integer.parseInt(tokens[0]);
		String size_label = tokens[1].replace(",", "");
		
		System.out.println("Converting " + value + " " + size_label + " To bytes... " );
		switch(size_label) {
			case "GB":
				value *= CONVERT_VALUE;
			case "MB":
				value *= CONVERT_VALUE;
			case "KB":
				value *= CONVERT_VALUE;
		}
		
		return String.valueOf(value);
	}

	/**
	 * @author Alen Kalac
	 * @param cell
	 * 		A cell from list view that contains the needed information
	 * @return
	 * 		Returns a string representing a date in milliseconds, starting from 1/1/1970 00:00:00, this is represented by a long
	 */
	public String getFileDateFromCell(WebElement cell)  {
		// Mobile element is changed to webelement
	
		WebElement elementName = getChildElement(cell, 1);
		String data = elementName.getAttribute("name");
		//split the string
		String[] tokens = data.split(",");
		
		//[value size], [mm/dd/yy], [hh:mm AM/PM]
		//index 0		index 1		index 2
		//length-3		length-2	length-1
		
		String date = tokens[tokens.length-2];
		String time = tokens[tokens.length-1];
		
		System.out.println("Converting " + date + time + " To milliseconds... " );
		
		SimpleDateFormat df = new SimpleDateFormat("M/d/yy h:mm aaa");
		Date d = new Date();
		try {
			d = df.parse(date + time);
			return String.valueOf(d.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return "";
	}

	/**
	 * Gets the child element at an index, this only works if the element has nested StaticText elements
	 * 
	 * @author Alen Kalac
	 * @param parent
	 * 		Gets the specific child element from the cell. this is usually the case with document view
	 * 		where a cell contains two staticText fields.
	 * @param index
	 * 		an int index of the child to return
	 * @return
	 * 		Returns the specific element
	 */
	
	// TODO: return null if element doesn't exist
	// Mobile element is changed to webelement
	private WebElement getChildElement(WebElement parent, int index) {
		return parent.findElements(AppiumBy.className("XCUIElementTypeStaticText")).get(index);
	}

	/**
	 * Pulls the names from the array of elements
	 * @author Alen Kalac
	 * @param allElements
	 * @param sort_options
	 * @return
	 */
	public List<String> getData(List<WebElement> allElements, String sort_options) {
		System.out.println("GATHERING NEEDED INFORMATION, PLEASE WAIT...");
		List<String> list = new ArrayList<>();
		String elementData = "";
		// Mobile element is changed to webelement
		for (int i = 0; i < allElements.size(); i++) {
			WebElement element = allElements.get(i);
			
			switch(sort_options) {
				case vz_strings.sort_fileName:
					elementData = getFileNameFromCell(element);
					break;
				case vz_strings.sort_extension:
					elementData = getExtensionFromFilename(getFileNameFromCell(element));
					break;
				case vz_strings.sort_dateUploaded:
					elementData = this.getFileDateFromCell(element);
					break;
				case vz_strings.sort_size:
					elementData = this.getFileSizeFromCell(element);
					break;
				default: 
					System.out.println("Unsupported sorting for documents");
			}
			
			System.out.println("FETCHING... " + elementData);
			list.add(elementData);
		}

		return list;
	}

	public List<String> cloneList(List<String> original) {
		List<String> list = new ArrayList<>();
		for (String data : original)
			list.add(data);
		return list;
	}

	public String selectPickerAccordingly(String pickerValue) throws Exception {
		switch (pickerValue) {
			case vz_strings.sort_dateUploaded:
				baseControlsHelper.setPickerValue(vz_strings.sort_fileName);
				pickerValue = vz_strings.sort_fileName;
				break;
			case vz_strings.sort_fileName:
				baseControlsHelper.setPickerValue(vz_strings.sort_extension);
				pickerValue = vz_strings.sort_extension;
				break;
			case vz_strings.sort_extension:
				baseControlsHelper.setPickerValue(vz_strings.sort_size);
				pickerValue = vz_strings.sort_size;
				break;
			case vz_strings.sort_size:
				baseControlsHelper.setPickerValue(vz_strings.sort_dateUploaded);
				pickerValue = vz_strings.sort_dateUploaded;
				break;
		}
		//Inserting quotes if string is multi word
		if (pickerValue.matches(".*\\s+.*")) pickerValue = "\"" + pickerValue + "\"";
		return pickerValue;
	}

	public boolean compareCollection(List<String> beforeSorting, List<String> afterSorting) {
		for (int i = 0; i < beforeSorting.size(); i++) {
			if (!(beforeSorting.get(i)).equals(afterSorting.get(i))) {
				System.out.println("Collection not sorted");
				return false;
			}
		}
		return true;
	}
}
