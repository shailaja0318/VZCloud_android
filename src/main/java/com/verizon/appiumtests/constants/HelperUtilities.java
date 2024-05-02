package com.verizon.appiumtests.constants;

/*import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static com.verizon.appiumtests.constants.vz_strings.Vz_configs.*;

public class HelperUtilities {

    public static String getIP() {
        String IPAddr = null;
        try {
            InetAddress IP = InetAddress.getLocalHost();
            IPAddr = IP.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return IPAddr;
    }

    public static String appUrl() {
        return System.getProperty("user.dir");
    }

    public static String readUdid() {
        String s = null;
        String udid = null;
        try {
            //Process p = Runtime.getRuntime().exec("ideviceinfo -k UniqueDeviceID");
            Process p = Runtime.getRuntime().exec("/usr/local/bin/idevice_id -l");
            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(p.getErrorStream()));

            // read the output from the command
            System.out.println("UDID of the device connected:");
            while ((s = stdInput.readLine()) != null) {
                udid = s;
                System.out.println(s);
            }

            while ((s = stdError.readLine()) != null) {
                System.out.println("ERROR:\n");
                System.out.println(s);
            }
            //System.exit(0);
        } catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            System.exit(-1);
        }
        return udid;
    }

    public static String executeCommand(String command) {
        String s = null;
        String result=null;
        try {
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            // read the output from the command
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
                result=s;
                break;
            }
            // read any errors from the attempted command
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
                result=s;
            }
        } catch (IOException e) {
            System.out.println("Exception raised: ");
            e.printStackTrace();
        }
        return result;
    }

    public static void replaceAppOnSimulator(String appPath) throws Exception {
        System.out.println("Replacing app");
        executeCommand("xcrun simctl install booted " + appPath);
        Thread.sleep(5000);

    }

    public static void setupDevice() throws Exception {
        if (DEVICE_NAME.contains("Au")) {
            replaceAppOnDevice(appUrl() + File.separator + FILE_NAME);
        }
    }

    public static void replaceAppOnDevice(String appPath) {
        System.out.println("Replacing app");
        executeCommand("/usr/local/bin/ideviceinstaller -u " + UDID + " -i " + appPath);

    }

    public static void setupSimulator() throws Exception {
        if (DEVICE_NAME.contains("iP")) {
            killSimulator();
            launchSimlator();
            replaceAppOnSimulator(appUrl() + File.separator + FILE_NAME);
        }
    }

    public static void killSimulator() throws Exception {
        System.out.println("Killing simulators");
        executeCommand("/usr/bin/killall " + "Simulator");
    }

    public static void launchSimlator() throws Exception {
        System.out.println("Launching " + DEVICE_NAME + " " + PLATFORM_VERSION);
        executeCommand("/usr/bin/instruments " + "-w " + DEVICE_NAME + " (" + PLATFORM_VERSION + ")");
        Thread.sleep(10000);
    }

	/*
	 * public static void startService() throws Exception {
	 * System.out.println("Starting Appium Server"); CommandLine commandLine = new
	 * CommandLine("/usr/local/bin/node");
	 * commandLine.addArgument("/usr/local/bin/appium");
	 * commandLine.addArgument("--log-level"); commandLine.addArgument("error");
	 * DefaultExecuteResultHandler resultHandler = new
	 * DefaultExecuteResultHandler(); Executor executor = new DefaultExecutor();
	 * executor.setExitValue(1); executor.execute(commandLine, resultHandler);
	 * waitForAppiumtoStart(); Thread.sleep(5000); }
	 */
	/*
	 * public static void waitForAppiumtoStart() throws Exception { while
	 * (!isServerUp()) { System.out.println("Trying again in 2 seconds");
	 * Thread.sleep(2000); } }
	 */

    public static void killAllNode() {
        System.out.println("Killing Appium Server");
        executeCommand("/usr/bin/killall" + " -KILL" + " node");
    }

    public static void removeApp() throws Exception {
        System.out.println("Removing App");
        executeCommand("xcrun simctl uninstall booted com.synchronoss.vz.cloud");
        Thread.sleep(1000);
    }

	/*
	 * public static boolean isServerUp() {
	 * 
	 * String ServerURL = "http://localhost:4723/wd/hub/status"; StringBuilder
	 * result = new StringBuilder(); CloseableHttpClient httpclient = null;
	 * CloseableHttpResponse response = null; String status = null; try { httpclient
	 * = HttpClients.createDefault();
	 * 
	 * ServerURL = ServerURL.replace("%%", "").trim(); HttpGet GetRequest = new
	 * HttpGet(ServerURL); try { response = httpclient.execute(GetRequest); status =
	 * response.getStatusLine().toString(); System.out.println(status);
	 * 
	 * } catch (HttpHostConnectException h) {
	 * System.out.println("Couldn't connect to host: " + ServerURL); return false; }
	 * 
	 * BufferedReader rd = null; try { rd = new BufferedReader(new
	 * InputStreamReader(response.getEntity().getContent())); } catch
	 * (NullPointerException e) { System.out.println("no response received.. ");
	 * return false; }
	 * 
	 * if (rd != null) { String line = ""; while ((line = rd.readLine()) != null) {
	 * result.append(line); } } } catch (Exception e) { } finally { try {
	 * response.close(); httpclient.close(); } catch (Exception e) { } } return
	 * true; }
	 */
    public static File getPathToIpa(){
        File appDir = new File(appUrl());
        File app = new File(appDir, FILE_NAME);
        return app;
    }

    public static String[] getCurrentDate() {
        String currentDate;
        Date d = Calendar.getInstance().getTime();
        DateFormat df = new SimpleDateFormat("MMM d h a");
        currentDate = df.format(d);
        return currentDate.split(" ");
    }

    public static ArrayList<String> setArguments(String... args) {
        ArrayList<String> parameters = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            parameters.add(args[i]);
        }
        return parameters;
    }
}
