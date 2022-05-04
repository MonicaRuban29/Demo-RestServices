package de.ibm.demo.service.restful.hello.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/hello4Lang")
public class HelloController4Lang {

	private static Log LOG = LogFactory
			.getLog(HelloController4Englisch.class);

	/**
	 * Default Constructor
	 */
	public HelloController4Lang() {
	}

	private String createGreetingsGer(String name) {
		String result = "Willkommen";
		if (name != null) {
			result += " mein lieber Freund, " + name;
		}
		result += " !";
		return result;
	}

	private String createGreetingsEng(String name) {
		String result = "Welcome";
		if (name != null) {
			result += " my dear friend, " + name;
		}
		result += " !";
		return result;
	}

	@Operation(summary = "createHelloGer",
			description = "Create a 'Hello' message in german")
	@RequestMapping(method = RequestMethod.POST, value = "/create/ger/{name}")
	public String createHelloGer(@PathVariable String name) {
		String result = createGreetingsGer(name);
		LOG.debug("Created greetings: '" + result + "'");
		return result;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/ger/{name}")
	public String sayHelloGer(@PathVariable String name) {
		String result = createGreetingsGer(name);
		LOG.debug("Greetings are: '" + result + "'");
		return result;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/create/eng/{name}")
	public String createHelloEng(@PathVariable String name) {
		String result = createGreetingsEng(name);
		LOG.debug("Created greetings: '" + result + "'");
		return result;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/eng/{name}")
	public String sayHelloEng(@PathVariable String name) {
		String result = createGreetingsEng(name);
		LOG.debug("Greetings are: '" + result + "'");
		return result;
	}

}
