package com.dublin.parkapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dublin_city_play_area")
public class DublinCityPlayArea {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;

	@Column(columnDefinition = "TEXT")
	private String openingHours;

	private String phoneNumber;

	private String email;

	@Column(columnDefinition = "TEXT")
	private String facilities;

	@Column(columnDefinition = "TEXT")
	private String accessibility;

	private String addressLineOne;

	private String dependentLocality;

	private String locality;

	private String administrativeArea;

	private String postalCode;

	private String country;

	public DublinCityPlayArea() {
	}

	public DublinCityPlayArea(String name, String openingHours, String phoneNumber, String email, String facilities,
			String accessibility, String addressLineOne, String dependentLocality, String locality,
			String administrativeArea, String postalCode, String country) {
		this.name = name;
		this.openingHours = openingHours;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.facilities = facilities;
		this.accessibility = accessibility;
		this.addressLineOne = addressLineOne;
		this.dependentLocality = dependentLocality;
		this.locality = locality;
		this.administrativeArea = administrativeArea;
		this.postalCode = postalCode;
		this.country = country;
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

	public String getOpeningHours() {
		return openingHours;
	}

	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	public String getAccessibility() {
		return accessibility;
	}

	public void setAccessibility(String accessibility) {
		this.accessibility = accessibility;
	}

	public String getAddressLineOne() {
		return addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getDependentLocality() {
		return dependentLocality;
	}

	public void setDependentLocality(String dependentLocality) {
		this.dependentLocality = dependentLocality;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getAdministrativeArea() {
		return administrativeArea;
	}

	public void setAdministrativeArea(String administrativeArea) {
		this.administrativeArea = administrativeArea;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
