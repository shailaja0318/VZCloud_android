package com.verizon.appiumtests.servercalls;

import com.verizon.appiumtests.constants.vz_serverConfigs;
import com.verizon.appiumtests.constants.vz_serverConfigs.SanitizeType;
import com.verizon.appiumtests.controls.LocalyticsHelper;
import com.verizon.appiumtests.driver.BaseDriver;

import java.io.File;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by anlin.tang on 26/01/16. 
 * Updated by Alen Kalac on 18/07/17
 */
public class VZServerMDN {

	private String host;
	private String lcid;
	private String token;
	
	private static VZServerMDN MDNInstance = null;
	
	public String getHost() {
		return host;
	}
	
	public String getLCID() {
		return lcid;
	}
	
	public String getToken() {
		return token;
	}
	
	//Singleton
	private VZServerMDN() throws Exception {
		System.out.println("Creating a new instance of MDN");
		LocalyticsHelper localyticsHelper = new LocalyticsHelper(BaseDriver.getDriver());
		getMDNInfo(localyticsHelper.getLogs());
	}
	
	public static VZServerMDN getInstance() throws Exception {
		if(MDNInstance == null) {
			MDNInstance = new VZServerMDN();
		}
		return MDNInstance;
	}

	public void getMDNInfo(String logs) throws Exception {

		String sBreak = logs.substring(1, 4);
		String s = logs.replace(sBreak, "\n" + sBreak);
		String[] arr = s.split("\\r?\\n");

		boolean urlFound = false;
		boolean tokenFound = false;
		for (String line : arr) {
			if (!urlFound && line.matches(".*https://.*.com/dv/api/user/.*/*")) {
				host = sanitizeString(line, SanitizeType.HOST);
				lcid = sanitizeString(line, SanitizeType.LCID);
				urlFound = true;
			} else if (!tokenFound && line.contains(vz_serverConfigs.token_filter)) {
				token = sanitizeString(line, SanitizeType.TOKEN);
				tokenFound = true;
			}
			if (urlFound && tokenFound)
				break;
		}
		if (!(urlFound && tokenFound)) {
			File file = new File("logs.txt");
			FileWriter f = new FileWriter(file);
			f.write(s);
			f.close();
			throw new NullPointerException();
		}
	}

	/**
	 * Parses the data and sanitizes it.
	 * 
	 * @param data
	 *            Text to sanitize
	 * @param sanitizeType
	 *            Type of content to return.
	 * @author Alen Kalac
	 * @return
	 * 
	 */
	private String sanitizeString(String data, SanitizeType sanitizeType) {
		String sanitizedString = "";
		switch (sanitizeType) {
		case HOST: {
			sanitizedString = data.substring(data.indexOf("https"), data.indexOf("/dv/"));
			break;
		}
		case LCID: {
			Pattern pattern = Pattern.compile("/[a-z0-9]{32}/");
			Matcher match = pattern.matcher(data);
			if (match.find())
				sanitizedString = match.group();
			sanitizedString = sanitizedString.replace("/", "");
			break;
		}
		case TOKEN: {
			int p1 = data.indexOf(vz_serverConfigs.token_filter);
			int p2 = data.indexOf("\" authVersion=");
			data = data.substring(p1, p2);
			data = data.replace(vz_serverConfigs.token_filter, "");
			// NOTE:
			/*
			 * that sometimes there are unicode characters added to the token
			 * in the logs such as \134"....."\134 authVersion=\134"1.0"\134,
			 * they are completely unnecessary but i'm not sure if its always
			 * \134 or if it change, so this makes sure that there is nothing
			 * before the first quotation mark.
			 */
			int indexOfQuote = data.indexOf("\"");
			if (indexOfQuote > 0) {
				String sReplace = data.substring(0, indexOfQuote);
				data = data.replace(sReplace, "");
			}
			sanitizedString = "NWB token=" + data + vz_serverConfigs.auth_version;
		}
		default:
			break;
		}

		System.out.println("Sanitized " + sanitizeType + " " + sanitizedString);
		return sanitizedString;
	}
}
