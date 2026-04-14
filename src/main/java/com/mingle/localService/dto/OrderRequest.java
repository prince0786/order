package com.mingle.localService.dto;

import java.util.*;

public class OrderRequest {

	private String orderNumber;
	private String status;
	private List<ParcelRequest> parcels;
	
	
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public List<ParcelRequest> getParcels() {
		return parcels;
	}
	public void setParcels(List<ParcelRequest> parcels) {
		this.parcels = parcels;
	}
	
	
	
	
	
}
