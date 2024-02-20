package com.cdac_project.project.request;

public class AddMedicinerequest {

	private int MedicineID;
	private int Quantity;
	private int UnitPrice;
	public AddMedicinerequest() {
		super();
	}
	public AddMedicinerequest(int medicineID, int quantity, int unitPrice) {
		super();
		MedicineID = medicineID;
		Quantity = quantity;
		UnitPrice = unitPrice;
	}
	public int getMedicineID() {
		return MedicineID;
	}
	public void setMedicineID(int medicineID) {
		MedicineID = medicineID;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public int getUnitPrice() {
		return UnitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		UnitPrice = unitPrice;
	}
	
}
