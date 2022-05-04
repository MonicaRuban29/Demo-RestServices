package de.ibm.demo.service.restful.upload.controller;


import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/upload")
public class UploadController {

	private static Log LOG = LogFactory
			.getLog(UploadController.class);
	
	// Save the uploaded file to this folder
	private static String UPLOADED_FOLDER="C:\\Users\\0022XG744\\Desktop\\REDWOOD KYC\\";

	/**
	 * Default Constructor
	 */
	public UploadController() {
	}
	
	@Operation(summary = "uploadFile",
			description = "to upload some file")
	@RequestMapping(method = RequestMethod.POST,
			value = "/file",
			produces = MediaType.TEXT_HTML_VALUE,
			consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseStatus(code = HttpStatus.OK, reason = "OK")
	public String uploadFile(@RequestParam(required = true)MultipartFile file) throws IOException {
		LOG.info("GOT some file: " + file);
		// TODO: work on file ..
		File folder = new File(UPLOADED_FOLDER);
	      if (!folder.exists()) {
	         folder.mkdir();
	      }
		byte[] bytes = file.getBytes();
		Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
		Files.write(path, bytes);
		
		// TODO: Why do we not end on the uploadDone.hmtl page ?
		return "uploadDone";
	}
}
