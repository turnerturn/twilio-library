package com.turndawg.toolbox.twilio;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import com.turndawg.toolbox.twilio.validator.TwilioPhoneNumber;
@Entity
public class TwilioMessage {
	@TwilioPhoneNumber
	private String to;
	@TwilioPhoneNumber
	private String from;
	@NotNull
	private String body;

	public TwilioMessage() {
		super();
	}

	public TwilioMessage(String to, String from, String body) {
		super();
		this.to = to;
		this.from = from;
		this.body = body;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "TwilioSmsMessage [to=" + to + ", from=" + from + ", body=" + body + "]";
	}

}
