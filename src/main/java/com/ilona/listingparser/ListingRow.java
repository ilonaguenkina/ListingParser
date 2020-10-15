package com.ilona.listingparser;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="listing")
public class ListingRow {

	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "bedrooms")
	private int bedrooms;
	
	@Column(name = "bathrooms")
	private int bathrooms;
	
	@Column(name = "sq_ft")
	private int sqFt;
	
	@Column(name = "lat")
	private float lat;
	
	@Column(name = "lng")
	private float lng;
	
	public String getId() {
		return id;
	}
	
	public ListingRow() {
	}

	public ListingRow(String id, String street, String status, int price, int bedrooms,
										int bathrooms, int sqFt,float lat, float lng) {
		this.id = id;
		this.street = street;
		this.status = status;
		this.price = price;
		this.bedrooms = bedrooms;
		this.bathrooms = bathrooms;
		this.sqFt = sqFt;
		this.lat = lat;
		this.lng = lng;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getBedrooms() {
		return bedrooms;
	}
	
	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}
	
	public int getBathrooms() {
		return bathrooms;
	}
	
	public void setBathrooms(int bathrooms) {
		this.bathrooms = bathrooms;
	}
	
	public int getSqFt() {
		return sqFt;
	}
	
	public void setSqFt(int sqFt) {
		this.sqFt = sqFt;
	}
	
	public float getLat() {
		return lat;
	}
	
	public void setLat(float lat) {
		this.lat = lat;
	}
	
	public float getLng() {
		return lng;
	}
	
	public void setLng(float lng) {
		this.lng = lng;
	}
}
