package com.verizon.appiumtests.controls;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.driver.BaseDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ListView {

    AppiumDriver driver = BaseDriver.getDriver();
    BaseControlsHelper baseControlsHelper = new BaseControlsHelper(driver);
    List list = new ArrayList<>();


    public ListView(AppiumDriver driver) {
        this.driver = driver;
    }

    public void selectItemInSelectMode10(String name) throws Exception {
        baseControlsHelper.clickOn(vz_strings.context_menu);
        baseControlsHelper.clickOn(vz_strings.context_select);
        baseControlsHelper.clickOnNameContains(name);
    }

    public void selectFirstItemInSelectMode10() throws Exception {
    	Thread.sleep(3000);
        baseControlsHelper.clickOn(vz_strings.context_menu);
        baseControlsHelper.clickOn(vz_strings.context_select);
        selectFirstItem10();
    }

    public void selectItem10(String name) throws Exception {
        baseControlsHelper.clickOnNameContains(name);
    }

    public void selectFirstItem10() throws Exception {
        baseControlsHelper.clickOnNameContains("section - 0, row - 0");
    }

    public void selectNumberOfItems(int num) throws Exception {
        int count = baseControlsHelper.getCountByNameContains("section - 0");
        baseControlsHelper.openContext(vz_strings.context_select);
        for (int i = 0; i < num && i < count; i++ ){
            baseControlsHelper.clickOnNameContains("section - 0, row - "+i+"");
        }
    }

    public void clickOnAllElementsInMusicList(vz_strings.MusicView mType) throws Exception {
        baseControlsHelper.openContext(vz_strings.context_select);
        String thisMusicType = selectMusicView(mType);
        list = (List) driver.findElement(AppiumBy.iOSNsPredicateString("wdType LIKE \'XCUIElementTypeCell\' AND wdName CONTAINS \'" + thisMusicType + "\'"));
        ArrayList<String> newlist = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            newlist.add(((WebElement) list.get(i)).getAttribute("name"));
        }

        for (int i = 0; i < newlist.size(); i++) {
            if (baseControlsHelper.isVisible(newlist.get(i))) {
                baseControlsHelper.clickOn(newlist.get(i));
            } else break;
        }
    }

    private String selectMusicView(vz_strings.MusicView mType) {
        String type = "";

        switch (mType) {
            case Albums:
                type = vz_strings.mtype_Albums;
                break;
            case Album:
                type = vz_strings.mtype_Album;
                break;
            case Artists:
                type = vz_strings.mtype_Artists;
                break;
            case Artist_albums:
                type = vz_strings.mtype_Artist_albums;
                break;
            case Artist_songs:
                type = vz_strings.mtype_Artist_songs;
                break;
            case Songs:
                type = vz_strings.mtype_Songs;
                break;
            case On_The_Go:
                type = vz_strings.mtype_On_The_Go;
                break;
            case Favorites:
                type = vz_strings.mtype_Favorites;
                break;
            case Genres:
                type = vz_strings.mtype_Genres;
                break;
            case Genre:
                type = vz_strings.mtype_Genre;
                break;
            case Any_Playlist:
                type = vz_strings.mtype_Any_Playlists;
                break;
        }
        System.out.println(type);
        return type;
    }
    /**
     * Get the count of items within the section in the list view.
     *
     * @param section The section to get the count from, section can be gotten from the inspector, eg: "section - 1, row - 1"
     * @return Returns the count of items within the given section
     * @author Alen Kalac
     */
    public int getCountInSection(int section) {
        int count = 0;
        //increase detection accuracy.
        for (int i = 0; i < 2; i++)
            count = driver.findElements(MobileBy.iOSNsPredicateString("wdName CONTAINS \'section - " + section + "\'")).size();
        return count;
    }

    /**
     * Checks if there is a favorite section in a view
     *
     * @return Returns true if favorite section exists in the list, otherwise false
     * @throws Exception
     * @author Alen Kalac
     */
    public boolean hasFavorites() {
		try {
			int count = 0;
			//increase the detection accuracy.
			for(int i = 0; i < 2; i++)
                count = baseControlsHelper.getCountById(vz_strings.group_favorites);
            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Returns the list of "All Documents".
     *
     * @param view View in which the list view is found.
     * @return Returns a list of MobileElements from the listView
     * <p>
     * TODO: implement other views if needed
     * @author Alen Kalac
     */
    public List<WebElement> getAllElements(String view) {
    		//skip the favorites section
    		//playlist has favorites as a list item with a sub list
    		//music doesn't show favorites label anywhere other than playlist so list always starts at 0 s
    		if(this.hasFavorites() && !view.contains("Music"))
    			list.addAll(getItemsRecursive(1));
    		else
    			list.addAll(getItemsRecursive(0));
    	return list;
    }

    /**
     * Recursively look through the list view for all sections
     *
     * @param section Section to pull items from, found in inspector eg: "section - 1, row - 1"
     * @return Returns a list of all the elements from the list view, this does not include a favorite list
     * @author Alen Kalac
     */
    private List<WebElement> getItemsRecursive(int section) {
        List<WebElement> list = new ArrayList<>();
        if (this.getCountInSection(section) == 0) return list;
        list = driver.findElements(AppiumBy.iOSNsPredicateString("wdName CONTAINS 'section - " + section + "\'"));
        list.addAll(getItemsRecursive(section + 1));
        return list;
    }


    /**
     * Gets the elements from the favorite section
     *
     * @return Returns the list of all items in the favorite section
     * @author Alen Kalac
     */
    public List<WebElement> getFavoriteElements() {
    	if(this.hasFavorites())
    		list = driver.findElements(AppiumBy.iOSNsPredicateString("wdName CONTAINS \'section - 0\'"));
    	return list;
    }
    
    /**
     * Removes all the items from the favorite section, removes 6 at a time from the favorite menu
     * @author Alen Kalac
     * @throws Exception
     */
    public void removeAllFavorites() throws Exception {
    	while(this.hasFavorites()) {
    		int count = this.getCountInSection(0);
            baseControlsHelper.openContext(vz_strings.context_select);
            for (int i = 0; i < count; i++) {
                baseControlsHelper.clickOnNameContains("section - 0, row - " + i);
                if (i > 5) break;
            }
            baseControlsHelper.openContext(vz_strings.context_removeFavorite);
            baseControlsHelper.waitForDismiss(vz_strings.toast_removeFromFavorite);
        }
        baseControlsHelper.waitForDismiss(vz_strings.group_favorites);
    }

    public String[] infoValues(String infotype) throws Exception {
        baseControlsHelper.openContext(vz_strings.context_select);
        baseControlsHelper.clickOnNameContains("section - 0, row - 0");
        baseControlsHelper.openContext(vz_strings.context_info);
        String before = baseControlsHelper.infoItems(infotype);
        baseControlsHelper.tapOnBackButton();
        baseControlsHelper.openContext(vz_strings.context_select);
        baseControlsHelper.clickOnNameContains("section - 0, row - 1");
        baseControlsHelper.openContext(vz_strings.context_info);
        String after = baseControlsHelper.infoItems(infotype);
        baseControlsHelper.tapOnBackButton();
        String ar[] = new String[2];
        ar[0] = before;
        ar[1] = after;
        return ar;
    }

    public void SelectMultiItem(int index) throws Exception {
        baseControlsHelper.clickOn(vz_strings.context_menu);
        baseControlsHelper.clickOn(vz_strings.context_select);
        for (int i = 0; i < index; i++) {
            baseControlsHelper.clickOnNameContains("section - 0, row - " + i);
        }
    }

    public void removeFavorites() throws Exception {
        if (baseControlsHelper.getCountById(vz_strings.files_favorite) != 0) {
            baseControlsHelper.clickOn(vz_strings.context_menu);
            baseControlsHelper.clickOn(vz_strings.context_select);
            int count = baseControlsHelper.getCountById(vz_strings.files_favorite);
            for (int i = 0; i < count; i++) {
                baseControlsHelper.clickOnNameContains("section - 0, row - " + i);
            }
            baseControlsHelper.openContext(vz_strings.context_removeFavorite);
            baseControlsHelper.waitForDismiss(vz_strings.toast_removeFromFavorite);
        }
    }

    public void multiFavorite(int index) throws Exception {
        SelectMultiItem(index);
        baseControlsHelper.openContext(vz_strings.context_addFavorite);
        baseControlsHelper.waitForDismiss(vz_strings.toast_addtoFavorite);
    }

    //list view item contains icon such as menu_active_indicator.png or favorites.png
    public int itemContainsIconCount(String item, String iconName) throws Exception {
    	WebElement element = driver.findElement(AppiumBy.iOSNsPredicateString("name CONTAINS \'" +  item + "\' AND type == \'XCUIElementTypeCell\'"));
        List<WebElement> icons = element.findElements(AppiumBy.accessibilityId(iconName));
        return icons.size();
    }
}
