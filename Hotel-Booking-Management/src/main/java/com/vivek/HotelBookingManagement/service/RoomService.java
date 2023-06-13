package com.vivek.HotelBookingManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.vivek.HotelBookingManagement.dao.Room;

public interface RoomService {

	List<Room> getallrooms();

	Optional<Room> getroombyid(Long room_id);

	ResponseEntity<Room> addroom(Room room);

	ResponseEntity<Room> deleteroom(Long room_id);

	List<Room> getroombyhotelid(Long hotel_id);

}
