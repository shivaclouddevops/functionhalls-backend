package com.vedika.functionhall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedika.functionhall.model.BookingSlot;
import com.vedika.functionhall.repository.BookingRepo;

@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	private BookingRepo bookingRepo;

	@Override
	public String bookingSlotforUser(BookingSlot bookingslot) {
		if (checkAllBookingSlot(bookingslot) == false)

		{
			return "this slot is already booked.please try for other date and time";
		} else {

			return " Hi " + "your booking  " + bookingslot.getDate() + "and" + bookingslot.getTimeSlot()
					+ " is available";
		}
	}

	private boolean checkAllBookingSlot(BookingSlot bookingslot) {

		List<BookingSlot> findAllBookingSlots = bookingRepo.findAll();

		for (BookingSlot slot : findAllBookingSlots) {

			if (bookingslot.getDate().equals(slot.getDate()) && bookingslot.getTimeSlot().equals(slot.getTimeSlot())) {
				return Boolean.FALSE;
			}
		}
		return Boolean.TRUE;

	}
}