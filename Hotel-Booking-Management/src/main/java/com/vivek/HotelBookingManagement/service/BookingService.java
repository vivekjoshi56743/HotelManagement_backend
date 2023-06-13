package com.vivek.HotelBookingManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.vivek.HotelBookingManagement.dao.Booking;

public interface BookingService {
	
	List<Booking> getbookingbyuserid(Long user_id) ;

	List<Booking> getAllBookings();

	Optional<Booking> getBookingByBookingId(Long booking_id);

	ResponseEntity<String> addbooking(Booking booking);

	ResponseEntity<Booking> deletebooking(Long booking_id);

}
