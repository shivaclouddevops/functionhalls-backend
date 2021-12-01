package com.vedika.functionhall.service;

import com.vedika.functionhall.model.BookingSlot;
import com.vedika.functionhall.model.PaymentCallback;
import com.vedika.functionhall.model.PaymentDetail;
import com.vedika.functionhall.model.PaymentInfo;

public interface PaymentService {

	// String payuCallback(PaymentInfo paymentCallback);

	PaymentDetail proceedPayment(PaymentDetail paymentDetail);

	String payuCallback(PaymentInfo paymentinfo, BookingSlot bookingslot);

}
