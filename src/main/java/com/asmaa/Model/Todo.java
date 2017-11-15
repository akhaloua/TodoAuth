package com.asmaa.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Todos")
public class Todo {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="user")
	private String user;
	@Size(min = 10, message = "Enter atleast 10 Characters.")
	@Column(name="description")
	private String desc;
    @Temporal(TemporalType.DATE)
	@Column(name="targetDate")
	private Date targetDate;
	@Column(name="status")
	private boolean status;
	
	public Todo(int id, String user, String desc, Date targetDate, boolean status) {
		super(); 
		this.id = id;
		this.user = user;
		this.desc = desc;
		this.targetDate = targetDate;
		this.status = status;
	}
	public Todo() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if (id != other.id)
			return false;
		return true;
				
	}
	@Override
	public String toString() {
		
		return String.format(
				"Todo [id=%s, user=%s, desc=%s, targetDate=%s, status=%s]", id,
				user, desc, targetDate, status);
	}
	
	
}
