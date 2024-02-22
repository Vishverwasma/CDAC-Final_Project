package com.cdac_project.request;

import java.time.LocalDate;

public class MedicineRequest {

	private int id;
	private String medicineName;
    private int categoryId;
    private int medicineQuantity;
    private LocalDate manufactureDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getMedicineQuantity() {
		return medicineQuantity;
	}
	public void setMedicineQuantity(int medicineQuantity) {
		this.medicineQuantity = medicineQuantity;
	}
	public LocalDate getManufactureDate() {
		return manufactureDate;
	}
	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	public MedicineRequest() {
		super();
	}
	public MedicineRequest(int id, String medicineName, int categoryId, int medicineQuantity,
			LocalDate manufactureDate) {
		super();
		this.id = id;
		this.medicineName = medicineName;
		this.categoryId = categoryId;
		this.medicineQuantity = medicineQuantity;
		this.manufactureDate = manufactureDate;
	}
    
    
    
}
