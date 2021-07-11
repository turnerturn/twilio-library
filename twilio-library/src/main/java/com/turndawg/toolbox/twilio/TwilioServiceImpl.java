package com.turndawg.toolbox.twilio;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import com.turndawg.toolbox.twilio.TwilioSmsMessage;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
@EnableConfigurationProperties(TwilioProperties.class)
public class TwilioServiceImpl implements TwilioService {

	private static final Logger log = LoggerFactory.getLogger(TwilioServiceImpl.class);

	private final TwilioProperties twilioProperties;

	public TwilioServiceImpl(final TwilioProperties twilioProperties) {
		this.twilioProperties = twilioProperties;
	}

//	@Override
//	public void send(@Valid TwilioVoiceMessage smsMessage) {
//		initTwilioEnvironment();
//
//	}

	@Override
	public void send(@Valid TwilioSmsMessage smsMessage) {
		initTwilioEnvironment();

		Message message = Message.creator(new PhoneNumber(smsMessage.getTo()), new PhoneNumber(smsMessage.getFrom()),
				smsMessage.getBody()).create();

		log.info("Sent sms message. {}", message);
	}

	private void initTwilioEnvironment() {
		Twilio.init(twilioProperties.getAccountSid(), twilioProperties.getAuthToken());
	}
}
