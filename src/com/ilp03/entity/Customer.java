package com.ilp03.entity;

public class Customer {

	private int customerId;
	private String customerName;
	private long customerPhone;
	private String customerMail;
	private String customerAddress;
	private Employee createdByEmployee;
	private Employee updatedByEmployee;
	public Customer(int customerId, String customerName, long customerPhone, String customerMail,
			String customerAddress, Employee createdByEmployee, Employee updatedByEmployee) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerMail = customerMail;
		this.customerAddress = customerAddress;
		this.createdByEmployee = createdByEmployee;
		this.updatedByEmployee = updatedByEmployee;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public long getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(long customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getCustomerMail() {
		return customerMail;
	}
	public void setCustomerMail(String customerMail) {
		this.customerMail = customerMail;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public Employee getCreatedByEmployee() {
		return createdByEmployee;
	}
	public void setCreatedByEmployee(Employee createdByEmployee) {
		this.createdByEmployee = createdByEmployee;
	}
	public Employee getUpdatedByEmployee() {
		return updatedByEmployee;
	}
	public void setUpdatedByEmployee(Employee updatedByEmployee) {
		this.updatedByEmployee = updatedByEmployee;
	}
	public Customer(int customerId, String customerName, long customerPhone, String customerMail,
			String customerAddress) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerMail = customerMail;
		this.customerAddress = customerAddress;
	}
	public Customer(int customerId) {
		super();
		this.customerId = customerId;
	}
}
