/*
 * package com.sncr.verizon.appiumtests.servercalls;
 * 
 * import com.google.common.hash.Hashing; import
 * com.sncr.verizon.appiumtests.constants.vz_serverConfigs; import
 * com.sncr.verizon.appiumtests.constants.vz_strings; import
 * com.sncr.verizon.appiumtests.constants.vz_strings.DataType; import
 * com.sncr.verizon.appiumtests.servercalls.VZServerMDN;
 * 
 * import io.restassured.path.xml.XmlPath;
 * 
 * import org.apache.commons.codec.digest.DigestUtils; import
 * org.apache.commons.io.FileUtils; //import io.restassured.path.xml.XmlPath;
 * //import org.apache.commons.io.FileUtils; import org.apache.http.Header;
 * import org.apache.http.HttpEntity; import org.apache.http.HttpResponse;
 * import org.apache.http.HttpStatus; import
 * org.apache.http.client.ClientProtocolException; import
 * org.apache.http.client.ResponseHandler; import
 * org.apache.http.client.methods.*; import org.apache.http.entity.ContentType;
 * import org.apache.http.entity.StringEntity; import
 * org.apache.http.entity.mime.MultipartEntityBuilder; import
 * org.apache.http.impl.client.CloseableHttpClient; import
 * org.apache.http.impl.client.HttpClients; import
 * org.apache.http.message.BasicHeader; import org.apache.http.util.EntityUtils;
 * import org.apache.logging.log4j.LogManager; import
 * org.apache.logging.log4j.Logger; import org.w3c.dom.Document; import
 * org.w3c.dom.NodeList; import org.xml.sax.InputSource;
 * 
 * import javax.imageio.ImageIO; //import javax.xml.bind.DatatypeConverter;
 * import javax.xml.parsers.DocumentBuilder; import
 * javax.xml.parsers.DocumentBuilderFactory; import
 * java.awt.image.BufferedImage; import java.io.*; import
 * java.lang.invoke.MethodHandles; import java.nio.file.Files; import
 * java.text.DateFormat; import java.text.SimpleDateFormat; import java.util.*;
 * 
 * import static
 * com.sncr.verizon.appiumtests.constants.vz_serverConfigs.photoPath; import
 * static org.apache.http.entity.ContentType.APPLICATION_OCTET_STREAM;
 * 
 *//**
	 * Created by anlin.tang on 12/01/16. Updated by Sarthak Samal.
	 */
/*
 * public class VZServerRequests { private final static Logger logger =
 * LogManager.getLogger(MethodHandles.lookup().lookupClass()); public static
 * String timelineDateForMediaUploads;
 * 
 * //=============== START OF INNER CLASS ==================== public class
 * Response implements ResponseHandler<String> {
 * 
 * @Override public String handleResponse(HttpResponse response) throws
 * ClientProtocolException, IOException { int status =
 * response.getStatusLine().getStatusCode(); HttpEntity entity =
 * response.getEntity(); logger.info("Server Responds with code: " + status); if
 * (status >= HttpStatus.SC_OK && status < HttpStatus.SC_MULTIPLE_CHOICES) {
 * return entity != null ? EntityUtils.toString(entity) : null; } else { throw
 * new ClientProtocolException("Unexpected response status: " + status); } } }
 * //=============== END OF INNER CLASS ======================
 * 
 * CloseableHttpClient httpClient;
 * 
 * public VZServerRequests() { httpClient = HttpClients.createDefault(); }
 * 
 * private File generateTextFile(String name) throws IOException { String
 * projectPath = System.getProperty("user.dir"); File f = new File(projectPath +
 * vz_serverConfigs.documentPath + name); f.getParentFile().mkdirs();
 * f.createNewFile(); FileWriter fr = new FileWriter(f);
 * fr.write("Hello world from code"); fr.close();
 * 
 * return f; }
 * 
 * //Experimental Code private File generateImageFile(String name) throws
 * IOException { String projectPath = System.getProperty("user.dir");
 * BufferedImage img = new BufferedImage(256, 256, BufferedImage.TYPE_INT_RGB);
 * int r, g, b;
 * 
 * for (int x = 0; x < 256; x++) { for (int y = 0; y < 256; y++) { r = (int)
 * (Math.random() * 256); g = (int) (Math.random() * 256); b = (int)
 * (Math.random() * 256);
 * 
 * int col = (r << 16) | (g << 8) | b; img.setRGB(x, y, col); } }
 * 
 * File f = new File(projectPath + photoPath + name); ImageIO.write(img, "JPEG",
 * f);
 * 
 * return f; }
 * 
 *//**
	 * Upload a file to the Server by providing the file type. The name defaults to
	 * whatever is defined in the method.
	 *
	 * @param fileType
	 * @throws Exception
	 * @author Alen Kalac
	 */
