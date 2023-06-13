package com.vivek.HotelBookingManagement.dao;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "hotels")
public class Hotels {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="hotel_id")
	private Long hotelId;
	

    @Column(name = "name", nullable = false)
	private String name;

    @Column(name = "address", nullable = false)
	private String address;

    @Column(name = "phone_number", nullable = false)
	private String phoneNumber;
    
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Room> rooms = new ArrayList<>();
    
    public Hotels() {
    	
    }
    
    
	public Hotels(Long hotel_id, String name, String address, String phoneNumber) {
		super();
		this.hotelId = hotel_id;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}



	public Long getHotel_id() {
		return hotelId;
	}

	public void setHotel_id(Long hotel_id) {
		this.hotelId = hotel_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	@Override
	public String toString() {
		return "Hotels [hotel_id=" + hotelId + ", name=" + name + ", address=" + address + ", phoneNumber="
				+ phoneNumber + "]";
	}
	
	
	

}
