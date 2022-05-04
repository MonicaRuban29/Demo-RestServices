package de.ibm.demo.service.restful.hello.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController4Englisch {

	private static Log LOG = LogFactory
			.getLog(HelloController4Englisch.class);

	/**
	 * Default Constructor
	 */
	public HelloController4Englisch() {
	}

	// NOTE: Just as example for having a param ... not very restful
	@RequestMapping("/hello/eng")
	public String sayHello(@RequestParam(required = false) String name) {
		String result = "Welcome";
		if (name != null) {
			result += " my dear friend, " + name;
		}
		result += " !";

		LOG.debug("Created greetings for " + name);
		return result;
	}
}
