package com.elibrary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.elibrary.model.Book;



public interface BookRepository extends JpaRepository<Book,Integer>{
	@Query("select c from Book c where c.title like %?1%")
    List<Book> findByFirstnameLike(String chars);
}
