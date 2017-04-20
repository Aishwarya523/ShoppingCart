package com.niit.model;



import javax.persistence.Column;
	import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Entity;
	import org.springframework.stereotype.Component;

	@Component
	@Entity
	
	@Table(name = "PRODUCTMODEL")
	public class ProductModel {
		@Id
		private String id;
		@Column
		private String name;
			
		@Column 
		private String description;
		@Column 
		private int productquantity;
		@Column 
		private String productprice;
		@Column(name = "categoryid")
		private String categoryId;
		@Column(name = "supplierid")
		private String supplierId;
		
		@ManyToOne
		@JoinColumn(name = "categoryid", updatable = false, insertable = false, nullable = false)
		private CategoryModel category;

		@ManyToOne
		@JoinColumn(name = "supplierid", updatable = false, insertable = false, nullable = false)
		private SupplierModel supplier;
		
		
		public String getCategoryId() {
			return categoryId;
		}
		public void setCategoryId(String categoryId) {
			this.categoryId = categoryId;
		}
		public String getSupplierId() {
			return supplierId;
		}
		public void setSupplierId(String supplierId) {
			this.supplierId = supplierId;
		}
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
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
		
		public int getProductquantity() {
			return productquantity;
		}
		public void setProductquantity(int productquantity) {
			this.productquantity = productquantity;
		}
		public String getProductprice() {
			return productprice;
		}
		public void setProductprice(String productprice) {
			this.productprice = productprice;
		}

}
