package com.niit.model;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import org.springframework.stereotype.Component;

@Component
@Entity
public class SupplierModel {
	@Id
	private String id;
	@Column
	private String name;
		
	@Column 
	private String phonenumber;
	@Column 
	private String address;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	


}
