/**
 * Description:
 * Class that all tests should extend from IF they will utilize Media Client Library.
 * Provide access to
 * 1) AtpClient (Authentication)
 * 2) DvClient (Media Management)
 *
 * @Author: Alen Kalac
 * Updated By: Sarthak Samal
 *//*

package com.sncr.verizon.appiumtests.controls;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.sncr.verizon.appiumtests.constants.vz_serverConfigs;
import com.sncr.verizon.appiumtests.constants.vz_strings;
import com.sncr.verizon.appiumtests.driver.AppiumBaseClass;
import com.sncr.verizon.appiumtests.servercalls.VZServerMDN;
import com.sncr.verizon.appiumtests.servercalls.VZServerRequests;
import com.sncr.verizon.media.clients.AtpClient;
import com.sncr.verizon.media.clients.DvClient;
import com.sncr.verizon.media.clients.DvExtClient;
import com.sncr.verizon.media.model.atp.AtpResponse;
import com.sncr.verizon.nab.clients.WsgClient;
import com.sncr.verizon.nab.clients.WsgClientHelper;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sncr.verizon.appiumtests.constants.vz_serverConfigs.photoPath;
import static com.sncr.verizon.appiumtests.constants.vz_serverConfigs.videoPath;
import static com.sncr.verizon.appiumtests.constants.vz_strings.Production.*;


@SpringBootTest
@ContextConfiguration(classes = Application.class)
public class BaseMediaTest extends AppiumBaseClass {
    private final static Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private static boolean isPortOpen = false;
    private static JSch jSch = new JSch();
    //Contains LCID and can be used within any test case.
    public String lcid = null;
    //Contains AccessToken that is required by most dv calls.
    public String accessToken = null;
    public String authToken = "";
    public String nabToken = "";
    public String refreshToken = "";
    public String locationURI;
    protected Session session;
    *//**
     * Used for Authentication. Use within actual @Test cases
     * Usage:
     * AtpResponse response = atpClient.executeCCOERequest(mdn, ip);
     * lcid - response.getAuthDetails().getLcid()
     * token - response.getAuthDetails().getToken()
     *//*
    @Autowired
    protected AtpClient atpClient;
    *//**
     * DV is used for Uploading media to the server.
     * Usage:
     * dvClient.createRepository(repoName, lcid, token);
     * dvClient.uploadFile(filePath, repoName, lcid, token);
     *//*
    @Autowired
    protected DvClient dvClient;

    @Autowired
    protected WsgClientHelper wsgClientHelper;

    @Autowired
    protected WsgClient wsgClient;

    @Autowired
    protected DvExtClient dvExtClient;
    *//**
     * These are set in resources/application.properties
     *//*
    @Value("${msisdn}")
    protected String msisdn;
    @Value("${user.ip}")
    protected String userIP;
    @Value("${nab.type}")
    protected String nabType;
    @Value("${repo.name}")
    protected String repoName;
    String addContact = System.getProperty("user.dir") + "/src/test/resources/data/contacts/addContact.xml";
    //Contains additional information regarding ATP. such as token expiry time.
    private AtpResponse response = null;
    private Response responses = null;

    *//**
     * Authenticate the user with ATP calls
     *//*
    private void authenticate() {
        if (response == null) {
            response = atpClient.executeCCOERequest(msisdn, userIP);
        }
    }

    *//**
     * LCID is a unique user id that is required by API.
     *
     * @return Returns LCID that can be used for DV calls to upload/update/delete content
     *//*
    public String getLcid() {
        if (lcid == null)
            lcid = getAtpResponse().getAuthDetails().getLcid();
        return lcid;
    }

    *//**
     * Access token is required when making calls that require authentication
     *
     * @return The access token for the current session. Changes every now and then.
     *//*
    public String getAccessToken() {
        if (accessToken == null)
            accessToken = getAtpResponse().getAuthDetails().getAccessToken();
        return accessToken;
    }

    *//**
     * Response contains additional information about the ATP call after Authentication. Information such as
     * token expiry time can be accessed through the response.
     *
     * @return The AtpResponse containing additional information.
     *//*
    public AtpResponse getAtpResponse() {
        if (response == null)
            authenticate();
        return response;
    }

    protected void openSSHConnection(String privateKey, String user, String hostName, int tunnelPort,
                                     String tunnelHost) {
        try {
            jSch.addIdentity(privateKey);
            session = jSch.getSession(user, hostName, 22);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            session.setPortForwardingL(tunnelPort, tunnelHost, tunnelPort);
            logger.info("Tunnel opened successfully");
        } catch (JSchException e) {
            logger.info("Error occurred while opening tunnel: {}", e);
        }
    }

    public void suiteSetUp() throws IOException {
        FileUtils.deleteDirectory(new File(vz_strings.Constants.THREAD_LOG_DIRECTORY));
        if (!isPortOpen) {
            openSSHConnection(PROD_IDENTITY_FILE, PROD_USER, PROD_HOSTNAME, PROD_ATP_PORT, PROD_RPG_HOST);
            openSSHConnection(PROD_IDENTITY_FILE, PROD_USER, PROD_HOSTNAME, PROD_RPG_PORT, PROD_RPG_HOST);
            openSSHConnection(PROD_IDENTITY_FILE, PROD_USER, PROD_HOSTNAME, PROD_LS_PORT, PROD_LS_HOST);

            isPortOpen = true;
        }
    }

    protected void closeSSHConnection() {
        session.disconnect();
        logger.info("Tunnel closed successfully!");
    }

    public void closeSSH() {
        closeSSHConnection();
    }

    ////.....Contacts....////
    private void setLcid(String lcid) {
        logger.info("setting LCID: " + lcid);
        this.lcid = lcid;
    }

    private void setAuthToken(String authToken) {
        logger.info("setting authtoken: " + authToken);
        this.authToken = authToken;
    }

    private void setRefreshToken(String refreshToken) {
        logger.info("setting refreshToken: " + refreshToken);
        this.refreshToken = refreshToken;
    }

    private void setNabToken(String nabToken) {
        logger.info("setting nabToken: " + nabToken);
        this.nabToken = nabToken;
    }

    private void setLocationURI(String locURI) {
        logger.info("setting LocationURI: " + locURI);
        this.locationURI = locURI;
    }

    *//**
     * Method to getToken from wsg server
     *
     * @param msisdn - username of account
     * @param pass   - password of a account
     * @return boolean, false on fail or true on success
     *//*
    public boolean doWsgGetTokenCall(String msisdn, String pass) {
        wsgClientHelper.setWsgUrlType("PUBLIC");
        wsgClientHelper.setMdn(msisdn);
        wsgClientHelper.setPassword(pass);
        wsgClientHelper.setAccountType("VZW");
        wsgClientHelper.setHeaderType("ICS");
        responses = wsgClient.getTokens();
        int statusCode = responses.getStatusCode();
        if (statusCode != HttpStatus.SC_OK) {
            logger.info("Backend authentication is failed with error: " + statusCode);
            return false;
        }
        logger.info("Authentication is successful for user: " + msisdn);
        this.setLcid(responses.getBody().xmlPath().getString("account-tokens-get-response.lcid"));
        this.setAuthToken(responses.getBody().xmlPath().getString("account-tokens-get-response.dvtoken"));
        this.setNabToken(responses.getBody().xmlPath().getString("account-tokens-get-response.nabtoken"));
        this.setRefreshToken(responses.getBody().xmlPath().getString("account-tokens-get-response.refreshtoken"));
        this.setLocationURI(responses.getBody().xmlPath().getString("account-tokens-get-response.locationuri"));
        logger.info("Location Uri: " + responses.getBody().xmlPath().getString("account-tokens-get-response.locationuri"));
        wsgClientHelper.setMdn("1" + msisdn);
        return true;
    }

    public void createContacts(int totalContacts){
        String mdn=null; //provide mdn
        String password=null; // provide mdn password
        doWsgGetTokenCall(mdn, password);
        VZServerRequests vzServerRequests = new VZServerRequests();
        try {
            for (int count = 1; count <= totalContacts; count++) {
                CloudContact contact = new CloudContact(count);
                if (nabType.equalsIgnoreCase("f1")) {
                    String contactXml = vzServerRequests.xmlToString(addContact);
                    contactXml = String.format(contactXml, contact.FirstName, contact.LastName, contact.HomePhone, contact.Mobile);
                    createContact(contactXml);
                } else logger.info("Set nab type to F1");
            }
        } catch (Exception e) {
            logger.error("Unable to create contacts \n" + e.getMessage());
        }
    }

    *//**
     * Create contact
     *
     * @param params - String - if F1 nab provide Path to xml File or xml string
     *//*
    public Response createContact(String... params) {
        VZServerRequests vzServerRequests = new VZServerRequests();
        int status = 0;
        if (nabType.equalsIgnoreCase("f1")) {
            wsgClientHelper.setAccountType("SNCR");
            wsgClientHelper.setWsgUrlType("SSO");
            String xmlPath = params[0];
            if (xmlPath.startsWith("<?xml")) {
                wsgClientHelper.setXml(xmlPath);
            } else {
                wsgClientHelper.setXml(vzServerRequests.xmlToString(xmlPath));
            }
            responses = wsgClient.addContacts();
            status = responses.statusCode();
            if (status != HttpStatus.SC_OK) {
                logger.info("Contacts add failed with : " + status);
                logger.error(responses.getBody());
                return null;
            }
        } else {
            logger.error(" set nabType to either F1");
        }
        return responses;
    }

    ////....END OF CONTACTS....////

    *//**
     * get playlist name or uid
     *
     * @param returnType    UID / Name of playlist.
     * @param playlistTypes Type of playlist to fetch.
     * @return specific type of playlist name or uid.
     * @author Sarthak Samal
     *//*
    public List<String> getSpecificPlaylist(String returnType, PlaylistTypes playlistTypes) throws Exception {
        VZServerMDN mdn = VZServerMDN.getInstance();
        List<String> names;
        responses = dvExtClient.getAllUserPlaylist(mdn.getLCID(), mdn.getToken(), playlistTypes.getQueryValue());
        int status = responses.getStatusCode();
        if (status != HttpStatus.SC_OK) {
            logger.info("Error: " + responses.getStatusCode() + "Failed to get playlists");
            logger.error(responses.getBody().prettyPrint());
            return null;
        }
        if (returnType.equalsIgnoreCase("name")) {
            names = responses.getBody().xmlPath().getList("playlistDefinitions.playlistDefinition.name");
            return names;
        } else if (returnType.equalsIgnoreCase("uuid")) {
            names = responses.getBody().xmlPath().getList("playlistDefinitions.playlistDefinition.uid");
            return names;
        } else {
            logger.info("Return type should be 'name' or 'uuid'");
        }
        return null;
    }

    *//**
     * Delete particular playlist
     *
     * @param playlistUID - UID of playlist to delete (UID can be obtained from creating playlist)
     * @return true if success, else false
     * @author Sarthak Samal
     *//*
    public boolean deletePlaylist(String playlistUID) throws Exception {
        VZServerMDN mdn = VZServerMDN.getInstance();
        responses = dvExtClient.deletePlaylist(playlistUID, mdn.getLCID(), mdn.getToken());

        int status = responses.getStatusCode();
        if (status != 200) {
            logger.info("Error: " + responses.getStatusCode() + "Failed to Delete playlist with UID: " + playlistUID);
            logger.error(responses.getBody().prettyPrint());
            return false;
        }
        logger.info("Deleted playlist " + playlistUID);
        return true;
    }

    *//**
     * Method to delete playlist of specific type - image,video,image-video or music
     *
     * @param playlistTypes - PlaylistType Enum
     * @return True if delete is success
     * @author Sarthak Samal
     *//*
    public boolean deletePlaylists(PlaylistTypes playlistTypes) throws Exception {
        boolean success;
        List<String> uuids = getSpecificPlaylist("uuid", playlistTypes);
        if (uuids.size() < 1) {
            logger.info("No playlist to delete");
            return true;
        }
        for (String i : uuids) {
            success = deletePlaylist(i);
            if (!success) {
                logger.info("failed to delete playlist " + i);
                return false;
            }
        }
        return true;
    }

    *//**
     * Search particular file from repo.
     *
     * @param fileName - Name of the file to search.
     * @return Response - null on failure
     * @apiNote Use 'name:filename' query while searching individual file name
     * @author Sarthak Samal
     *//*
    public String searchFile(String fileName) throws Exception {
        VZServerMDN mdn = VZServerMDN.getInstance();
        responses = dvClient.searchFile(fileName, mdn.getLCID(), mdn.getToken());
        if (responses.getStatusCode() != HttpStatus.SC_OK) {
            logger.info(responses.getStatusCode() + " >>> Search file not successfull");
            logger.error(responses.getBody().prettyPrint());
            return null;
        }
        return responses.getBody().xmlPath().get("searchResults.@totalCount");
    }

    *//**
     * Get specific type of media count.
     *
     * @param contentType - Type of data content to fetch.
     * @return media count.
     * @throws Exception
     * @author Sarthak Samal
     *//*
    public int getMediaCount(ContentType contentType) throws Exception {
        String cont = contentType.getQueryValue();
        String response = searchFile(cont);
        return (response != null) ? Integer.parseInt(response) : 0;
    }

    *//**
     * Delete particular file from repo.
     *
     * @param fileName - Name of the file present in repo to delete.
     * @return true if delete success, false if delete fail.
     * @author Sarthak Samal
     *//*
    public boolean deleteRepoFile(String fileName) throws Exception {
        VZServerMDN mdn = VZServerMDN.getInstance();
        VZServerRequests vzServerRequests = new VZServerRequests();
        vzServerRequests.createRepo(vz_serverConfigs.vzRepo);
        responses = dvClient.deleteFile("/" + fileName, repoName, mdn.getLCID(), mdn.getToken());
        if (responses.getStatusCode() != HttpStatus.SC_OK) {
            logger.info("delete file not successfull");
            logger.error(responses.getStatusCode() + " : " + responses.getBody().prettyPrint());
            return false;
        }
        logger.info("delete file successfull");
        return true;
    }

    *//**
     * Create and update all types of playlist.
     *
     * @param playListName   - Name of the playlist to create or update.
     * @param filePaths      - List of the  dv repo file names to pass Ex:TestREPO:/BuildTower.mp3.
     * @param playlistTypes- Type of playlist to create.
     * @param playlistID     - Pass playlistID for updating playlist & pass null for creating new playlist.
     * @return playlistID
     * @throws Exception
     * @author Sarthak Samal
     *//*
    public String createAndUpdatePlayLists(String playListName, List<String> filePaths, PlaylistTypes playlistTypes, String playlistID) throws Exception {
        VZServerRequests vzServerRequests = new VZServerRequests();
        vzServerRequests.createRepo(vz_serverConfigs.vzRepo);
        VZServerMDN mdn = VZServerMDN.getInstance();
        responses = dvExtClient.updatePlaylist(playListName, filePaths, playlistTypes.getValue(), playlistID, mdn.getLCID(), mdn.getToken());
        return responses.getBody().xmlPath().getString("playlistDefinition.uid");
    }

    public int getplaylistCount(PlaylistTypes playlistTypes) throws Exception {
        return getSpecificPlaylist("uuid", playlistTypes).size();
    }

    *//**
     * Uploading live photos to cloud
     *
     * @param imageFileName
     * @param videoFileName
     * @throws Exception
     * @author Sarthak Samal
     *//*
    public void uploadLivePhotos(String imageFileName, String videoFileName) throws Exception {
        VZServerMDN mdn = VZServerMDN.getInstance();
        VZServerRequests vzServerRequests = new VZServerRequests();
        vzServerRequests.createRepo(vz_serverConfigs.vzRepo);
        String uri = mdn.getHost() + "/dv/api/user/" + mdn.getLCID() + "/repository/" + vz_serverConfigs.vzRepo + "/file?asyncSupported=true";
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", vz_serverConfigs.dvHeader_Accept1_19);
        headers.put("Content-Type", "multipart/form-data");
        headers.put("Authorization", mdn.getToken());
        headers.put("x-newbay-nwb", mdn.getToken());
        headers.put("X-Client-Identifier", "IOSTEST");
        headers.put("X-Client-Platform", "IOS");
        headers.put("x-ingest-tag", "RI");
        String projectPath = System.getProperty("user.dir");
        File imageFile = new File(projectPath + photoPath + imageFileName);
        File videoFile = new File(projectPath + videoPath + videoFileName);
        String checksum = vzServerRequests.createPhotosAndVideosContent(imageFile)[1];
        File xmlFile = vzServerRequests.createLivePhotoXMLfile(imageFile, videoFile, checksum);
        dvClient.restUploadCall(uri, headers, xmlFile, checksum, imageFile);
        xmlFile.deleteOnExit();
    }

    *//**
     * Enum for Content Type
     * getValue() returns value
     * getQueryValue returns the query value which is used in search
     *
     * @author Sarthak Samal
     *//*
    public enum ContentType {
        PHOTOS("image/*"),
        VIDEOS("video/*"),
        OFFICE_DOCS("application/vnd*"),
        PDFS("application/pdf*"),
        MUSIC("audio/*");

        private String query;

        ContentType(String s) {
            query = s;
        }

        public String getValue() {
            return query;
        }

        public String getQueryValue() {
            return "contentType:" + query;
        }
    }

    *//**
     * Enum for Playlist Type
     * getValue() returns value
     * getQueryValue returns the query value which is used in search
     *
     * @author Sarthak Samal
     *//*
    public enum PlaylistTypes {
        PHOTO_ONLY("image"),
        VIDEO_ONLY("video"),
        PHOTO_VIDEO("image-video"),
        MUSIC_ONLY("music");

        private String query;

        PlaylistTypes(String s) {
            query = s;
        }

        public String getValue() {
            return query;
        }

        public String getQueryValue() {
            return "?type=" + query;
        }
    }

}
*/