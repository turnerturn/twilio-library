package com.turndawg.toolbox.twilio;

import javax.persistence.Entity;

@Entity
public class TwilioVoiceMessage extends TwilioMessage {

	public TwilioVoiceMessage() {
		super();
	}

	public TwilioVoiceMessage(String to, String from, String body) {
		super(to, from, body);
	}

	@Override
	public String toString() {
		return "TwilioVoiceMessage [to=" + getTo() + ", from=" + getFrom() + ", body=" + getBody() + "]";
	}

}
