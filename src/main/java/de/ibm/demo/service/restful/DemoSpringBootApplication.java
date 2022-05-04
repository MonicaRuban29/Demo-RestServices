package de.ibm.demo.service.restful;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = RestfulExceptionHandler.class)
public class DemoSpringBootApplication {
	private static Log LOG = LogFactory
			.getLog(DemoSpringBootApplication.class);

	public static void main(String[] args) {
		LOG.info("THIS IS THE MAIN APP");
		SpringApplication.run(DemoSpringBootApplication.class, args);
	}
}