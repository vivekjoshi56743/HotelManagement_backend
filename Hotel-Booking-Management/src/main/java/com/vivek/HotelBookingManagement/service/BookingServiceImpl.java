package com.vivek.HotelBookingManagement.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vivek.HotelBookingManagement.dao.Booking;
import com.vivek.HotelBookingManagement.dao.Room;
import com.vivek.HotelBookingManagement.repo.BookingRepo;

@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	private BookingRepo bookingRepo;

	@Override
	public List<Booking> getbookingbyuserid(Long user_id) {
		// bookingRepo.findByStartDate(LocalDate.now() );

		return bookingRepo.findByUser_UserId(user_id);
	}

	@Override
	public List<Booking> getAllBookings() {
		// TODO Auto-generated method stub
		return bookingRepo.findAll();
	}

	@Override
	public Optional<Booking> getBookingByBookingId(Long booking_id) {
		// TODO Auto-generated method stub
		return bookingRepo.findById(booking_id);
	}

	@Override
	public ResponseEntity<String> addbooking(Booking booking) {
		// TODO Auto-generated method stub

		LocalDate startDate = booking.getStartDate();
		LocalDate endDate = booking.getEndDate();
		if(startDate.isBefore(LocalDate.now() )) {
			return  ResponseEntity.badRequest().body("Start Date should not be less than Current date: "+LocalDate.now());
		}
		if(startDate.isAfter(endDate)) {
		 return ResponseEntity.badRequest().body("End Date Cannot be Less than Start Date");
		}
		Room room = booking.getRoom();

		List<Booking> existingBookings = bookingRepo.findByRoomAndStartDateLessThanEqualAndEndDateGreaterThanEqual(room,
				endDate, startDate);
		if (!existingBookings.isEmpty()) {
			return ResponseEntity.badRequest().body("Room is already booked for the specified dates");
		}
		try {
			Booking saved = bookingRepo.save(booking);
			return ResponseEntity.ok().body("Booking Completed with Bookingid: "+ saved.getBooking_id()+" for user");
		} catch (Exception e) {
			return ResponseEntity.unprocessableEntity().build();
		}
	}

	@Override
	public ResponseEntity<Booking> deletebooking(Long booking_id) {
		// TODO Auto-generated method stub
		Optional<Booking> res = bookingRepo.findById(booking_id);
		if(res.isEmpty()) {
			return ResponseEntity.unprocessableEntity().build();
		}
		
		try {
			
			bookingRepo.deleteById(booking_id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.unprocessableEntity().build();
		}
	}

}
