package com.vivek.HotelBookingManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.HotelBookingManagement.dao.Hotels;
import com.vivek.HotelBookingManagement.service.HotelsService;

@RestController
@RequestMapping("/hotels")
@CrossOrigin(origins="http://localhost:3000")
public class HotelsController {

	// private Logger logger=LoggerFactory.getLogger(this.getClass());

	@Autowired
	HotelsService service;
	
	
	@GetMapping
	public List<Hotels> getHotels() {
		return service.findallHotels();
	}

	@GetMapping("/{hotel_id}")
	public ResponseEntity<Hotels> getHotelById(@PathVariable Long hotel_id) {
		Optional<Hotels> hotel = service.findHotelById(hotel_id);

		return ResponseEntity.of(hotel);

	}
	
	@PostMapping
	public ResponseEntity<String> createHotel(@RequestBody Hotels hotel) {
		
		ResponseEntity<String> res = service.create(hotel);
		
		
		return res;
	}

	@DeleteMapping("/remove/{hotel_id}")
	public  ResponseEntity<String> deleteHotel(@PathVariable Long hotel_id) {
		
		return service.delete(hotel_id);
	}

}
