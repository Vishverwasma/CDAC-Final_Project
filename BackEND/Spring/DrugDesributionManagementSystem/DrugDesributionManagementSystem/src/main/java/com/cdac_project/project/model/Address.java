package com.cdac_project.project.model;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "address")
//@NamedQuery(name = "Address.findByPharmacistid", 
//query = "SELECT a FROM Address a WHERE a.pharmacist_id = :pharmacistId")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int addressid;

    @Column(name = "pharmacist_id")
    private int pharmacistid;
    
    @Column(name = "pharmacist_name") 
    private String name;

    @Column(name = "Full_Address")
    private String FullAddress;

	public Address() {
		super();
	}

	public Address(int addressid, int pharmacistid, String name, String fullAddress) {
		super();
		this.addressid = addressid;
		this.pharmacistid = pharmacistid;
		this.name = name;
		FullAddress = fullAddress;
	}

	public Address(int pharmacistid, String name, String fullAddress) {
		super();
		this.pharmacistid = pharmacistid;
		this.name = name;
		FullAddress = fullAddress;
	}

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public int getPharmacistid() {
		return pharmacistid;
	}

	public void setPharmacistid(int pharmacistid) {
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
}
