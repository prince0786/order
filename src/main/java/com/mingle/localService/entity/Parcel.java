package com.mingle.localService.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "parcels")

public class Parcel { // 
	
	public Parcel() {}  //no argument constructor which are required by JPA
	
	public Parcel(String parcelNumber){
		this.parcelNumber = parcelNumber;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String parcelNumber;
	private Double weight;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getParcelNumber() {
		return parcelNumber;
	}

	public void setParcelNumber(String parcelNumber) {
		this.parcelNumber = parcelNumber;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
