package com.vivek.HotelBookingManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vivek.HotelBookingManagement.dao.Room;
import com.vivek.HotelBookingManagement.repo.RoomRepo;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomRepo repo;

	@Override
	public List<Room> getallrooms() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<Room> getroombyid(Long room_id) {
		// TODO Auto-generated method stub
		return repo.findById(room_id);
	}

	@Override
	public ResponseEntity<Room> addroom(Room room) {
		// TODO Auto-generated method stub
		try {
			Room newroom = repo.save(room);
			return ResponseEntity.ok(newroom);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.unprocessableEntity().build();
		}
	}

	@Override
	public ResponseEntity<Room> deleteroom(Long room_id) {
		// TODO Auto-generated method stub
		try {
			repo.findById(room_id);
			repo.deleteById(room_id);
			return ResponseEntity.noContent().build();
		}
		catch (Exception e) {	
			return ResponseEntity.unprocessableEntity().build();
		}
	}

	@Override
	public List<Room> getroombyhotelid(Long hotel_id) {
		// TODO Auto-generated method stub
		return repo.findByHotel_HotelId(hotel_id);
	}

}
