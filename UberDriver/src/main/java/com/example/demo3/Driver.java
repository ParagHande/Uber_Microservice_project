package com.example.demo3;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Driver {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer driver_id;
	private String driver_name;
	private Integer vehicle_no;
	
	public Integer getDriver_id() {
		return driver_id;
	}
	public void setDriver_id(Integer driver_id) {
		this.driver_id = driver_id;
	}
	public String getDriver_name() {
		return driver_name;
	}
	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}
	public Integer getVehicle_no() {
		return vehicle_no;
	}
	public void setVehicle_no(Integer vehicle_no) {
		this.vehicle_no = vehicle_no;
	}
	
	
	

}
