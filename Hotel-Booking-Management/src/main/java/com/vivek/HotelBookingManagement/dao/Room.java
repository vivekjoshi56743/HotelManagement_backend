package com.vivek.HotelBookingManagement.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "rooms")

public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "room_id")
	private Long roomId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "hotel_id", nullable = false)
	private Hotels hotel;

	@Column(name = "room_number", nullable = false)
	private String roomNumber;

	@Column(name = "price", nullable = false)
	private BigDecimal price;

	@Column(name = "capacity", nullable = false)
	private Integer capacity;

	@Column(name = "is_available", nullable = false)
	private Boolean isAvailable;
	
	@OneToMany(mappedBy = "room", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Booking> bookings = new ArrayList<>();

	public Room() {
		super();
	}

	public Room(Long room_id, Hotels hotel, String roomNumber, BigDecimal price, Integer capacity,
			Boolean isAvailable) {
		super();
		this.roomId = room_id;
		this.hotel = hotel;
		this.roomNumber = roomNumber;
		this.price = price;
		this.capacity = capacity;
		this.isAvailable = isAvailable;
	}

	public Long getRoom_id() {
		return roomId;
	}

	public void setRoom_id(Long room_id) {
		this.roomId = room_id;
	}

	public Hotels getHotel() {
		return hotel;
	}

	public void setHotel(Hotels hotel) {
		this.hotel = hotel;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "Room [room_id=" + roomId + ", hotel=" + hotel + ", roomNumber=" + roomNumber + ", price=" + price
				+ ", capacity=" + capacity + ", isAvailable=" + isAvailable + "]";
	}
	
	

}
