package com.cdac_project.request;

import java.time.LocalDate;

import javax.persistence.Column;

public class CreateMedicineRequest {

	// private int Medicine_id;
	 private String Medicinename;
	 private int Categoryid;
	 private int MedicineQuantity;
	 private LocalDate ManufactureDate;
	 private int UnitPrice; 
	 private int pharmacistId;
     private int medicineId;
	 
	 
	 
	 
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
	public CreateMedicineRequest() {
		super();
	}
	

	public CreateMedicineRequest(String medicinename, int categoryid, int medicineQuantity, LocalDate manufactureDate,
			int unitPrice, int pharmacistId, int medicineId) {
		super();
		Medicinename = medicinename;
		Categoryid = categoryid;
		MedicineQuantity = medicineQuantity;
		ManufactureDate = manufactureDate;
		UnitPrice = unitPrice;
		this.pharmacistId = pharmacistId;
		this.medicineId = medicineId;
	}
	public String getMedicinename() {
		return Medicinename;
	}
	public void setMedicinename(String medicine_name) {
		Medicinename = medicine_name;
	}
	public int getCategoryid() {
		return Categoryid;
	}
	public void setCategoryid(int category_id) {
		Categoryid = category_id;
	}
	public int getMedicineQuantity() {
		return MedicineQuantity;
	}
	public void setMedicineQuantity( int medicine_Quantity) {
		MedicineQuantity = medicine_Quantity;
	}
	public LocalDate getManufactureDate() {
		return ManufactureDate;
	}
	public void setManufactureDate(LocalDate manufacture_Date) {
		ManufactureDate = manufacture_Date;
	}
	public int getUnitPrice() {
		return UnitPrice;
	}
	public void setUnitPrice( int unit_Price) {
		UnitPrice = unit_Price;
	}
	/**
	 * @return the category_Name
	 */
//	public String getCategory_Name() {
//		return Category_Name;
//	}
//	/**
//	 * @param category_Name the category_Name to set
//	 */
//	public void setCategory_Name(String category_Name) {
//		Category_Name = category_Name;
//	}
	 
}
