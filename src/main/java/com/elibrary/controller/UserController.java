package com.elibrary.controller;

import java.net.URI;
import java.util.Optional;

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

import com.elibrary.exception.UserNotFound;
import com.elibrary.model.User;
import com.elibrary.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	
	@GetMapping("/users")
	public ResponseEntity<Object> retriveAllUsers(){
		return new ResponseEntity<>(userRepository.findAll(),HttpStatus.OK);
		
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<Object> retriveOneUsers(@PathVariable int id ){
		
		Optional<User> user=userRepository.findById(id);
		if(!user.isPresent()) 
			throw new UserNotFound("user-id-"+id+" not found");
		
		return new ResponseEntity<>(user,HttpStatus.OK);
		
	}
	@DeleteMapping("/users/{id}")
	public void deleteUsers(@PathVariable int id ){
		userRepository.deleteById(id);
		
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUsers(@RequestBody User user ){
	
	User newuser = userRepository.save(user);
	URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(newuser.getId()).toUri();
	return new ResponseEntity<>(uri,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/users")
	public ResponseEntity<Object> updateUsers(@RequestBody User user ){
	
	User newuser = userRepository.save(user);
	URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(newuser.getId()).toUri();
	return new ResponseEntity<>(uri,HttpStatus.CREATED);
		
	}
	
	
	
	
	
	
	
	
}
