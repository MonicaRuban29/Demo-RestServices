package de.ibm.demo.service.restful.download.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
@RestController
@RequestMapping("/download")
public class DownloadController {


	private static Log LOG = LogFactory
			.getLog(DownloadController.class);

	//  uploaded file location
    // private static String UPLOADED_FOLDER="C:\\Users\\0022XG744\\Desktop\\REDWOOD KYC\\";
	/**
	 * Default Constructor
	 */
	public DownloadController() {
	}

	@Operation(summary = "downloadFile",
			description = "to download file")
	@RequestMapping(method = RequestMethod.GET,
			value = "/file",
			produces = MediaType.TEXT_HTML_VALUE)
	@ResponseStatus(code = HttpStatus.OK, reason = "OK")
	public String downloadFile(@RequestParam(required = true) String filename) {
		LOG.info("file to download: " + filename);
		// TODO: work on file ..

		// TODO:  end on download.html
		return "downloadDone";
	}

}
