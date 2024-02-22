package com.cdac_project.model;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "pharmacist_db", uniqueConstraints = @UniqueConstraint(columnNames = "pharmacist_Email"))
public class Pharmacist {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "pharmacist_id")
	    private Integer id;

	    @Column(name = "pharmacist_name")
	    private String name;

	    @Column(name = "License_Number")
	    private String licenseNumber;

	    @Column(name = "pharmacist_Email")
	    private String email;

	    @Column(name = "Address")
	    private String address;

	    @Column(name = "Password")
	    private String password;
	    
	    @OneToMany(mappedBy = "pharmacist")
	    private List<Order> orders;

		public Pharmacist(int id, String name, String licenseNumber, String email, String address, String password) {
			super();
			this.id = id;
			this.name = name;
			this.licenseNumber = licenseNumber;
			this.email = email;
			this.address = address;
			this.password = password;
		}

		public Integer getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLicenseNumber() {
			return licenseNumber;
		}

		public void setLicenseNumber(String licenseNumber) {
			this.licenseNumber = licenseNumber;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String addressId) {
			this.address = addressId;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Pharmacist() {
			super();
		}
  
	    

	
}
