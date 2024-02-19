package com.cdac_project.project.model;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressid;

    @Column(name = "pharmacist_id")
    private Long pharmacistid;
    
    @Column(name = "name")
    private String name;

    @Column(name = "Full_Address")
    private String FullAddress;

	public Address() {
		super();
	}

	public Long getAddressid() {
		return addressid;
	}

	public void setAddressid(Long addressid) {
		this.addressid = addressid;
	}

	public Long getPharmacistid() {
		return pharmacistid;
	}

	public void setPharmacistid(Long pharmacistid) {
		this.pharmacistid = pharmacistid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullAddress() {
		return FullAddress;
	}

	public void setFullAddress(String fullAddress) {
		FullAddress = fullAddress;
	}

	public Address(Long addressid, Long pharmacistid, String name, String fullAddress) {
		super();
		this.addressid = addressid;
		this.pharmacistid = pharmacistid;
		this.name = name;
		FullAddress = fullAddress;
	}


    
}
