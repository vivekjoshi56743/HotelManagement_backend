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
		Room room = booking.getRoom();

		List<Booking> existingBookings = bookingRepo.findByRoomAndStartDateLessThanEqualAndEndDateGreaterThanEqual(room,
				endDate, startDate);
		if (!existingBookings.isEmpty()) {
			return ResponseEntity.badRequest().body("Room is already booked for the specified dates");
		}
		try {
			Booking saved = bookingRepo.save(booking);
			return ResponseEntity.ok().body("booking Completed with Bookingid "+ saved.getBooking_id()+" for user with userId= "+saved.getUser().getUserId());
		} catch (Exception e) {
			return ResponseEntity.unprocessableEntity().build();
		}
	}

	@Override
	public ResponseEntity<Booking> deletebooking(Long booking_id) {
		// TODO Auto-generated method stub
		try {
			bookingRepo.findById(booking_id);
			bookingRepo.deleteById(booking_id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.unprocessableEntity().build();
		}
	}

}
