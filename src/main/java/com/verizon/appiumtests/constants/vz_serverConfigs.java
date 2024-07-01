package com.verizon.appiumtests.constants;

/**
 * Created by anlin.tang on 12/01/16.
 * Updated by Sarthak Samal.
 */
public class vz_serverConfigs {

	public enum SanitizeType{ HOST, LCID, TOKEN}

    public final static String token_filter = "Authorization = \"NWB token=";
	public final static String auth_version = "\" authVersion=\"1.0\"";
	public final static String vzRepo = "TestREPO";
    public final static String dvHeader_Accept1_15 = "application/vnd.newbay.dv-1.15+xml";
    public final static String dvHeader_Accept1_0 = "application/vnd.newbay.dv-1.0+xml";
    public final static String dvHeader_Accept1_19 = "application/vnd.newbay.dv-1.19+xml";
    public final static String photoFileName = "green.jpg";
    public final static String musicFileName = "BuildTower.mp3";
    public final static String textFileName = "Apps-Prefs.txt";
    public final static String resourcesPath = "/src/test/resources/data";
    public final static String photoPath = resourcesPath + "/images/";
    public final static String documentPath = resourcesPath + "/documents/";
    public final static String musicPath = resourcesPath + "/music/";
    public final static String xmlFileName = "imageXmlFile.xml";
    public final static String videoPath = resourcesPath + "/videos/";
    public final static String videoFileName = "video-01.mp4"; //xx
}
