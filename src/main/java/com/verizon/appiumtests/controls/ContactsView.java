package com.verizon.appiumtests.controls;

//import com.sncr.verizon.appiumtests.constants.EmailAndMessageUtils;
import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.driver.BaseDriver;
import io.appium.java_client.AppiumDriver;

public class ContactsView {
	AppiumDriver driver = BaseDriver.getDriver();
	BaseControlsHelper baseControlsHelper = new BaseControlsHelper(driver);
	NativeIosAppsView nativeIosAppsView = new NativeIosAppsView(driver);

	public ContactsView(AppiumDriver driver) {
		this.driver = driver;
	}

	/*
	 * public void addRequiredNumberOfContacts(int count) throws Exception {
	 * HomeScreenView homeScreenView = new HomeScreenView(driver);
	 * baseControlsHelper.clickOn(vz_strings.navi_icon); if
	 * (baseControlsHelper.getCountByNameContains("Contacts (") != 0) { String
	 * contactsCount = baseControlsHelper.getTextByNameContains("Contacts (");
	 * System.out.println("got" + contactsCount);
	 * baseControlsHelper.clickOnNameBeginswith(vz_strings.navi_home); if (new
	 * Scanner(contactsCount).useDelimiter("[^\\d]+").nextInt() < count) {
	 * nativeIosAppsView.addContacts(count, "Sync" +
	 * nativeIosAppsView.currentTime(), EmailAndMessageUtils.randomMobileNumber());
	 * //nativeIosAppsView.addContacts(count, "Sync" +
	 * BaseDriver.getDriver().getDeviceTime(),
	 * EmailAndMessageUtils.randomMobileNumber()); // getDeviceTime() is deprecated
	 * in Java client 8.0.0 homeScreenView.backUp();
	 * 
	 * } } else { nativeIosAppsView.addContacts(count, "Sync" +
	 * nativeIosAppsView.currentTime(), EmailAndMessageUtils.randomMobileNumber());
	 * homeScreenView.backUp(); } }
	 */
	public void clickOncontactsListView() throws Exception {
		HomeScreenView homeScreenView = new HomeScreenView(driver);
		homeScreenView.navigateTo(vz_strings.navi_contacts);
		Thread.sleep(5000);
		baseControlsHelper.clickOn("ListView");
	}

}
