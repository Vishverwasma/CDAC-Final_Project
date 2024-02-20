package com.cdac_project.project.model;

import java.time.LocalDate;

public class MedicineSearchCriteria {
    private String medicineName;
    private int categoryId;
    private Integer minQuantity;
    private Integer maxQuantity;
    private Double minPrice;
    private Double maxPrice;
    private LocalDate minManufactureDate;
    private LocalDate maxManufactureDate;
	public MedicineSearchCriteria() {
		super();
	}
	public MedicineSearchCriteria(String medicineName, int categoryId, Integer minQuantity, Integer maxQuantity,
			Double minPrice, Double maxPrice, LocalDate minManufactureDate, LocalDate maxManufactureDate) {
		super();
		this.medicineName = medicineName;
		this.categoryId = categoryId;
		this.minQuantity = minQuantity;
		this.maxQuantity = maxQuantity;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.minManufactureDate = minManufactureDate;
		this.maxManufactureDate = maxManufactureDate;
	}
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
	public Integer getMinQuantity() {
		return minQuantity;
	}
	public void setMinQuantity(Integer minQuantity) {
		this.minQuantity = minQuantity;
	}
	public Integer getMaxQuantity() {
		return maxQuantity;
	}
	public void setMaxQuantity(Integer maxQuantity) {
		this.maxQuantity = maxQuantity;
	}
	public Double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}
	public Double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public LocalDate getMinManufactureDate() {
		return minManufactureDate;
	}
	public void setMinManufactureDate(LocalDate minManufactureDate) {
		this.minManufactureDate = minManufactureDate;
	}
	public LocalDate getMaxManufactureDate() {
		return maxManufactureDate;
	}
	public void setMaxManufactureDate(LocalDate maxManufactureDate) {
		this.maxManufactureDate = maxManufactureDate;
	}

    // Getters and setters...
    
    
}
