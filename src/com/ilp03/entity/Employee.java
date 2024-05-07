package com.ilp03.entity;

public class Employee {

	private int employeeId;
	private Department department;
	private String employeeName;
	private long employeePhone;
	private String employeeMail;
	private boolean isManager;
	private Employee createdByEmployee;
	private Employee updatedByEmployee;
	public Employee(int employeeId, Department department, String employeeName, long employeePhone, String employeeMail,
			boolean isManager, Employee createdByEmployee, Employee updatedByEmployee) {
		super();
		this.employeeId = employeeId;
		this.department = department;
		this.employeeName = employeeName;
		this.employeePhone = employeePhone;
		this.employeeMail = employeeMail;
		this.isManager = isManager;
		this.createdByEmployee = createdByEmployee;
		this.updatedByEmployee = updatedByEmployee;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public long getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(long employeePhone) {
		this.employeePhone = employeePhone;
	}
	public String getEmployeeMail() {
		return employeeMail;
	}
	public void setEmployeeMail(String employeeMail) {
		this.employeeMail = employeeMail;
	}
	public boolean isManager() {
		return isManager;
	}
	public void setManager(boolean isManager) {
		this.isManager = isManager;
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
	public Employee(int employeeId, String employeeName) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
	}
	public Employee(int employeeId) {
		super();
		this.employeeId = employeeId;
	}
}
