package com.turndawg.toolbox.twilio;

import javax.validation.Valid;

import com.turndawg.toolbox.twilio.TwilioSmsMessage;

public interface TwilioService {

	//public void send(@Valid TwilioVoiceMessage smsMessage);
	public void send(@Valid TwilioSmsMessage smsMessage);
	
}
