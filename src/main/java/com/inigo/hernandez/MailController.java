package com.inigo.hernandez;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

	@Autowired
	private MailService mailService;

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "/mail", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void listBranches(
			@RequestParam(value = "address", required = true) final String address,
			@RequestParam(value = "subject", required = true) final String subject,
			@RequestParam(value = "message", required = true) final String message) {
		logger.info("Sending email");
		mailService.sendMail(address, subject, message);
		logger.info("Email sent");
	}

}
