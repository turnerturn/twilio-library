package com.turndawg.toolbox.twilio.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Value;

import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.lookups.v1.PhoneNumber;

public class TwilioPhoneNumberValidator implements ConstraintValidator<TwilioPhoneNumber, String> {


	@Value("${TWILIO_ACCOUNT_SID}")
	public String twilioAccountSid;
	@Value("${TWILIO_AUTH_TOKEN}")
	public String twilioAuthToken;

	@Override
	public void initialize(TwilioPhoneNumber constraintAnnotation) {
		Twilio.init(twilioAccountSid, twilioAuthToken);
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		// The Lookup API requires your phone number in E.164 format
		// E.164 formatted phone numbers must not have spaces in them
		value = value.replaceAll("[\\s()-]", "");

		if (value == null || "".equals(value)) {
			return false;
		}

		try {
			PhoneNumber.fetcher(new com.twilio.type.PhoneNumber(value)).fetch();
			return true;

		} catch (ApiException e) {
			// The Lookup API returns HTTP 404 if the phone number is not found
			// (ie it is not a real phone number)
			if (e.getStatusCode() == 404) {
				return false;
			}
			throw e;
		}
	}
}