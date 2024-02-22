package com.cdac_project.request;

public class AddMedicineRequest {

	private int pID;
    private int medicineID;
    private int quantity;
    private int unitPrice;

    public AddMedicineRequest() {
        super();
    }

    public AddMedicineRequest(int pID,int medicineID, int quantity, int unitPrice) {
        super();
        this.pID=pID;
        this.medicineID = medicineID;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public int getpID() {
		return pID;
	}

	public void setpID(int pID) {
		this.pID = pID;
	}

	public int getMedicineID() {
        return medicineID;
    }

    public void setMedicineID(int medicineID) {
        this.medicineID = medicineID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }
}
