package com.cdac_project.project.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name =  "bill_table")
public class Bill {
 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Long id;

    @Column(name = "Order_id")
    private int orderId;

    @Column(name = "pharmacist_id")
    private int pharmacistId;

    @Column(name = "Pharmacist_Name")
    private String pharmacistName;

    @Column(name = "medicine_id")
    private int medicineId;

    @Column(name = "Medicine_name")
    private String medicineName;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "Total_Amount")
    private double totalAmount;

    @Column(name = "Discount_price")
    private int discountPrice;

    @Column(name = "Discounted_price")
    private int discountedPrice;

    @Column(name = "To_Pay_Amount")
    private int toPayAmount;

    @Column(name = "Billing_Date")
    private LocalDateTime billingDate;

	public Bill() {
		super();
	}

	public Bill(Long id, int orderId, int pharmacistId, String pharmacistName, int medicineId, String medicineName,
			int quantity, double totalAmount, int discountPrice, int discountedPrice, int toPayAmount,
			LocalDateTime billingDate) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.pharmacistId = pharmacistId;
		this.pharmacistName = pharmacistName;
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.discountPrice = discountPrice;
		this.discountedPrice = discountedPrice;
		this.toPayAmount = toPayAmount;
		this.billingDate = billingDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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

	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}

	public int getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(int discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public int getToPayAmount() {
		return toPayAmount;
	}

	public void setToPayAmount(int toPayAmount) {
		this.toPayAmount = toPayAmount;
	}

	public LocalDateTime getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(LocalDateTime billingDate) {
		this.billingDate = billingDate;
	}

    
}
