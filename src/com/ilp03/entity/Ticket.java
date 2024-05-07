package com.ilp03.entity;

import java.util.Date;

public class Ticket {

	private int ticketId;
	private Employee createdByEmployee;
	private Date createdOn;
	private Date updatedOn;
	private String ticketPriority;
	private String ticketStatus;
	private Employee assignedByEmployee;
	private Employee assignedToEmployee;
	public Ticket(int ticketId, Employee createdByEmployee, Date createdOn, Date updatedOn, String ticketPriority,
			String ticketStatus, Employee assignedByEmployee, Employee assignedToEmployee) {
		super();
		this.ticketId = ticketId;
		this.createdByEmployee = createdByEmployee;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.ticketPriority = ticketPriority;
		this.ticketStatus = ticketStatus;
		this.assignedByEmployee = assignedByEmployee;
		this.assignedToEmployee = assignedToEmployee;
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public Employee getCreatedByEmployee() {
		return createdByEmployee;
	}
	public void setCreatedByEmployee(Employee createdByEmployee) {
		this.createdByEmployee = createdByEmployee;
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
	public String getTicketPriority() {
		return ticketPriority;
	}
	public void setTicketPriority(String ticketPriority) {
		this.ticketPriority = ticketPriority;
	}
	public String getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	public Employee getAssignedByEmployee() {
		return assignedByEmployee;
	}
	public void setAssignedByEmployee(Employee assignedByEmployee) {
		this.assignedByEmployee = assignedByEmployee;
	}
	public Employee getAssignedToEmployee() {
		return assignedToEmployee;
	}
	public void setAssignedToEmployee(Employee assignedToEmployee) {
		this.assignedToEmployee = assignedToEmployee;
	}
	public Ticket(int ticketId, Employee createdByEmployee, String ticketPriority, String ticketStatus,
			Employee assignedByEmployee, Employee assignedToEmployee) {
		super();
		this.ticketId = ticketId;
		this.createdByEmployee = createdByEmployee;
		this.ticketPriority = ticketPriority;
		this.ticketStatus = ticketStatus;
		this.assignedByEmployee = assignedByEmployee;
		this.assignedToEmployee = assignedToEmployee;
	}
}