/*
 * public void uploadFile(DataType fileType) throws Exception {
 * 
 * String fileName = "";
 * 
 * switch (fileType) { case DOCUMENT: fileName = vz_serverConfigs.textFileName;
 * break; case PHOTO: fileName = vz_serverConfigs.photoFileName; break; case
 * MUSIC: fileName = vz_serverConfigs.musicFileName; break; default:
 * logger.error("Unsupported File Type, Skipping upload"); return; }
 * uploadFile(fileType, fileName); }
 * 
 *//**
	 * Upload the file by data type and filename, this can upload any existing file
	 * that's currently in the resources by passing the name of that file.
	 *
	 * @param fileType
	 * @param fileName
	 * @throws Exception
	 * @author Alen Kalac
	 */
/*
 * public void uploadFile(DataType fileType, String fileName) throws Exception {
 * logger.info("Uploading File with filename - " + fileName); VZServerMDN mdn =
 * VZServerMDN.getInstance(); File file = null; File xmlFile = null; String
 * projectPath = System.getProperty("user.dir");
 * 
 * if (fileType == DataType.DOCUMENT || fileType == DataType.AllFiles) file =
 * generateTextFile(fileName); else if (fileType == DataType.PHOTO || fileType
 * == DataType.FLASHBACK) //file = this.generateImageFile(fileName); file = new
 * File(projectPath + photoPath + fileName); else if (fileType ==
 * DataType.MUSIC) file = new File(projectPath + vz_serverConfigs.musicPath +
 * fileName); else if (fileType == DataType.VIDEO) file = new File(projectPath +
 * vz_serverConfigs.videoPath + fileName);
 * 
 * 
 * if (!file.exists()) throw new IOException("File Doesn't exist");
 * 
 * // String checksum =
 * DatatypeConverter.printHexBinary(DigestUtils.sha256(Files.readAllBytes(file.
 * toPath()))) .toLowerCase();
 * 
 * // String checksum = String.valueOf(com.google.common.io.Files.hash(file,
 * Hashing.sha256()));
 * 
 * if (fileType.equals(DataType.FLASHBACK)) { xmlFile =
 * createFlashbacksXMLfile(file, checksum); } else { xmlFile =
 * createXMLfile(file, checksum); }
 * 
 * 
 * createRepo(vz_serverConfigs.vzRepo);
 * 
 * HttpEntity httpEntity = MultipartEntityBuilder.create()
 * .addBinaryBody("files", xmlFile,
 * ContentType.create(vz_serverConfigs.dvHeader_Accept1_15, "UTF-8"),
 * vz_serverConfigs.xmlFileName)
 * 
 * .addBinaryBody(checksum, file, ContentType.create("application/octet-stream",
 * "ISO-8859-1"), file.getName())
 * 
 * .build();
 * 
 * String uri = mdn.getHost() + "/dv/api/user/" + mdn.getLCID() + "/repository/"
 * + vz_serverConfigs.vzRepo + "/file";
 * 
 * List<Header> headers = new ArrayList<Header>(); headers.add(new
 * BasicHeader("Accept", vz_serverConfigs.dvHeader_Accept1_15)); headers.add(new
 * BasicHeader("Authorization", mdn.getToken()));
 * 
 * sendHttpRequest("POST", uri, headers, httpEntity);
 * 
 * xmlFile.deleteOnExit(); if (fileType == DataType.DOCUMENT) file.delete();
 * logger.info("----------------------------------------"); }
 * 
 *//**
	 * Upload multiple files
	 *
	 * @param fileType
	 * @param pathList
	 * @throws Exception
	 * @author Sarthak Samal
	 */
