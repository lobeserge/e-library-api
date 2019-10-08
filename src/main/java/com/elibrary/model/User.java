package com.elibrary.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String firstname;
	private String lastname;
	private String password;
	
	
	
	public User() {
		super();
	}



	public User(int id, String firstname, String lastname, String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
	}



	



	public User(int id) {
		super();
		this.id = id;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
	private List<Book_Request> bookRequestList;
	


	public List<Book_Request> getBookRequestList() {
		return bookRequestList;
	}



	public void setBookRequestList(List<Book_Request> bookRequestList) {
		this.bookRequestList = bookRequestList;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", password=" + password
				+ "]";
	}
	
	
	
	
	
	
}
