package com.cdac_project.project.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="cart_medicine")
public class CartMedicine {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;

    @Column(name = "pharmacist_id")
    private int pharmacistId;

    @JsonIgnore
    @ManyToOne
    private Cart cart;

    @Column(name = "medicine_id")
    private int medicineId;

    @ManyToOne
    private Medicine medicine;
    
    @Column(name = "quantity")
    private int quantity;

    private  int price ;
    
    
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public CartMedicine() {
		super();
	}

	public CartMedicine(Long id, int pharmacistId, int medicineId, int quantity) {
		super();
		this.id = id;
		this.pharmacistId = pharmacistId;
		this.medicineId = medicineId;
		this.quantity = quantity;
	}
	
	

	public CartMedicine(Long id, int pharmacistId, Cart cart, int medicineId, Medicine medicine, int quantity,
			int price) {
		super();
		this.id = id;
		this.pharmacistId = pharmacistId;
		this.cart = cart;
		this.medicineId = medicineId;
		this.medicine = medicine;
		this.quantity = quantity;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPharmacistId() {
		return pharmacistId;
	}

	public void setPharmacistId(int pharmacistId) {
		this.pharmacistId = pharmacistId;
	}

	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
    

}
