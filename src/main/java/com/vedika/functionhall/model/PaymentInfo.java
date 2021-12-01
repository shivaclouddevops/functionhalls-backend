package com.vedika.functionhall.model;

public class PaymentInfo {
	private String functionhallId;
	private String date;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	private String timeSlot;
	public String getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}
	private String mihpayid;
	private String status;
	private PaymentMode mode;
	private String txnid;
	private String hash;
	public String getFunctionhallId() {
		return functionhallId;
	}
	public void setFunctionhallId(String functionhallId) {
		this.functionhallId = functionhallId;
	}
	public String getMihpayid() {
		return mihpayid;
	}
	public void setMihpayid(String mihpayid) {
		this.mihpayid = mihpayid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

	public String getTxnid() {
		return txnid;
	}
	public void setTxnid(String txnid) {
		this.txnid = txnid;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public PaymentMode getMode() {
		return mode;
	}
	public void setMode(PaymentMode mode) {
		this.mode = mode;
	}
	@Override
	public String toString() {
		return "PaymentInfo [functionhallId=" + functionhallId + ", date=" + date + ", timeSlot=" + timeSlot
				+ ", mihpayid=" + mihpayid + ", status=" + status + ", mode=" + mode + ", txnid=" + txnid + ", hash="
				+ hash + "]";
	}
	
	
	

}
