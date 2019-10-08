package com.elibrary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.elibrary.model.Book;
import com.elibrary.model.Book_Request;

public interface Book_Request_Repository  extends JpaRepository<Book_Request, Integer>{
	
}
