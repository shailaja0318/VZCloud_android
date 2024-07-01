package com.verizon.appiumtests.controls;

import com.verizon.appiumtests.constants.HelperUtilities;
import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.driver.BaseDriver;
import io.appium.java_client.AppiumDriver;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class AllFilesView {


    AppiumDriver driver = BaseDriver.getDriver();
    BaseControlsHelper baseControlsHelper = new BaseControlsHelper(driver);
    ListView listView =new ListView(driver);

    public AllFilesView(AppiumDriver driver) {
        this.driver = driver;
    }

    public String getItemNameFromPredicate(String name) throws Exception {
        return baseControlsHelper.getTextByNameContains(name);
    }

/*    public void uploadFile(String fileName) throws Exception {
        VZServerRequests server = new VZServerRequests();
        server.uploadFile(DataType.DOCUMENT, fileName);

    }*/

    public List<String> sortitems = Arrays.asList(
            vz_strings.sort_dateUploaded,
            vz_strings.sort_fileName,
            vz_strings.sort_extension,
            vz_strings.sort_size);

    public List<String> getSortOptions() {
        return this.sortitems;
    }

    public List<String> SortView() throws Exception {
        String current = null;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < sortitems.size(); i++) {
            current = baseControlsHelper.getTextByType("XCUIElementTypePickerWheel");
            list.add(current);
            System.out.println("Appium Helper sort item is matched");
            if (baseControlsHelper.isEnabled(vz_strings.button_next)) {
                baseControlsHelper.clickOnNameBeginswith(vz_strings.button_next);
            }
        }
        return list;
    }

    public boolean sortValidation(String sortitem) throws Exception {
        String[] returnvalues = null;
        int beforevalue;
        int aftervalue;
        switch (sortitem) {
            case vz_strings.sort_size:
                returnvalues = listView.infoValues(sortitem);
                beforevalue = Integer.parseInt(returnvalues[0].replaceAll("[^0-9]", ""));
                aftervalue = Integer.parseInt(returnvalues[1].replaceAll("[^0-9]", ""));
                if (beforevalue < aftervalue) {
                    return false;
                }
                break;
            case vz_strings.sort_fileName:
                returnvalues = listView.infoValues("Name");
                if (returnvalues[0].compareTo(returnvalues[1]) > 0) {
                    return false;
                }
                break;
            case vz_strings.sort_dateUploaded:
                returnvalues = listView.infoValues(sortitem);
                SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy, hh:mm");
                Date date1 = format.parse(returnvalues[0]);
                Date date2 = format.parse(returnvalues[1]);
                if (date1.compareTo(date2) < 0) {
                    return false;
                }
                break;
            case vz_strings.sort_extension:
                returnvalues = listView.infoValues(sortitem);
                if (returnvalues[0].compareTo(returnvalues[1]) > 0) {
                    return false;
                }
                break;
        }
        return true;
    }

    public void searchFile(String ext1, String ext2, String ext3) throws Exception {
        String[] names = {"Mobile", "Web", "TestREPO"};
        for (String name : names)
            if (baseControlsHelper.getCountById(name) > 0) {
                baseControlsHelper.clickOn(name);
                break;
            }
        String[] ext = {ext1, ext2, ext3};
        int i = 0;
        while (true) {
            search(ext[i]);
            if (baseControlsHelper.getCountById(vz_strings.emptyText_AllFiles) == 0) {
                break;
            }
            baseControlsHelper.clickOn(vz_strings.clear_text);
            baseControlsHelper.clickOn(vz_strings.button_cancel);
            i++;
        }
    }
    public void sortBy(String sort_options) throws Exception {
        baseControlsHelper.openContext(vz_strings.context_sort);
        baseControlsHelper.setPickerValue(sort_options);
    }

    public void search(String content) throws Exception {
        if (content != null) {
            baseControlsHelper.clickOn(vz_strings.searchIcon);
            baseControlsHelper.setValuetoTextFieldByName(content, vz_strings.searchIcon);
        }
    }

    public boolean arraySort(List<String> actual, List<String> current) throws Exception {
        String[] actualarray = new String[actual.size()];
        actual.toArray(actualarray);
        String[] currentarray = new String[current.size()];
        current.toArray(currentarray);
        Arrays.sort(actualarray);
        Arrays.sort(currentarray);
        return Arrays.equals(actualarray, currentarray);

    }

    public void clickOnFirstElementOfMobileRepo() throws Exception {
        baseControlsHelper.clickOn(vz_strings.folder_mobile);
        baseControlsHelper.clickOn(HelperUtilities.executeCommand("ideviceinfo -k DeviceName"));
        sortBy(vz_strings.sort_dateUploaded);
        baseControlsHelper.clickOnNameContains("section - 0, row - 0");
        baseControlsHelper.touchAndHoldOnElement(baseControlsHelper.getLivePhotoElement());
    }
}
