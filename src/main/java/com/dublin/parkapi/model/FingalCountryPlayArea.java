package com.dublin.parkapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fingal_country_play_area")
public class FingalCountryPlayArea {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;

	private String address1;

	private String address2;

	private String address3;

	private String address4;

	private String phone;

	private String email;

	private String website;

	private String type;

	private String category;

	private String openingHours;

	@Column(columnDefinition = "TEXT")
	private String directions;

	private String surfaceType;

	private String comments;

	private String accessiblePlayItems;

	private String disabledParking;

	private String parkRanger;

	private String toilets;

	private String disabledToilets;

	private String babyChanging;

	private String seating;

	private String drinkingWater;

	private String latitude;

	private String longitude;

	public FingalCountryPlayArea() {
	}

	public FingalCountryPlayArea(String name, String address1, String address2, String address3, String address4, String phone,
			String email, String website, String type, String category, String openingHours, String directions,
			String surfaceType, String comments, String accessiblePlayItems, String disabledParking, String parkRanger,
			String toilets, String disabledToilets, String babyChanging, String seating, String drinkingWater,
			String latitude, String longitude) {
		this.name = name;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.address4 = address4;
		this.phone = phone;
		this.email = email;
		this.website = website;
		this.type = type;
		this.category = category;
		this.openingHours = openingHours;
		this.directions = directions;
		this.surfaceType = surfaceType;
		this.comments = comments;
		this.accessiblePlayItems = accessiblePlayItems;
		this.disabledParking = disabledParking;
		this.parkRanger = parkRanger;
		this.toilets = toilets;
		this.disabledToilets = disabledToilets;
		this.babyChanging = babyChanging;
		this.seating = seating;
		this.drinkingWater = drinkingWater;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getAddress4() {
		return address4;
	}

	public void setAddress4(String address4) {
		this.address4 = address4;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getOpeningHours() {
		return openingHours;
	}

	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}

	public String getDirections() {
		return directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public String getSurfaceType() {
		return surfaceType;
	}

	public void setSurfaceType(String surfaceType) {
		this.surfaceType = surfaceType;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getAccessiblePlayItems() {
		return accessiblePlayItems;
	}

	public void setAccessiblePlayItems(String accessiblePlayItems) {
		this.accessiblePlayItems = accessiblePlayItems;
	}

	public String getDisabledParking() {
		return disabledParking;
	}

	public void setDisabledParking(String disabledParking) {
		this.disabledParking = disabledParking;
	}

	public String getParkRanger() {
		return parkRanger;
	}

	public void setParkRanger(String parkRanger) {
		this.parkRanger = parkRanger;
	}

	public String getToilets() {
		return toilets;
	}

	public void setToilets(String toilets) {
		this.toilets = toilets;
	}

	public String getDisabledToilets() {
		return disabledToilets;
	}

	public void setDisabledToilets(String disabledToilets) {
		this.disabledToilets = disabledToilets;
	}

	public String getBabyChanging() {
		return babyChanging;
	}

	public void setBabyChanging(String babyChanging) {
		this.babyChanging = babyChanging;
	}

	public String getSeating() {
		return seating;
	}

	public void setSeating(String seating) {
		this.seating = seating;
	}

	public String getDrinkingWater() {
		return drinkingWater;
	}

	public void setDrinkingWater(String drinkingWater) {
		this.drinkingWater = drinkingWater;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
}
