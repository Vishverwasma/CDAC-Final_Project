package com.cdac_project.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

public class MedicineSearchCriteria {
    private String medicineName;
    private int categoryId;
    private Integer Quantity;
    private Integer Price;
    private LocalDate ManufactureDate;
	public MedicineSearchCriteria() {
		super();
	}
    // Getters and setters...
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getQuantity() {
		return Quantity;
	}
	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}
	public Integer getPrice() {
		return Price;
	}
	public void setPrice(Integer price) {
		Price = price;
	}
	public LocalDate getManufactureDate() {
		return ManufactureDate;
	}
	public void setManufactureDate(LocalDate manufactureDate) {
		ManufactureDate = manufactureDate;
	}
	public MedicineSearchCriteria(String medicineName, int categoryId, Integer quantity, Integer price,
			LocalDate manufactureDate) {
		super();
		this.medicineName = medicineName;
		this.categoryId = categoryId;
		Quantity = quantity;
		Price = price;
		ManufactureDate = manufactureDate;
	}
    
    
}
