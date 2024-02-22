package com.cdac_project.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "order_db")
public class Order {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;

    @OneToMany(mappedBy ="order")
    private List<OrderMedicine> om = new ArrayList<>();
    
    @Column(name = "Medicine_id")
    private int medicineId;

    @Column(name = "Medicine_Name")
    @Transient
    private String medicineName;

    @Column(name = "pharmacist_id")
    private int pharmacistId;

    @Column(name = "pharmacist_name")
    @Transient
    private String pharmacistName;

    @ManyToOne
    private Pharmacist pharmacist;
    
    @OneToOne
    @Transient
    private Address ShippingAddress;
    
    @Column(name = "ShippingAddress_id")
    //@Transient
    private int ShippingAddress_id;
    
	@Column(name = "Price")
    private double price;

    @Column(name = "Order_Date")
    private LocalDateTime orderDate;

    @Column(name = "Delivery_Date")
    private LocalDateTime deliveryDate;

    @Column(name = "bill_id")
    private int billId;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

    public int getShippingAddress_id() {
		return ShippingAddress_id;
	}

	public void setShippingAddress_id(int shippingAddress_id) {
		ShippingAddress_id = shippingAddress_id;
	}

	

	public List<OrderMedicine> getOm() {
		return om;
	}

	public void setOm(List<OrderMedicine> om) {
		this.om = om;
	}

	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	public Pharmacist getPharmacist() {
		return pharmacist;
	}

	public void setPharmacist(Pharmacist pharmacist) {
		this.pharmacist = pharmacist;
	}

	public Address getShippingAddress() {
		return ShippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		ShippingAddress = shippingAddress;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public int getPharmacistId() {
		return pharmacistId;
	}

	public void setPharmacistId(int pharmacistId) {
		this.pharmacistId = pharmacistId;
	}

	public String getPharmacistName() {
		return pharmacistName;
	}

	public void setPharmacistName(String pharmacistName) {
		this.pharmacistName = pharmacistName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDateTime getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDateTime deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


    	

		

		public Order(List<OrderMedicine> om, int medicineId, String medicineName, int pharmacistId, String pharmacistName,
			Pharmacist pharmacist, Address shippingAddress, int shippingAddress_id, double price,
			LocalDateTime orderDate, LocalDateTime deliveryDate, int billId, LocalDateTime createdAt) {
		super();
		this.om = om;
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.pharmacistId = pharmacistId;
		this.pharmacistName = pharmacistName;
		this.pharmacist = pharmacist;
		ShippingAddress = shippingAddress;
		ShippingAddress_id = shippingAddress_id;
		this.price = price;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.billId = billId;
		this.createdAt = createdAt;
	}

		public Order(int id, List<OrderMedicine> om, int medicineId, String medicineName, int pharmacistId,
			String pharmacistName, Pharmacist pharmacist, Address shippingAddress, int shippingAddress_id, double price,
			LocalDateTime orderDate, LocalDateTime deliveryDate, int billId, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.om = om;
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.pharmacistId = pharmacistId;
		this.pharmacistName = pharmacistName;
		this.pharmacist = pharmacist;
		ShippingAddress = shippingAddress;
		ShippingAddress_id = shippingAddress_id;
		this.price = price;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.billId = billId;
		this.createdAt = createdAt;
	}

		public Order() {
		super();
	}

	
}