/*
 * public void uploadFiles(DataType fileType, ArrayList<String> pathList) throws
 * Exception { logger.info("files to upload: " + pathList.size()); for (String l
 * : pathList) { uploadFile(fileType, l); } }
 * 
 *//**
	 * Create photos and videos content
	 *
	 * @param fileName of image or video.
	 * @return photo and video checksum,token & size.
	 * @throws Exception
	 * @author Sarthak Samal
	 */
/*
 * public String[] createPhotosAndVideosContent(File fileName) throws Exception
 * { VZServerMDN mdn = VZServerMDN.getInstance(); long fileSize =
 * FileUtils.sizeOf(fileName); HttpPost httpPost = new HttpPost(mdn.getHost() +
 * "/dv/api/user/" + mdn.getLCID() + "/content?size=" + fileSize +
 * "&chunk=true"); httpPost.addHeader("Accept",
 * vz_serverConfigs.dvHeader_Accept1_19); httpPost.addHeader("Authorization",
 * mdn.getToken()); MultipartEntityBuilder builder =
 * MultipartEntityBuilder.create(); builder.addBinaryBody("file", fileName,
 * APPLICATION_OCTET_STREAM, "file.ext"); HttpEntity multipart =
 * builder.build(); httpPost.setEntity(multipart); String responseBody =
 * httpClient.execute(httpPost, new Response()); // XmlPath xmlPath = new
 * XmlPath(responseBody); XmlPath xmlPath = new XmlPath(responseBody);
 * 
 * 
 * logger.info("----------------------------------------");
 * logger.info(responseBody); return new
 * String[]{xmlPath.getString("content.contentToken"),
 * xmlPath.getString("content.checksum"), xmlPath.getString("content.size")}; }
 * 
 * 
 * private File createXMLfile(File file, String checksum) throws IOException {
 * logger.info("Generating XML File"); VZServerSetXML vzServerSetXML = new
 * VZServerSetXML(); File xmlFile = new File(vz_serverConfigs.xmlFileName);
 * FileWriter fw = new FileWriter(xmlFile);
 * fw.write(vzServerSetXML.setFileXML(file.getName(), "/", file.length(),
 * checksum)); fw.close(); return xmlFile; }
 * 
 *//**
	 * Generate live photo xml file
	 *
	 * @param imageFile
	 * @param videoFile
	 * @param checksum
	 * @throws Exception
	 * @author Sarthak Samal
	 */
/*
 * public File createLivePhotoXMLfile(File imageFile, File videoFile, String
 * checksum) throws Exception { logger.info("Generating live photo XML File");
 * VZServerSetXML vzServerSetXML = new VZServerSetXML(); File xmlFile = new
 * File(vz_serverConfigs.xmlFileName); FileWriter fw = new FileWriter(xmlFile);
 * String[] imageContent = createPhotosAndVideosContent(imageFile); String[]
 * videoContent = createPhotosAndVideosContent(videoFile);
 * fw.write(vzServerSetXML.setLivePhotoXML(imageFile.getName(), imageContent[0],
 * videoContent[0], Long.valueOf(imageContent[2]), checksum, videoContent[1]));
 * fw.close(); return xmlFile; }
 * 
 *//**
	 * Generate flahback xml file
	 *
	 * @param file
	 * @param checksum
	 * @throws Exception
	 * @author Sarthak Samal
	 */
