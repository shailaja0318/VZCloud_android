/*
 * package com.sncr.verizon.appiumtests.servercalls;
 * 
 * 
 * import static com.sncr.verizon.appiumtests.servercalls.VZServerRequests.
 * timelineDateForMediaUploads;
 * 
 *//**
	 * Created by anlin.tang on 15/01/16. Updated by Sarthak Samal.
	 */
/*
 * public class VZServerSetXML {
 * 
 * public String setPlaylistXML(String playlistName, String playlistType, String
 * fileRepo, String filePath) {
 * 
 *//**
	 * Playlist type should only be one of following: music image-video
	 */
/*
 * 
 * return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
 * "<playlistDefinition xmlns:a=\"http://alternate.newbay.com/ns/1.0\" xmlns:dv=\"http://dv.newbay.com/ns/1.0\"\n"
 * + "                    xmlns:dvi='http://internal.dv.newbay.com/ns/1.0'\n" +
 * "                    xmlns:ext='http://dv.webextensions.newbay.com/ns/1.0' xmlns='http://playlist.dv.newbay.com/ns/1.0'>\n"
 * + "    <name>" + playlistName + "</name>\n" + "    <type>" + playlistType +
 * "</type>\n" + "    <repositoryPath>" + fileRepo + ":/" + filePath +
 * "</repositoryPath>\n" + "</playlistDefinition>"; }
 * 
 * public String setFileXML(String fileName, String filePath, Long fileSize,
 * String checksum) { return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
 * "<files xmlns=\"http://dv.newbay.com/ns/1.0\"\n" +
 * "    xmlns:a=\"http://alternate.newbay.com/ns/1.0\" xmlns:dvi=\"http://internal.dv.newbay.com/ns/1.0\">\n"
 * + "    <file>\n" + "        <name>" + fileName + "</name>\n" +
 * "        <parentPath>" + filePath + "</parentPath>\n" + "        <size>" +
 * fileSize + "</size>\n" + "        <checksum>" + checksum + "</checksum>\n" +
 * "    </file>\n" + "</files>"; }
 * 
 *//**
	 * Setting xml file for livephotos.
	 * 
	 * @Author: Sarthak Samal
	 */
/*
 * public String setLivePhotoXML(String imageName, String image_contentToken,
 * String video_contentToken, Long imageSize, String image_checksum, String
 * video_checksum) { return
 * "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
 * "<files xmlns:dvi=\"http://internal.dv.newbay.com/ns/1.0\" xmlns=\"http://dv.newbay.com/ns/1.0\" xmlns:a=\"http://alternate.newbay.com/ns/1.0\">\n"
 * + "<file>\n" + "<name>" + imageName + "</name>\n" +
 * "<parentPath>/</parentPath>\n" + "<size>" + imageSize + "</size>\n" +
 * "<checksum>" + image_checksum + "</checksum>\n" + "<contentToken>" +
 * image_contentToken + "</contentToken>\n" +
 * "<systemAttribute name=\"Meta-Type\">Live-Photo</systemAttribute>\n" +
 * "<attachmentAttribute name=\"PairedVideo\">\n" + "<contentToken>" +
 * video_contentToken + "</contentToken>\n" + "<checksum>" + video_checksum +
 * "</checksum>\n" + "</attachmentAttribute>\n" + "</file>\n" + "</files>"; }
 * 
 *//**
	 * Setting xml file for flashbacks.
	 * 
	 * @Author: Sarthak Samal
	 *//*
		 * public String setFlashbackXML(String checksum, String fileName, Long size) {
		 * String systemAttributeValue = "test"; String xmlContent =
		 * "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		 * "<files xmlns=\"http://dv.newbay.com/ns/1.0\">\n" + "<file>\n" +
		 * "<parentPath>/</parentPath>\n" + "<name>" + fileName + "</name>\n" + "<size>"
		 * + size + "</size>\n" + "<checksum>" + checksum + "</checksum>\n" +
		 * "<systemAttribute name=\"Real-Network-Image-Quality\">" +
		 * systemAttributeValue + "</systemAttribute>\n"; xmlContent = xmlContent +
		 * "<systemAttribute name=\"Capture-Date\">" + timelineDateForMediaUploads +
		 * "</systemAttribute>\n" + "<systemAttribute name=\"Timeline-Date\">" +
		 * timelineDateForMediaUploads + "</systemAttribute>\n" + "</file>\n" +
		 * "</files>"; return xmlContent; } }
		 */