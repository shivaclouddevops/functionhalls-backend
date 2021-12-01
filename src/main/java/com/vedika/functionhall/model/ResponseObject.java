package com.vedika.functionhall.model;

public class ResponseObject {
	private String requestId;
	private String mobileNumber;
	private String message;


	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResponseObject [requestId=" + requestId + ", mobileNumber=" + mobileNumber + ", message=" + message
				+  "]";
	}

	
}