/*
 * public File createFlashbacksXMLfile(File file, String checksum) throws
 * Exception { logger.info("Generating Flashback XML File"); VZServerSetXML
 * vzServerSetXML = new VZServerSetXML(); File xmlFile = new
 * File(vz_serverConfigs.xmlFileName); FileWriter fw = new FileWriter(xmlFile);
 * fw.write(vzServerSetXML.setFlashbackXML(checksum, file.getName(),
 * file.length())); fw.close(); return xmlFile; }
 * 
 * private String sendHttpRequest(String method, String URI, List<Header>
 * headers, HttpEntity httpEntity) throws Exception, ClientProtocolException {
 * HttpRequestBase httpRequest;
 * 
 * if (method.equalsIgnoreCase("GET")) httpRequest = new HttpGet(URI); else if
 * (method.equalsIgnoreCase("POST")) httpRequest = new HttpPost(URI); else if
 * (method.equalsIgnoreCase("DELETE")) httpRequest = new HttpDelete(URI); else
 * if (method.equalsIgnoreCase("PUT")) httpRequest = new HttpPut(URI); else
 * throw new Exception("Unsuported method");
 * 
 * for (Header h : headers) httpRequest.addHeader(h);
 * 
 * if (httpEntity != null) { HttpEntityEnclosingRequestBase httpWith =
 * (HttpEntityEnclosingRequestBase) httpRequest; httpWith.setEntity(httpEntity);
 * }
 * 
 * logger.info("Executing HTTP request"); String responseBody =
 * httpClient.execute(httpRequest, new Response());
 * 
 * logger.info(responseBody);
 * 
 * return responseBody; }
 * 
 *//**
	 * Create a repo using API
	 *
	 * @param repoName
	 * @throws Exception
	 */
/*
 * public void createRepo(String repoName) throws Exception {
 * logger.info("Creating a new REPO " + repoName); VZServerMDN mdn =
 * VZServerMDN.getInstance();
 * 
 * String uri = mdn.getHost() + "/dv/api/user/" + mdn.getLCID() + "/repository";
 * List<Header> headers = new ArrayList<>();
 * headers.add(VZServerHeaders.getAcceptHeaderV15());
 * headers.add(VZServerHeaders.getContentTypeHeader());
 * headers.add(VZServerHeaders.getAuthTokenHeader());
 * 
 * StringEntity stringEntity = new StringEntity("name=" + repoName);
 * 
 * try { sendHttpRequest("POST", uri, headers, stringEntity); } catch
 * (ClientProtocolException e) { logger.info("Repo Already Exist"); }
 * 
 * logger.info("----------------------------------------"); }
 * 
 *//**
	 * Delete a repo from the cloud
	 *
	 * @param repoName
	 * @throws Exception
	 */
/*
 * public void deleteRepo(String repoName) throws Exception {
 * logger.info("Deleting a REPO " + repoName); VZServerMDN mdn =
 * VZServerMDN.getInstance();
 * 
 * String uri = mdn.getHost() + "/dv/api/user/" + mdn.getLCID() + "/repository/"
 * + repoName; List<Header> headers = new ArrayList<>();
 * headers.add(VZServerHeaders.getAcceptHeaderV15());
 * headers.add(VZServerHeaders.getAuthTokenHeader());
 * 
 * try { sendHttpRequest("delete", uri, headers, null); } catch
 * (ClientProtocolException e) { logger.info("Repo Doesn't Exist"); }
 * 
 * logger.info("----------------------------------------"); }
 * 
 *//**
	 * Return the repo from the cloud.
	 *
	 * @param repoName
	 * @throws Exception
	 */
