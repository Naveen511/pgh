package com.niche.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Used for entity creation.
 * @author niche0033
 */

@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id;
	private String first_name;
	private String last_name;
	private String user_name;
	private String email_id;
	private int contact_no;
	
	@CreationTimestamp
	// private Date created_at;
	private LocalDateTime created_at;
	
	@UpdateTimestamp
	private LocalDateTime updated_at;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public int getContact_no() {
		return contact_no;
	}
	public void setContact_no(int contact_no) {
		this.contact_no = contact_no;
	}
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	public LocalDateTime getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
	
	public User() {
		super();
	}
	
	public User(String first_name, String last_name, String user_name, String email_id, int contact_no, LocalDateTime created_at,
			LocalDateTime updated_at) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.user_name = user_name;
		this.email_id = email_id;
		this.contact_no = contact_no;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", user_name=" + user_name
				+ ", email_id=" + email_id + ", contact_no=" + contact_no + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + "]";
	}
	
	
}
