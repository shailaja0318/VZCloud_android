package com.verizon.appiumtests.listenersReport;

import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ExtentManager {
	private static ExtentReports extent;
	public synchronized static ExtentReports getReporter(){
		if(extent == null){
			DateFormat df = new SimpleDateFormat("dd_MM_yyyy_HH-mm-ss");
			Date today = Calendar.getInstance().getTime();
			String reportDate = df.format(today);
			//Set HTML reporting fiLe location
			String workingDir = "surefire-reports/html/";
	    	new File(workingDir).mkdirs();
	    	//extent = new ExtentReports(workingDir+"/ExtentReports/ExtentReportResults.html", true); 
	    	extent = new ExtentReports(workingDir+"/ExtentReports/"+reportDate+ "_" +"ExtentReportResults"+ ".html", true); 
		}
		return extent;
		}
	}
		
 

