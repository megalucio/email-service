package com.inigo.hernandez;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;

	protected final Log logger = LogFactory.getLog(getClass());
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public String ping() {
		return "email-service";
	}

	@RequestMapping(value = "/emailMe", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void emailMe(@RequestBody EmailRequest emailrequest) {
		logger.info("Sending email");
		emailService.emailMe(emailrequest.subject, emailrequest.message);
		logger.info("Email sent");
	}

}
