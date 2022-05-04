package de.ibm.demo.service.restful.hello.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController4German {

	private static Log LOG = LogFactory.getLog(HelloController4German.class);

	/**
	 * Default Constructor
	 */
	public HelloController4German() {
	}

	// NOTE: Just as example for having a param ... not very restful
	@RequestMapping(method = RequestMethod.GET, value = "/hello/ger")
	public String sayHello(@RequestParam(required = false) String name) {
		String result = "Willkommen";
		if (name != null) {
			result += " mein lieber Freund, " + name + " !";
		}
		result += " !";

		LOG.debug("Created greetings for " + name);
		return result;
	}
}
