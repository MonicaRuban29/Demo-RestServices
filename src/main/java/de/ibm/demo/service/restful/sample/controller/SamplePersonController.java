package de.ibm.demo.service.restful.sample.controller;

import java.net.InetSocketAddress;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.ibm.demo.service.restful.sample.types.Person;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/sample")
public class SamplePersonController {

	private static Log LOG = LogFactory
			.getLog(SamplePersonController.class);

	/**
	 * Default Constructor
	 */
	public SamplePersonController() {
	}

	@Operation(summary = "createPerson",
			description = "Creates a person (though no persistence!)")
	@RequestMapping(method = RequestMethod.POST, value = "/create/person")
	public String createPerson(@RequestBody Person person) {
		LOG.info("GOT: " + person.toString());
		return person.toString();
	}

	// following from: https://www.baeldung.com/spring-rest-http-headers
	@GetMapping("/listHeaders")
	public ResponseEntity<String> listAllHeaders(
			@RequestHeader Map<String, String> headers) {
		headers.forEach((key, value) -> {
			LOG.info(String.format("Header '%s' = %s", key, value));
		});

		return new ResponseEntity<String>(
				String.format("Listed %d headers", headers.size()),
				HttpStatus.OK);
	}

	@GetMapping("/getBaseUrl")
	public ResponseEntity<String> getBaseUrl(
			@RequestHeader HttpHeaders headers) {
		InetSocketAddress host = headers.getHost();
		String url = "http://" + host.getHostName() + ":" + host.getPort();
		return new ResponseEntity<String>(String.format("Base URL = %s", url),
				HttpStatus.OK);
	}
}
