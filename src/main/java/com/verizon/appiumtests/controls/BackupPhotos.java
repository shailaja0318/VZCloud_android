package com.verizon.appiumtests.controls;

import com.verizon.appiumtests.constants.vz_strings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.SupportsContextSwitching;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

public class BackupPhotos {
	
	public static AppiumDriver wdriver;
			
	public static WebDriver wdsetUp() throws MalformedURLException{
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("device", "iPhone Simulator");
		capabilities.setCapability("browserName", "Safari");		
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, vz_strings.Vz_configs.DEVICE_NAME);
		//capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, vz_strings.Vz_configs.PLATFORM_VERSION);
	
		//capabilities.setCapability("platformName", "iOS");
		
		wdriver = new IOSDriver(new URL("http://" + vz_strings.Vz_configs.APPIUM_IP + ":" + vz_strings.Vz_configs.APPIUM_PORT + "/wd/hub"), capabilities);
		wdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(260));
		//.implicitlyWait(260, TimeUnit.SECONDS);
		System.out.println("*******Browser Launched*********");
		return wdriver;

	}

	@SuppressWarnings("unchecked")
	public void saveImage(int times) throws Exception {
	//InterruptedException{
		
		
		JavascriptExecutor js = wdriver;
		WebDriverWait wait = new WebDriverWait(wdriver, Duration.ofSeconds(60));	
					
			for (int i = 0; i < times; i ++){
				
				Set<String> wcontexts = ((SupportsContextSwitching) wdriver).getContextHandles();
					for(String context: wcontexts){
						if(context.contains("WEBVIEW")){
							((SupportsContextSwitching) wdriver).context(context);
						}
					}
				
				System.out.println(((SupportsContextSwitching) wdriver).getContext());
				
				wdriver.get("https://source.unsplash.com/random");
				
				Set<String> ncontexts = ((SupportsContextSwitching) wdriver).getContextHandles();
				for(String context: ncontexts){
					if(context.contains("NATIVE")){
						((SupportsContextSwitching) wdriver).context(context);
					}
				}

		
				System.out.println(((SupportsContextSwitching) wdriver).getContext());
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIAImage[1]")));
			      //old step
				
				MultiTouchAction maction = new MultiTouchAction((PerformsTouchActions) wdriver);
			     BaseControlsHelper baseControlsHelper = new BaseControlsHelper(wdriver);
				Thread.sleep(3000);
				 baseControlsHelper.clickOn("Share");
				 baseControlsHelper.clickOn("Save Image");
			
				
				
				
			   /* int x1 = 181; int y1 = 122;
				TouchAction action1 = new TouchAction((MobileDriver) wdriver).longPress(x1, y1, 2).waitAction(1500);
                System.out.println("Appium Helper Click on " + action1);		
				action1.perform();
				Thread.sleep(3000);
				//click on yes

				int x2 = 174;
				int y2 = 489;
				TouchAction action2 = new TouchAction((MobileDriver) wdriver).longPress(x2, y2, 2).waitAction(1500);
                System.out.println("Appium Helper Click on " + action2);		
				action2.perform();
				Thread.sleep(3000);*/
				
			}
			
		}
			
}
