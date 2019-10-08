package com.elibrary.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private String lang;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "bookId")
	@JsonIgnore
	private List<Book_Request> bookRequestList;
	
	
	
	public List<Book_Request> getBookRequestList() {
		return bookRequestList;
	}



	public void setBookRequestList(List<Book_Request> bookRequestList) {
		this.bookRequestList = bookRequestList;
	}



	public Book() {
		super();
	}



	public Book(int id, String isbn, String title, String author, String publisher, String lang) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.lang = lang;
	}



	
	



	public Book(int id) {
		super();
		this.id = id;
	}



	public int getId() {
		return id;
	}
  


	public void setId(int id) {
		this.id = id;
	}



	public String getIsbn() {
		return isbn;
	}



	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public String getPublisher() {
		return publisher;
	}



	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}



	public String getLang() {
		return lang;
	}



	public void setLang(String lang) {
		this.lang = lang;
	}



	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", author=" + author + ", publisher="
				+ publisher + ", lang=" + lang + "]";
	}
	
	
	
	
	
}
