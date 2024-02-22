package com.cdac_project.model;

import javax.persistence.*;

@Entity
@Table(name = "distributor_db", uniqueConstraints = @UniqueConstraint(columnNames = "distributorEmail"))
public class Distributor {
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Distributor_ID")
    private int id;

    @Column(name = "distributor_name")
    private String name;

    @Column(name = "distributorEmail")
    private String email;

    @Column(name = "Password")
    private String password;

	public Distributor() {
		super();
	}

	public Distributor(int id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public int getId() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    
	
}
