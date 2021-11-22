package com.vedika.functionhall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedika.functionhall.model.BookingSlot;
import com.vedika.functionhall.service.BookingService;

@RestController
@RequestMapping("/api")
public class BookingController {
	@Autowired
	private BookingService bookingService;

	@PostMapping("/bookingSlot")
	public String bookingSlot(@RequestBody BookingSlot bookingslot) {
		return bookingService.bookingSlotforUser(bookingslot);
	}

}