/*
 * public String getRepo(String repoName) throws Exception {
 * logger.info("Retreving a REPO " + repoName); VZServerMDN mdn =
 * VZServerMDN.getInstance();
 * 
 * String uri = mdn.getHost() + "/dv/api/user/" + mdn.getLCID() + "/repository/"
 * + repoName;
 * 
 * List<Header> headers = new ArrayList<>();
 * headers.add(VZServerHeaders.getAcceptHeaderV15());
 * headers.add(VZServerHeaders.getAuthTokenHeader());
 * 
 * try { repoName = sendHttpRequest("get", uri, headers, null); } catch
 * (ClientProtocolException e) { logger.info("Repo Doesn't Exist"); }
 * 
 * logger.info("----------------------------------------"); return repoName; }
 * 
 *//**
	 * Create a playlist of any type for single file using Http Client.
	 *
	 * @param playListName Name of the playlist to create.
	 * @param playListType Type of playlist to be created.
	 * @param fileName     Name of the file to be added to playlist.
	 * @return Created playlist uid.
	 * @throws Exception
	 */
/*
 * public String createPlaylist(String playListName, String playListType, String
 * fileName) throws Exception { VZServerSetXML vzServerSetXML = new
 * VZServerSetXML(); VZServerMDN mdn = VZServerMDN.getInstance();
 * createRepo(vz_serverConfigs.vzRepo); HttpPost httpPost = new
 * HttpPost(mdn.getHost() + "/dv/ext/user/" + mdn.getLCID() + "/playlist");
 * httpPost.addHeader("Accept", vz_serverConfigs.dvHeader_Accept1_0);
 * httpPost.addHeader("x-newbay-nwb", mdn.getToken());
 * httpPost.addHeader("Accept-encoding", "gzip, deflate");
 * httpPost.addHeader("Content-type", vz_serverConfigs.dvHeader_Accept1_0);
 * StringEntity stringEntity = new
 * StringEntity(vzServerSetXML.setPlaylistXML(playListName, playListType,
 * vz_serverConfigs.vzRepo, fileName)); httpPost.setEntity(stringEntity); String
 * responseBody = httpClient.execute(httpPost, new Response()); XmlPath xmlPath
 * = new XmlPath(responseBody);
 * logger.info("----------------------------------------");
 * logger.info(responseBody); return xmlPath.getString("content.uid"); }
 * 
 * public int getPlaylistCount(vz_strings.DataType dataType) throws Exception {
 * String filter; if (dataType == vz_strings.DataType.MUSIC) { filter = "music";
 * } else { filter = "image-video"; } return getCountInResponse(playlistGet(),
 * filter); }
 * 
 * public int getItemCountInPlaylist(vz_strings.DataType dataType) throws
 * Exception { String filter; if (dataType == vz_strings.DataType.MUSIC) {
 * filter = "music"; } else { filter = "image-video"; }
 * 
 * DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
 * DocumentBuilder builder; builder = factory.newDocumentBuilder(); Document doc
 * = builder.parse(new InputSource(new StringReader(playlistGet())));
 * 
 * NodeList nl = null; for (int i = 0; i <
 * doc.getElementsByTagName("type").getLength(); i++) { if
 * (doc.getElementsByTagName("type").item(i).getParentNode().getChildNodes().
 * item(4).getTextContent() .equals(filter)) { nl =
 * doc.getElementsByTagName("type").item(i).getParentNode().getChildNodes();
 * break; } } int counter = 0; for (int i = 0; i < nl.getLength(); i++) { if
 * (nl.item(i).getNodeName().equals("repositoryPath")) counter++; } return
 * counter; }
 * 
 * public String getFile() throws Exception {
 * 
 * VZServerMDN mdn = VZServerMDN.getInstance();
 * createRepo(vz_serverConfigs.vzRepo);
 * 
 * String uri = mdn.getHost() + "/dv/api/user/" + mdn.getLCID() + "/repository/"
 * + vz_serverConfigs.vzRepo + "/folder?path=%2F";
 * 
 * List<Header> headers = new ArrayList<>();
 * headers.add(VZServerHeaders.getAcceptHeaderV15());
 * headers.add(VZServerHeaders.getAuthTokenHeader());
 * 
 * logger.info("----------------------------------------"); return
 * sendHttpRequest("GET", uri, headers, null);
 * 
 * }
 * 
 * private String playlistGet() throws Exception { VZServerMDN mdn =
 * VZServerMDN.getInstance(); HttpGet httpget = new HttpGet(mdn.getHost() +
 * "/dv/ext/user/" + mdn.getLCID() + "/playlist");
 * httpget.addHeader("x-newbay-nwb", mdn.getToken());
 * httpget.addHeader("Accept", vz_serverConfigs.dvHeader_Accept1_0);
 * 
 * return httpClient.execute(httpget, new Response()); }
 * 
 * private int getCountInResponse(String responseBody, String filter) {
 * 
 * StringBuilder result = new StringBuilder(); result.append(responseBody);
 * boolean count = false; for (int i = 0; i < result.length(); i++) { if
 * (String.valueOf(result.charAt(i)).contentEquals("<") &&
 * String.valueOf(result.charAt(i + 1)).contentEquals("/")) { count = true; } if
 * (count && String.valueOf(result.charAt(i)).contentEquals(">")) { count =
 * false; result.insert(i + 1, '\n'); } } String[] arr =
 * result.toString().split("\\r?\\n"); int counter = 0; for (String s : arr) {
 * if (s.contains(filter)) { counter++; } } logger.info(filter + " count is " +
 * counter); return counter; }
 * 
 * public void closeRemoteConnection() { try { this.httpClient.close(); } catch
 * (IOException e) { e.printStackTrace(); } }
 * 
 * public String setDate(Integer noOfDays, Integer noOfMonths, Integer
 * noOfYears) { if (noOfDays == null || noOfMonths == null || noOfYears == null)
 * { timelineDateForMediaUploads = "-"; } else { Map<String, String> dateFields
 * = setTempDate(noOfDays, noOfMonths, noOfYears); timelineDateForMediaUploads =
 * dateFields.get("year") + "-" + dateFields.get("month") + "-" +
 * dateFields.get("date") + "T12:00:00.000Z"; } return
 * timelineDateForMediaUploads; }
 * 
 * private Map<String, String> setTempDate(Integer noOfDays, Integer noOfMonths,
 * Integer noOfYears) { Map<String, String> dateFields = new HashMap<>();
 * 
 * Calendar c = Calendar.getInstance(); if (noOfDays != 0) {
 * c.add(Calendar.DATE, -noOfDays); } if (noOfMonths != 0) {
 * c.add(Calendar.MONTH, -noOfMonths); } if (noOfYears != 0) {
 * c.add(Calendar.YEAR, -noOfYears); }
 * 
 * DateFormat monthFormat = new SimpleDateFormat("MM"); DateFormat dateFormat =
 * new SimpleDateFormat("dd"); DateFormat yearFormat = new
 * SimpleDateFormat("yyyy"); String month = monthFormat.format(c.getTime());
 * String year = yearFormat.format(c.getTime()); String date =
 * dateFormat.format(c.getTime()); dateFields.put("date", date);
 * dateFields.put("month", month); dateFields.put("year", year);
 * 
 * return dateFields; }
 * 
 *//**
	 * Convert xml to String.
	 *
	 * @param filePath - String - Path of xml file
	 * @return String - coverted String
	 *//*
		 * public String xmlToString(String filePath) { String xmlAsString = ""; try {
		 * FileReader fileReader = new FileReader(filePath); BufferedReader
		 * bufferedReader = new BufferedReader(fileReader); StringBuilder sb = new
		 * StringBuilder(); String line = bufferedReader.readLine().trim(); while
		 * (!line.isEmpty()) { sb.append(line); line = bufferedReader.readLine(); if
		 * (line == null) break; } xmlAsString = sb.toString(); bufferedReader.close();
		 * } catch (Exception e) { e.printStackTrace(); } return xmlAsString; } }
		 */