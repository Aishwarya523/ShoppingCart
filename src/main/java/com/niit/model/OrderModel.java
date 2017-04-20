package com.niit.model;



import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

import org.springframework.stereotype.Component;

	@Component
	@Entity
	
	@Table(name = "ORDERMODEL")
	public class OrderModel {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long orderId;
		@Column
		private String username;
			
		@Column 
		private int qty;
		@Column
		private String productprice;
		
		@Column
		private String amount;
		
		@Column
		private String mobile;

		@Column
		private String email;

		@Column
		private String address;
		
		
		public Long getOrderId() {
			return orderId;
		}

		public void setOrderId(Long orderId) {
			this.orderId = orderId;
		}

		

		public int getQty() {
			return qty;
		}

		public void setQty(int qty) {
			this.qty = qty;
		}

		public String getProductprice() {
			return productprice;
		}

		public void setProductprice(String productprice) {
			this.productprice = productprice;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getAmount() {
			return amount;
		}

		public void setAmount(String amount) {
			this.amount = amount;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
}
