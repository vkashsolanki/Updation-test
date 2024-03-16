package com.update.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee_Details")
public class Employee {
	
	@Id
	@Column(name = "employee_Id")
	private int id;
	
	@Column(name = "employee_Name")
	private String name;
	
	@Column(name = "employee_Address")
	private String address;
	
	@Column(name = "employee_Number")
	private String number;
	
	
	public Employee() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
	public Employee(int id, String name, String address, String number) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.number = number;
	}
	
	
	

}
