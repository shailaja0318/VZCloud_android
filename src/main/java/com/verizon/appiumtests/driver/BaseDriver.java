package com.verizon.appiumtests.driver;

import com.verizon.appiumtests.constants.HelperUtilities;
import com.verizon.appiumtests.constants.vz_strings;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.logging.LogEntry;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.invoke.MethodHandles;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseDriver {
	private final static Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());
	public static int defaultImgHeight = 320;
	public static Integer HTML_IMG_WIDTH = 300;
	//protected static AppiumDriver driver;

	public BaseDriver() {
	}
	protected static IOSDriver driver;

	public static IOSDriver getDriver() {
		return driver;
	}

	public static void setDriver(IOSDriver driver) {
		BaseDriver.driver = driver;
	}

	public static void launchApp() throws MalformedURLException {
		if (getDriver() == null) {
			XCUITestOptions options = new XCUITestOptions();
			options.setDeviceName(vz_strings.Vz_configs.DEVICE_NAME);
			options.setPlatformVersion(vz_strings.Vz_configs.PLATFORM_VERSION);
			options.setWdaLaunchTimeout(Duration.ofSeconds(20));
			options.setCapability("xcodeOrgId", "QBAM5SN9DR");
			options.setCapability("xcodeSigningId", "iPhone Developer");
			options.setCapability("udid", vz_strings.Vz_configs.UDID);
			setDriver(new IOSDriver(new URL("http://127.0.0.1:4723/"), options));
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Map<String, String> params = new HashMap<String, String>();
			params.put("bundleId", "com.synchronoss.vz.cloud");
			driver.executeScript("mobile:launchApp", params);

		}
	}

	public static void quitDriver() {
		if (getDriver() != null) {
			getDriver().quit();
			setDriver(null);
		}
	}

	public static void captureLog(String testName) throws Exception {
		DateFormat df = new SimpleDateFormat("dd_MM_yyyy_HH-mm-ss");
		Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(today);
		String logPath = "/Users/slel0001/iosCloud/ioscloudautomation/logs/";
		logger.info(driver.getSessionId() + ": Saving device log...");
		List<LogEntry> logEntries = driver.manage().logs().get("syslog").getAll();
		// filter(Level.ALL);
		String logs = logEntries.toString();
		String slogs = logs.replace("[2023", "\n[2023"); // Change year value based on the present year

		File logFile = new File(logPath + reportDate + "_" + testName + ".log");
		PrintWriter log_file_writer = new PrintWriter(logFile);
		log_file_writer.println(slogs);
		log_file_writer.flush();
		logger.info(driver.getSessionId() + ": Saving device log - Done.");

	}

	/**
	 * Verifies whether the application with given bundle identifier is installed on
	 * the device.
	 *
	 * @param bundleId The bundle identifier of the application, which is going to
	 *                 be verified. Mandatory argument.
	 * @return Returns true or false
	 */
	public static final boolean isAppInstalled(String bundleId) {
		Map<String, Object> params = new HashMap<>();
		params.put("bundleId", bundleId);
		return (Boolean) driver.executeScript("mobile: isAppInstalled", params);
	}

	/**
	 * Executes an existing application on the device. If the application is already
	 * running then it will be brought to the foreground.
	 *
	 * @param bundleId
	 */
	public static final void lanuchApp(String bundleId) {
		Map<String, Object> params = new HashMap<>();
		params.put("bundleId", bundleId);
		driver.executeScript("mobile: launchApp", params);
	}

	/**
	 * Installs given application to the device under test. If the same application
	 * is already installed then it's going to be installed over the existing one,
	 * which allows you to test upgrades. Be careful while reinstalling the main
	 * application under test: make sure that terminateApp has been called first,
	 * otherwise WebDriverAgent will detect the state as a potential crash of the
	 * application.
	 */
	public static final void installApp() {
		Map<String, Object> params = new HashMap<>();
		params.put("bundleId", "pathtoapporipa");
		driver.executeScript("mobile: installApp", params);
	}

	/**
	 * Uninstalls an existing application from the device under test. This endpoint
	 * does not verify whether the application is already installed or not before
	 * uninstalling it.
	 *
	 * @param bundleId
	 */
	public static final void removeApp(String bundleId) {
		Map<String, Object> params = new HashMap<>();
		params.put("bundleId", bundleId);
		driver.executeScript("mobile: removeApp", params);
	}

	/**
	 * Terminates an existing application on the device. If the application is not
	 * running then the returned result will be false, otherwise true.
	 *
	 * @param bundleId
	 */

	public static final void terminateApp(String bundleId) {
		Map<String, Object> params = new HashMap<>();
		params.put("bundleId", bundleId);
		driver.executeScript("mobile: terminateApp", params);
	}

	/**
	 * Activates an existing application on the device under test and moves it to
	 * the foreground. The application should be already running in order to
	 * activate it. The call is ignored if the application is already in foreground
	 *
	 * @param bundleId
	 */
	public static final void activateApp(String bundleId) {
		Map<String, Object> params = new HashMap<>();
		params.put("bundleId", bundleId);
		driver.executeScript("mobile: activateApp", params);
	}

	/**
	 * /** 0: The current application state cannot be determined/is unknown 1: The
	 * application is not running 2: The application is running in the background
	 * and is suspended 3: The application is running in the background and is not
	 * suspended 4: The application is running in the foreground
	 *
	 * @param bundleId
	 * @return
	 */
	public static final Long queryAppState(String bundleId) {
		Map<String, Object> params = new HashMap<>();
		params.put("bundleId", bundleId);
		return (Long) driver.executeScript("mobile: queryAppState", params);
	}

	public static final void runAppInBackground(int duration) {

		((IOSDriver) driver).runAppInBackground(Duration.ofSeconds(duration));
	}

	public static String takeScreenshotAppium(String screenshotPath, String imageName) {
		File srcFile = getDriver().getScreenshotAs(OutputType.FILE);
		imageName = imageName + ".png";
		File dstFile = new File(screenshotPath, imageName);
		try {
			FileUtils.copyFile(srcFile, dstFile, true);
			if (!srcFile.delete()) {
				logger.error(String.format("Failed to delete source file (%s)", srcFile.toString()));
			}
		} catch (IOException e) {
			logger.error(e);
			return null;
		}
		try {
			if (defaultImgHeight > 0) {
				resizeImageHeight(dstFile.toString(), defaultImgHeight);
			}
			String format = getFormatImage(dstFile.toString());
			Pattern pattern = Pattern.compile("\\s*format: (\\w*)");
			Matcher matcher = pattern.matcher(format);
			if (matcher.find() && matcher.group(1).equals("tiff")) {
				logger.info("Converting image to png format");
				transformImageToPng(dstFile.toString());
			}
		} catch (Exception e) {
			logger.error("Exception occurred rotating screenshot", e);
			return null;
		}

		String link = dstFile.toString();
		Reporter.log(String.format("<a href='%s'><img width=%d src='%s'></a>", imageName, HTML_IMG_WIDTH, link));
		return dstFile.toString();
	}

	/**
	 * Used to set up the resize of image to a height.
	 *
	 * @param pathToImage canonical path
	 * @param height      as int
	 * @throws IOException if any error occurs converting the output image
	 */
	public static void resizeImageHeight(String pathToImage, int height) throws IOException {
		String command;
		String hostOs = System.getProperty("os.name");

		switch (hostOs) {
		case "Linux":
			command = "/usr/bin/convert " + pathToImage + " -resize x " + height + " " + pathToImage;
			break;
		case "Mac OS X":
			command = "sips -Z " + height + " " + pathToImage;
			break;
		default:
			command = null;
			break;
		}

		if (command != null) {
			HelperUtilities.executeCommand(command);
		} else {
			logger.error("resizeImageHeight is not supported on " + hostOs);
		}
	}

	/**
	 * iOS capture images in .tiff format. The report is using png format.
	 *
	 * @param pathToImage canonical path
	 * @throws IOException if any error occurs converting the output image
	 */
	public static void transformImageToPng(String pathToImage) throws IOException {
		String hostOs = System.getProperty("os.name");

		if (hostOs.equals("Mac OS X")) {
			String command = "sips -s format png " + pathToImage + "--out " + pathToImage;
			HelperUtilities.executeCommand(command);
		} else {
			logger.error("transformImageToPng is not supported on " + hostOs);
		}
	}

	/**
	 * Returns the format of the image.
	 *
	 * @param outputImage canonical path
	 * @return the format of the image
	 * @throws IOException if any error occurs finding the format of the image
	 */
	public static String getFormatImage(String outputImage) throws IOException {
		String hostOs = System.getProperty("os.name");
		String output;

		if (hostOs.equals("Mac OS X")) {
			String command = "sips -g format " + outputImage;
			output = HelperUtilities.executeCommand(command);
		} else {
			logger.error("getFormatImage is not supported on " + hostOs);
			output = null;
		}
		return output;
	}

}
