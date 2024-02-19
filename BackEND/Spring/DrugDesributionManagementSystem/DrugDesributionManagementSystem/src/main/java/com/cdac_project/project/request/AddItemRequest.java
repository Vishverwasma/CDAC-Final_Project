package com.cdac_project.project.request;

public class AddItemRequest {

	private Long Medicine_ID;
	private Long Quantity;
	private Long UnitPrice;
	public AddItemRequest() {
		super();
	}
	public AddItemRequest(Long medicine_ID, Long quantity, Long unitPrice) {
		super();
		Medicine_ID = medicine_ID;
		Quantity = quantity;
		UnitPrice = unitPrice;
	}
	public Long getMedicine_ID() {
		return Medicine_ID;
	}
	public void setMedicine_ID(Long medicine_ID) {
		Medicine_ID = medicine_ID;
	}
	public Long getQuantity() {
		return Quantity;
	}
	public void setQuantity(Long quantity) {
		Quantity = quantity;
	}
	public Long getUnitPrice() {
		return UnitPrice;
	}
	public void setUnitPrice(Long unitPrice) {
		UnitPrice = unitPrice;
	}
	
}
