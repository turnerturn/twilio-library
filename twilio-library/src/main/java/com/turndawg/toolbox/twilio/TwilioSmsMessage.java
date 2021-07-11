package com.turndawg.toolbox.twilio;

import javax.persistence.Entity;

import com.turndawg.toolbox.twilio.TwilioMessage;
@Entity
public class TwilioSmsMessage extends TwilioMessage {



	public TwilioSmsMessage() {
		super();
	}

	public TwilioSmsMessage(String to, String from, String body) {
		super(to,from,body);
	}

	@Override
	public String toString() {
		return "TwilioSmsMessage [to=" + getTo() + ", from=" + getFrom() + ", body=" + getBody() + "]";
	}

}
