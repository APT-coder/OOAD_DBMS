package com.ilp03.entity;

import java.util.Date;

public class CustomerSupport {

	private Employee employee;
	private Customer customer;
	private String customerServiceIssueTitle;
	private String customerServiceIssueDescription;
	private int customerServiceIssueId;
	private Date createdOn;
	private Date updatedOn;
	public CustomerSupport(Employee employee, Customer customer, String customerServiceIssueTitle,
			String customerServiceIssueDescription, int customerServiceIssueId, Date createdOn, Date updatedOn) {
		super();
		this.employee = employee;
		this.customer = customer;
		this.customerServiceIssueTitle = customerServiceIssueTitle;
		this.customerServiceIssueDescription = customerServiceIssueDescription;
		this.customerServiceIssueId = customerServiceIssueId;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getCustomerServiceIssueTitle() {
		return customerServiceIssueTitle;
	}
	public void setCustomerServiceIssueTitle(String customerServiceIssueTitle) {
		this.customerServiceIssueTitle = customerServiceIssueTitle;
	}
	public String getCustomerServiceIssueDescription() {
		return customerServiceIssueDescription;
	}
	public void setCustomerServiceIssueDescription(String customerServiceIssueDescription) {
		this.customerServiceIssueDescription = customerServiceIssueDescription;
	}
	public int getCustomerServiceIssueId() {
		return customerServiceIssueId;
	}
	public void setCustomerServiceIssueId(int customerServiceIssueId) {
		this.customerServiceIssueId = customerServiceIssueId;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	public CustomerSupport(Employee employee, Customer customer, String customerServiceIssueTitle,
			String customerServiceIssueDescription, int customerServiceIssueId) {
		super();
		this.employee = employee;
		this.customer = customer;
		this.customerServiceIssueTitle = customerServiceIssueTitle;
		this.customerServiceIssueDescription = customerServiceIssueDescription;
		this.customerServiceIssueId = customerServiceIssueId;
	}
}
