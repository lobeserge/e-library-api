package com.elibrary.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.elibrary.model.Book;
import com.elibrary.repository.BookRepository;



@RestController
public class BooksController {

	@Autowired
	BookRepository bookRepository;
	
	@GetMapping("/books")
	public ResponseEntity<Object> retriveAllBooks(){
		return new ResponseEntity<>(bookRepository.findAll(),HttpStatus.OK);	
	}

	@GetMapping("/books/{id}")
	public ResponseEntity<Object> retriveOneBooks(@PathVariable int id){
		
		Optional<Book> book=bookRepository.findById(id);
		return new ResponseEntity<>(book,HttpStatus.OK);	
	}
	
	@PostMapping(path="/books")
	public ResponseEntity<Object> CreateNewBooks(@RequestBody Book book){
		
		Book newbook=bookRepository.save(book) ;
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newbook.getId()).toUri();
		return new ResponseEntity<>(location,HttpStatus.CREATED);	
		
	}
	
	@PutMapping(path="/books")
	public ResponseEntity<Object> updateBooks(@RequestBody Book book){
		Book newbook=bookRepository.save(book) ;
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newbook.getId()).toUri();
		return new ResponseEntity<>(location,HttpStatus.CREATED);	
		
	} 
	@DeleteMapping(path="/books/delete/{id}")
	public void DeleteBooks(@PathVariable int id){
	 bookRepository.deleteById(id);
	}
	

	@GetMapping("/books/name/{name}")
	public ResponseEntity<Object> searchbookbyname(@PathVariable String name){
		
		List<Book> book=(List<Book>)bookRepository.findByFirstnameLike(name);
		return new ResponseEntity<>(book,HttpStatus.OK);	
	}	
	
	
	
}
