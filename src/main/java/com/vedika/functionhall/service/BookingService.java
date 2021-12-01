package com.vedika.functionhall.service;

import org.springframework.stereotype.Service;

import com.vedika.functionhall.model.BookingSlot;
import com.vedika.functionhall.model.FunctionHall;

@Service
public interface BookingService {

	String bookingSlotforUser(BookingSlot bookingslot);

}
