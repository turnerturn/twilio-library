package com.turndawg.toolbox.twilio;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("twilio")
public class TwilioProperties {

	private String accountSid;
	private String authToken;
	public TwilioProperties(String accountSid, String authToken) {
		super();
		this.accountSid = accountSid;
		this.authToken = authToken;
	}
	public String getAccountSid() {
		return accountSid;
	}
	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	
	
}
