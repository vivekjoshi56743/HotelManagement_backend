package com.vivek.HotelBookingManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.HotelBookingManagement.dao.Booking;
import com.vivek.HotelBookingManagement.service.BookingService;

@RestController
public class BookingController {
	
	@Autowired
	BookingService service;
	
	@GetMapping("/bookings/user/{user_id}")
	public List<Booking> gebookingByUserId(@PathVariable Long user_id){
		return  service.getbookingbyuserid(user_id);
		
	}
	
	@GetMapping("/bookings")
	public List<Booking> getAllBookings(){
		return service.getAllBookings();
	}
	@GetMapping("/bookings/{booking_id}")
	public Optional<Booking> getBookingByBookingId(@PathVariable Long booking_id){
		return service.getBookingByBookingId(booking_id);
	}
	
	@PostMapping("/bookings/add")
	public ResponseEntity<String> addBooking(@RequestBody Booking booking){
		return service.addbooking(booking);
	}
	
	@DeleteMapping("/bookings/delete/{booking_id}")
	public ResponseEntity<Booking> deleteBooking(@PathVariable Long booking_id){
		return service.deletebooking(booking_id);
	}
	
	
	
	
}
