package com.vivek.HotelBookingManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vivek.HotelBookingManagement.dao.Hotels;
import com.vivek.HotelBookingManagement.repo.HotelsRepo;

@Service
public class HotelsServiceImpl implements HotelsService {
	@Autowired
	private HotelsRepo hotelsrepo;

	@Override
	public List<Hotels> findallHotels() {
		return hotelsrepo.findAll();
	}

	@Override
	public Optional<Hotels> findHotelById(Long id) {
		// TODO Auto-generated method stub
		return hotelsrepo.findById(id);
	}

	@Override
	public ResponseEntity<String> create(Hotels hotel) {
		try {
			Hotels savedHotel = hotelsrepo.save(hotel);
			if (savedHotel != null) {
				return ResponseEntity.ok("Hotel created successfully");
			} else {
				return new ResponseEntity<>("not created", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("not created", HttpStatus.BAD_REQUEST);
		}

	}

	@Override
	public ResponseEntity<String> delete(Long hotel_id) {

		if (hotelsrepo.existsById(hotel_id)) {
			hotelsrepo.deleteById(hotel_id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>("id not found", HttpStatus.NOT_FOUND);
		}

	}

}
