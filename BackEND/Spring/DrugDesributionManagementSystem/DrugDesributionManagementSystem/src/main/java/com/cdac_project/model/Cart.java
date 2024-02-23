package com.cdac_project.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "cart", uniqueConstraints = @UniqueConstraint(columnNames = {"pharmacist_id"}))
public class Cart {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pharmacist_id", nullable = false)
	private Pharmacist pharmacist;
	
	@OneToMany(mappedBy = "cart" , cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(name = "cart_medicines")
	private Set<CartMedicine> cartMedicine = new HashSet<>();
	
	@Column(name="total_item")
	private int totalItem;
	
	private int totalPrice;

	public Cart(int id, Pharmacist pharmacist, Set<CartMedicine> cartMedicine, int totalItem, int totalPrice) {
		super();
		this.id = id;
		this.pharmacist = pharmacist;
		this.cartMedicine = cartMedicine;
		this.totalItem = totalItem;
		this.totalPrice = totalPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pharmacist getPharmacist() {
		return pharmacist;
	}

	public void setPharmacist(Pharmacist pharmacist) {
		this.pharmacist = pharmacist;
	}

	public Set<CartMedicine> getCartMedicine() {
		return cartMedicine;
	}

	public void setCartMedicine(Set<CartMedicine> cartMedicine) {
		this.cartMedicine = cartMedicine;
	}

	public int getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Cart() {
		super();
	}
	
	
}
