package com.vedika.functionhall.model;

import java.util.UUID;

public class GenericResponse<T> {

	private String requestId=UUID.randomUUID().toString();
	private T data;

	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
			public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	@Override
	public String toString() {
		return "GenericResponse [requestId=" + requestId + ", data=" + data +  "]";
	}
	


}