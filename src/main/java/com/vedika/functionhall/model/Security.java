package com.vedika.functionhall.model;

public class Security {
	private String verificationCode;

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	@Override
	public String toString() {
		return "Security [verificationCode=" + verificationCode + "]";
	}

}
