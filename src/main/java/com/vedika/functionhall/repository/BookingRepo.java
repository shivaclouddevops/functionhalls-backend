package com.vedika.functionhall.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vedika.functionhall.model.Bank;
import com.vedika.functionhall.model.BookingSlot;

@Repository
public interface BookingRepo extends MongoRepository<BookingSlot, String> {

	BookingSlot save(BookingSlot bookingslot);


}
