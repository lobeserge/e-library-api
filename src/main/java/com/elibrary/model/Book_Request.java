package com.elibrary.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book_Request {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String request_time;
	private String response_time;
	private int status;
	public Book_Request(int id, String request_time, String response_time, int status) {
		super();
		this.id = id;
		this.request_time = request_time;
		this.response_time = response_time;
		this.status = status;
	}
	public Book_Request() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRequest_time() {
		return request_time;
	}
	public void setRequest_time(String request_time) {
		this.request_time = request_time;
	}
	public String getResponse_time() {
		return response_time;
	}
	public void setResponse_time(String response_time) {
		this.response_time = response_time;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private User userId;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Book bookId;
	@JsonIgnore
	public User getUserId() {
		return userId;
	}
	
	public int getUser_Id() {
		return userId.getId();
	}
	
	public int getBook_Id() {
		return bookId.getId();
	}
	@JsonIgnore
	public void setUserId(User userId) {
		this.userId = userId;
	}
	@JsonIgnore
	public Book getBookId() {
		return bookId;
	}
	@JsonIgnore
	public void setBookId(Book bookId) {
		this.bookId = bookId;
	}
	
	
	
	
}
