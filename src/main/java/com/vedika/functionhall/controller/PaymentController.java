package com.vedika.functionhall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vedika.functionhall.model.BookingSlot;
import com.vedika.functionhall.model.PaymentCallback;
import com.vedika.functionhall.model.PaymentDetail;
import com.vedika.functionhall.model.PaymentInfo;
import com.vedika.functionhall.model.PaymentMode;
import com.vedika.functionhall.service.BookingService;
import com.vedika.functionhall.service.PaymentService;

@RestController
@RequestMapping("/api")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	@Autowired
	private BookingService bookingService;

	@PostMapping(path = "/payment-details")
	public PaymentDetail proceedPayment(@RequestBody PaymentDetail paymentDetail) {
		return paymentService.proceedPayment(paymentDetail);
	}

	@RequestMapping(path = "/payment-response", method = RequestMethod.POST)
	public @ResponseBody String payuCallback(@RequestBody PaymentInfo paymentinfo, BookingSlot bookingslot) {
		return paymentService.payuCallback(paymentinfo, bookingslot);
	}

	@PostMapping(path = "/bookingAvailablility")
	public String booking(@RequestBody BookingSlot bookingslot) {
		return bookingService.bookingSlotforUser(bookingslot);
	}

}