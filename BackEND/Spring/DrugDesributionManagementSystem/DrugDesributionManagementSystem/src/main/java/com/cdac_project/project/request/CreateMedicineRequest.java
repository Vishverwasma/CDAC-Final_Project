package com.cdac_project.project.request;

import java.time.LocalDate;

public class CreateMedicineRequest {

	// private Long Medicine_id;
	 private String Medicinename;
	 private Long Categoryid;
	 private Long MedicineQuantity;
	 private LocalDate ManufactureDate;
	 private Long UnitPrice;
	 
	 
	 
	 
	public CreateMedicineRequest() {
		super();
	}
	public CreateMedicineRequest( String medicine_name, Long category_id, Long medicine_Quantity,
			LocalDate manufacture_Date, Long unit_Price) {
		super();
		//Medicine_id = medicine_id;
		Medicinename = medicine_name;
		Categoryid = category_id;
		MedicineQuantity = medicine_Quantity;
		ManufactureDate = manufacture_Date;
		UnitPrice = unit_Price;
	}
//	public Long getMedicine_id() {
//		return Medicine_id;
//	}
//	public void setMedicine_id(Long medicine_id) {
//		Medicine_id = medicine_id;
//	}
	public String getMedicinename() {
		return Medicinename;
	}
	public void setMedicinename(String medicine_name) {
		Medicinename = medicine_name;
	}
	public Long getCategoryid() {
		return Categoryid;
	}
	public void setCategoryid(Long category_id) {
		Categoryid = category_id;
	}
	public Long getMedicineQuantity() {
		return MedicineQuantity;
	}
	public void setMedicineQuantity( Long medicine_Quantity) {
		MedicineQuantity = medicine_Quantity;
	}
	public LocalDate getManufactureDate() {
		return ManufactureDate;
	}
	public void setManufactureDate(LocalDate manufacture_Date) {
		ManufactureDate = manufacture_Date;
	}
	public Long getUnitPrice() {
		return UnitPrice;
	}
	public void setUnitPrice( Long unit_Price) {
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
