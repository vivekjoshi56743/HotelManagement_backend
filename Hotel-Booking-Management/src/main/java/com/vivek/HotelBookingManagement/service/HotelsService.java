package com.vivek.HotelBookingManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.vivek.HotelBookingManagement.dao.Hotels;

public interface HotelsService {

	List<Hotels> findallHotels();

	Optional<Hotels> findHotelById(Long id);

	ResponseEntity<String> create(Hotels hotel);

	ResponseEntity<String> delete(Long hotel_id);
	
	
}
