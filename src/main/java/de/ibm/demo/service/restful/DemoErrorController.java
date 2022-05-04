package de.ibm.demo.service.restful;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class DemoErrorController implements ErrorController {

	@RequestMapping("/error")
	public String handleError(HttpServletRequest request) {
		//log.error("handling error ..");
		Object status = request
				.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

		if (status != null) {
			Integer statusCode = Integer.valueOf(status.toString());
			//log.error("StatusCode = " + statusCode);
			if (statusCode == 404) {
				return "error404";
			}
			if (statusCode == 200) {
				return "ok"; // HACK as default redirection does not work..
			}
		}

		return "error";
	}

	@Override
	public String getErrorPath() {
		//log.error("getErrorPath...");
		return null;
	}
}