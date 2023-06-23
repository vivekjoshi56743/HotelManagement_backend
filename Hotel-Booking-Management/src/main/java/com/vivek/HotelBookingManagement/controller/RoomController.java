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
import org.springframework.web.bind.annotation.RestController;

import com.vivek.HotelBookingManagement.dao.Room;
import com.vivek.HotelBookingManagement.service.RoomService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class RoomController {
	
	@Autowired
	RoomService service;
	
	@GetMapping("/room")
	public List<Room> getAllRooms(){
		
		return service.getallrooms(); 
	}
	
	@GetMapping("/room/{room_id}")
	public Optional<Room> getRoombyId(@PathVariable Long room_id) {
		return service.getroombyid(room_id);
	}
	
	@GetMapping("/room/hotel/{hotel_id}")
	public List<Room> getRoombyHotelId(@PathVariable Long hotel_id){
		return service.getroombyhotelid(hotel_id);
	}
	
	@PostMapping("/room/add")
	public ResponseEntity<Room> addRoom(@RequestBody Room room){
		room.setIsAvailable(true);
		return service.addroom(room);
	}
	
	@DeleteMapping("room/delete/{room_id}")
	public ResponseEntity<Room> deleteRoom(@PathVariable Long room_id){
		return service.deleteroom(room_id);
	}
}
