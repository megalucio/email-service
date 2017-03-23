package com.inigo.hernandez;

import java.io.Serializable;

@SuppressWarnings("serial")
public class EmailRequest implements Serializable{
	
	String subject;
	String message;
	
	public EmailRequest() {

	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
