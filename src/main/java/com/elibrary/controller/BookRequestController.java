package com.elibrary.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.elibrary.model.Book;
import com.elibrary.model.Book_Request;
import com.elibrary.model.User;
import com.elibrary.repository.BookRepository;
import com.elibrary.repository.Book_Request_Repository;
import com.elibrary.repository.UserRepository;


@RestController
public class BookRequestController {

	
	@Autowired
	private Book_Request_Repository book_Request_Repository;
	

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BookRepository bookRepository;
	
	
	
	//retrive all book request
	@GetMapping("/bookrequest")
	public ResponseEntity<Object> retriveAllBooksRequest(){
		return new ResponseEntity<>(book_Request_Repository.findAll(),HttpStatus.OK);	
	}
	
	//retrive booksrequest for a particular user and a particular book
	@GetMapping(path="/bookrequest/users/{userid}/book/{bookid}")
	public List<Book_Request> retrieveUsersBookRequestForOneBook(@PathVariable("userid") int uid,@PathVariable("bookid") int bid){

		Optional<User> userOptional = userRepository.findById(uid);
		Optional<Book> bookOptional= bookRepository.findById(bid);
		if(!userOptional.isPresent() || !bookOptional.isPresent()) {
			System.out.print("user and/or book not found");
		}
		
		List<Book_Request> list=new ArrayList<>();
		list.addAll(userOptional.get().getBookRequestList());
		List<Book_Request> list2=new ArrayList<>();
		list2.addAll(bookOptional.get().getBookRequestList());
		list.retainAll(list2);
		return list;
		
	}
	//retrive all bookrequest for one user
	
	@GetMapping(path="/bookrequest/users/{id}")
	public List<Book_Request> retrieveAllUsersBookRequest(@PathVariable int id){
		Optional<User> user= userRepository.findById(id);
		if(!user.isPresent()) 
		     System.out.print("not found");
		
		return user.get().getBookRequestList();
		
	}

	//retrive all book request for a particular book
	@GetMapping(path="/bookrequest/book/{id}")
	public List<Book_Request> retrieveAllBookRequestForOneBook(@PathVariable int id){
		Optional<Book> book= bookRepository.findById(id);
		if(!book.isPresent()) 
		     System.out.print("not found");
		
		return book.get().getBookRequestList();
		
	}
	
	//create a book request
	@PostMapping(path="/bookrequest/users/{userid}/book/{bookid}")
	public ResponseEntity<Object> createBookRequest(@PathVariable("userid") int usersid,@PathVariable("bookid") int bookid, @RequestBody Book_Request bookrequestmodel) {
		
		Optional<User> userOptional = userRepository.findById(usersid);
		Optional<Book> bookOptional= bookRepository.findById(bookid);
		if(!userOptional.isPresent() || !bookOptional.isPresent()) {
			System.out.print("user and/or book not found");
		}

		User user = userOptional.get();
		Book book = bookOptional.get();
		
		bookrequestmodel.setUserId(user);
		bookrequestmodel.setBookId(book);
		bookrequestmodel.setRequest_time(new Date().toString());
		
		
		book_Request_Repository.save(bookrequestmodel);
		
		 URI location = ServletUriComponentsBuilder.
				 fromCurrentRequest()
				 .path("/{uid}/{bid}").
				 buildAndExpand(user.getId(),book.getId()).toUri();
		 return ResponseEntity.created(location).build();

	}
	
	//update a book request
		@PutMapping(path="/bookrequest/status/{uid}/{bookid}")
		public ResponseEntity<Object> acceptRequest(@PathVariable("uid") int id,@PathVariable("bookid") int bookid,@RequestBody Book_Request bookrequestmodel) {
			Optional<User> userOptional = userRepository.findById(id);
			Optional<Book> bookOptional= bookRepository.findById(bookid);
			User user = userOptional.get();
			Book book = bookOptional.get();
			bookrequestmodel.setBookId(new Book(book.getId()));
			bookrequestmodel.setStatus(1);
			bookrequestmodel.setUserId(new User(user.getId()));
			bookrequestmodel.setResponse_time(new Date().toString());
			
			
			book_Request_Repository.save(bookrequestmodel);
			
			 URI location = ServletUriComponentsBuilder.
					 fromCurrentRequest()
					 .path("").
					 buildAndExpand().toUri();
			 return ResponseEntity.created(location).build();

		}
	
	
	
		
}
