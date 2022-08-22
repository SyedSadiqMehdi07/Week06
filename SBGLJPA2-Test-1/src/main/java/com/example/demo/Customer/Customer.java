package com.example.demo.Customer;

import javax.persistence.Entity;
import javax.persistence.Table;

public class Customer {
	@Entity
	@Table(name = "customers")
	public class Customers {

		private long id;
		private String firstName;
		private int phoneno;
		private String Address;
		
		public Customers() {
			
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public int getPhoneno() {
			return phoneno;
		}

		public void setPhoneno(int phoneno) {
			this.phoneno = phoneno;
		}

		public String getAddress() {
			return Address;
		}

		public void setAddress(String address) {
			Address = address;
		}

		@Override
		public String toString() {
			return "Customers [id=" + id + ", firstName=" + firstName + ", phoneno=" + phoneno + ", Address=" + Address
					+ "]";
		}
		
}
}
