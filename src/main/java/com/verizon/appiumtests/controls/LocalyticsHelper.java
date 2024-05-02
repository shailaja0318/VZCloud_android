package com.verizon.appiumtests.controls;

import com.verizon.appiumtests.driver.BaseDriver;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.logging.LogEntry;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LocalyticsHelper {
	private final static Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

	AppiumDriver driver = BaseDriver.getDriver();

	public LocalyticsHelper(AppiumDriver driver) {
		this.driver = driver;
	}

	private String logs;

	public String getLogs() throws Exception {
		Thread.sleep(3000);
		List<LogEntry> logEntries;
		logEntries = driver.manage().logs().get("syslog").getAll();
		logs = logEntries.toString();
		return logs;
	}

	public int getCountOf(String logs, String context) {
		int count;
		count = StringUtils.countMatches(logs, context);
		return count;
	}

	public boolean isExisted(String logs, String context) {
		boolean isExsited;
		isExsited = StringUtils.countMatches(logs, context) > 0;
		return isExsited;
	}

	//This method make sure that String appear only once, not word as in getCountOf
	public int getPatternMatch(String logs, String context) {
		int i = 0;
		Pattern p = Pattern.compile(context);
		Matcher m = p.matcher(logs);
		while (m.find()) i++;
		return i;
	}

	public void print(String logs, String context) {
		String sBreak = logs.substring(1, 4);
		String s = logs.replace(sBreak, "\n" + sBreak);
		String[] arr = s.split("\\r?\\n");

		for (int i = 0; i < arr.length; i++) {
			if (arr[i].contains(context)) {
				logger.info(arr[i - 1]);
				logger.info(arr[i]);
				if (i < arr.length - 2
						&& arr[i + 1].contains("attributes")
						&& arr[i + 2].contains("{")) {
					for (int j = i + 1; j < arr.length; j++) {
						logger.info(arr[j]);
						if (arr[j].contains("}"))
							break;
					}
				}
			}
		}
	}
/*	public void print(String logs, String context) {
		String s = logs.replace("[2019", "\n[2019");  // Change year value based on the present year
		String[] arr = s.split("\\r?\\n");
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].contains(context)) {
				System.out.println(arr[i - 1]);
				System.out.println(arr[i]);
				if ( i < arr.length - 2
						&& arr[i + 1].contains("params")
						&& arr[i + 2].contains("{")) {
					for (int j = i + 1; j < arr.length; j++) {
						System.out.println(arr[j]);
						if (arr[j].contains("}"))
							break;
					}
				}
			}
		}
	}*/

	public List<String> dynamicCount(String logs, String context) throws Exception {
		String dynamic = null;
		ArrayList<String> arrl = new ArrayList<>();
		String sBreak = logs.substring(1, 4);
		String s = logs.replace(sBreak, "\n" + sBreak);
		String[] arr = s.split("\\r?\\n");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].contains(context)) {
				if ((arr[i+1].contains("}"))||(arr[i+2].contains("}"))||(arr[i+3].contains("}"))) {
					Pattern p = Pattern.compile("=([^;]*)");
					Matcher m = p.matcher(arr[i]);
					while (m.find()) {
						dynamic = m.group();
						arrl.add(dynamic);
						System.out.println("Appium Helper Dynamic count of " + context + " " + dynamic);
					}
				}
			}
		}
		return arrl;
	}
}
