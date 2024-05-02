package com.verizon.appiumtests.controls;

import com.verizon.appiumtests.driver.AppiumBaseClass;
import com.verizon.appiumtests.driver.BaseDriver;
import org.testng.annotations.*;

import static com.verizon.appiumtests.driver.AppiumServer.stopAppiumServer;
import static com.verizon.appiumtests.driver.BaseDriver.launchApp;
import static com.verizon.appiumtests.driver.BaseDriver.quitDriver;

public class BaseTestClass extends AppiumBaseClass {
	//public class BaseTestClass extends BaseMediaTest {

    protected BaseControlsHelper baseControlsHelper;
    protected AllFilesView allFilesView;
    protected ContextualMenu contextualMenu;
    protected DocumentsView documentsView;
    protected GridView gridView;
    protected HomeScreenView homeScreenView;
    protected ListView listView;
    protected LocalyticsHelper localyticsHelper;
    protected MusicView musicView;
    protected PhotosAndVideosView photosAndVideosView;
    protected Preconditions precondition;
    protected ProvisioningView provisioningView;
    protected SettingsView settingsView;
    protected ToolsView toolsView;
    protected WebView webView;
    protected NativeIosAppsView nativeIosAppsView;
    protected ContactsView contactsView;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.out.println(getClass().getSimpleName());
        launchApp();
       
        baseControlsHelper = new BaseControlsHelper(driver());
        allFilesView = new AllFilesView(driver());
        contextualMenu = new ContextualMenu(driver());
        documentsView = new DocumentsView(driver());
        gridView = new GridView(driver());
        homeScreenView = new HomeScreenView(driver());
        listView = new ListView(driver());
        localyticsHelper = new LocalyticsHelper(driver());
        musicView = new MusicView(driver());
        photosAndVideosView = new PhotosAndVideosView(driver());
        precondition = new Preconditions(driver());
        provisioningView = new ProvisioningView(driver());
        settingsView = new SettingsView(driver());
        toolsView = new ToolsView(driver());
        webView = new WebView(driver());
        nativeIosAppsView = new NativeIosAppsView(driver());
        contactsView = new ContactsView(driver());
    }
	/*
	 * @AfterTest(alwaysRun = true) public void close() throws Exception {
	 * BaseDriver.closeApp(); }
	 */
   
    @AfterTest (alwaysRun = true)
    public void quiSession() throws Exception {
    	//BaseDriver.captureLog(getClass().getSimpleName());
        quitDriver();
    	
    }
    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
    	BaseDriver.terminateApp("com.synchronoss.vz.cloud");
    }

    @BeforeSuite
    public void beforeSuite() throws Exception {
       // killAllNode();
       // setupDevice();
        //setupSimulator();
       // buildAppiumService();
       // startAppiumServer();
    }

    @AfterSuite
    public void afterSuite() throws Exception {
        stopAppiumServer();
    }
}

